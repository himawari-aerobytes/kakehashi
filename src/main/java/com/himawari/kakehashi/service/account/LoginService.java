package com.himawari.kakehashi.service.account;

import com.himawari.kakehashi.domain.User;
import com.himawari.kakehashi.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.himawari.kakehashi.constants.ManagementCode.ENABLED_USER;

public class LoginService implements UserDetails {

    private final User user;
    private final Collection<? extends GrantedAuthority> authorities;

    @Autowired
    private RoleMapper roleMapper;

    public LoginService(User user) {
        this.user = user;
        this.authorities = roleMapper
                .selectByExample(null)
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getIsEnabled() == ENABLED_USER;
    }
}
