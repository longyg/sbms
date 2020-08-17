package com.yglong.sbms.admin.util;

import com.yglong.sbms.admin.security.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取Token并认证
 */
public class SecurityUtils {
    /**
     * 登录认证
     * @param request
     * @param username
     * @param password
     * @param authenticationManager
     * @return
     */
    public static JwtAuthenticationToken login(HttpServletRequest request, String username,
                                               String password, AuthenticationManager authenticationManager) {
        JwtAuthenticationToken token = new JwtAuthenticationToken(username, password);
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        // 执行认证
        Authentication authentication = authenticationManager.authenticate(token);
        // 保存认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 生成令牌
        token.setToken(JwtTokenUtils.generateToken(authentication));
        return token;
    }
    /**
     * 从请求中获取Token，并认证
     * @param request
     */
    public static void checkAuthentication(HttpServletRequest request) {
        // 从请求中获取Token，并生成认证信息
        Authentication authentication = JwtTokenUtils.getAuthenticationFromToken(request);
        // 保存登录认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    /**
     * 获取当前登录信息
     * @return
     */
    public static Authentication getAuthentication() {
        if (SecurityContextHolder.getContext() == null) {
            return null;
        }
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前登录用户
     * @return
     */
    public static String getUsername() {
        return getUsername(getAuthentication());
    }

    /**
     * 从登录信息中获取用户名
     * @param authentication
     * @return
     */
    public static String getUsername(Authentication authentication) {
        if (null != authentication) {
            Object principal = authentication.getPrincipal();
            if (null != principal && principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername();
            }
        }
        return null;
    }
}
