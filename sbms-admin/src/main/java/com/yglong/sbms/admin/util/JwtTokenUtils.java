package com.yglong.sbms.admin.util;

import com.yglong.sbms.admin.security.GrantedAuthorityImpl;
import com.yglong.sbms.admin.security.JwtAuthenticationToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class JwtTokenUtils {
    private static final String AUTHORITIES = "authorities";
    private static final String SECRET = "abcdefgh";
    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;

    public static Authentication getAuthenticationFromToken(HttpServletRequest request) {
        Authentication authentication = null;
        String token = getToken(request);
        if (null != token) {
            // 如果当前没有登录信息，表示没有登录
            // 就生成一个新的登录认证信息Authentication对象
            if (SecurityUtils.getAuthentication() == null) {
                Claims claims = getClaimsFromToken(token);
                if (null == claims) {
                    return null;
                }
                String username = claims.getSubject();
                if (null == username) {
                    return null;
                }

                if (isTokenExpired(token)) {
                    return null;
                }

                Object authorities = claims.get(AUTHORITIES);
                List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
                if (null != authorities && authorities instanceof List) {
                    for (Object auth : (List) authorities) {
                        grantedAuthorityList.add(new GrantedAuthorityImpl((String)((Map)auth).get("authority")));
                    }
                }
                // 生成一个新的Token
                authentication = new JwtAuthenticationToken(username, null, grantedAuthorityList, token);
            } else {
                if (validateToken(token, SecurityUtils.getUsername())) {
                    // 如果已经登录，检查Token合法性，并直接返回当前已登录的认证信息
                    authentication = SecurityUtils.getAuthentication();
                }
            }
        }
        return authentication;
    }

    /**
     * 检查Token是否过期
     * @param token
     * @return
     */
    private static boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 从Token中获取Claims
     * @param token
     * @return
     */
    public static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public static boolean validateToken(String token, String username) {
        return (username.equals(getUsernameFromToken(token)) && !isTokenExpired(token));
    }

    public static String getUsernameFromToken(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 从请求头中获取Token
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String tokenHead = "Bearer ";
        if (null == token) {
            token = request.getHeader("token");
        } else if (token.contains(tokenHead)) {
            token = token.substring(tokenHead.length());
        }
        if ("".equals(token)) {
            token = null;
        }
        return token;
    }

    public static String generateToken(Authentication authentication) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.SUBJECT, SecurityUtils.getUsername(authentication));
        claims.put("created", new Date());
        claims.put(AUTHORITIES, authentication.getAuthorities());
        return generateToken(claims);
    }

    public static String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }
}
