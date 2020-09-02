package br.com.healthtrack.platform.config;

import br.com.healthtrack.platform.security.HospitalUserDetailsService;
import br.com.healthtrack.platform.security.filter.JwtTokenFilter;
import br.com.healthtrack.platform.security.jwt.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    HospitalUserDetailsService hospitalUserDetailsService;

    @Autowired
    JwtTokenService jwtTokenService;

    @Override
    protected UserDetailsService userDetailsService() {
        return hospitalUserDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .httpBasic().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/health", "/auth").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(new JwtTokenFilter(jwtTokenService, hospitalUserDetailsService),
                UsernamePasswordAuthenticationFilter.class);
    }
}
