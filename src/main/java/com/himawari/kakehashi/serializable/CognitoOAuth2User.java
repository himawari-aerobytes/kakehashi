package com.himawari.kakehashi.serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CognitoOAuth2User implements OAuth2User, Serializable {

    private Set authorities;
    private Map attributes;
    private String nameAttributeKey;
    private String sub;
    private String email_verified;
    private String name;
    private String given_name;
    private String family_name;
    private String email;
    private String username;
    @JsonProperty("custom:isAdmin")
    private int isAdmin;

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return name;
    }
}