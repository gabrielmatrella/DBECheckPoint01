package br.com.healthtrack.platform.security;

import br.com.healthtrack.platform.domain.Credencial;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class HospitalUserDetails implements UserDetails {

    private Credencial credencial;

    public HospitalUserDetails() {
    }

    public HospitalUserDetails(Credencial credencial) {
        this.credencial = credencial;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections
                .singleton(new SimpleGrantedAuthority(credencial.getTipoUsuario().toString()));
    }

    @Override
    public String getPassword() {
        return credencial.getSenha();
    }

    @Override
    public String getUsername() {
        return credencial.getCodigo().toString();
    }

    public Credencial getCredencial() {
        return credencial;
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
        return true;
    }
}
