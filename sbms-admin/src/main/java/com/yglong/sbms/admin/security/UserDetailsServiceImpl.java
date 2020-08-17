package com.yglong.sbms.admin.security;

import com.yglong.sbms.admin.entity.SysUser;
import com.yglong.sbms.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.findByName(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        Set<String> permissions = sysUserService.findPermissions(sysUser.getName());
        List<GrantedAuthority> grantedAuthorityList = permissions.stream().map(GrantedAuthorityImpl::new)
                .collect(Collectors.toList());
        return new JwtUserDetails(sysUser.getName(), sysUser.getPassword(), sysUser.getSalt(), grantedAuthorityList);
    }
}
