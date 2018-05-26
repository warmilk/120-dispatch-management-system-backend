package com.emgcy120.core.common.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class ShiroOAuthToken implements AuthenticationToken{

    private static final long serialVersionUID = 7974988491817676282L;

    private String token;

    public ShiroOAuthToken(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
