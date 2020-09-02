package br.com.healthtrack.platform.service;

import org.springframework.security.core.context.SecurityContextHolder;

public abstract class UserBasedApiService {

    public UserBasedApiService() {
    }

    public Object getPrincipalFromSecurityContext() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
