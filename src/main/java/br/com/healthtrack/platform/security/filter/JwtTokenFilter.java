package br.com.healthtrack.platform.security.filter;

import br.com.healthtrack.platform.security.HospitalUserDetailsService;
import br.com.healthtrack.platform.security.jwt.JwtTokenService;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class JwtTokenFilter extends OncePerRequestFilter {

    JwtTokenService jwtTokenService;

    HospitalUserDetailsService hospitalUserDetailsService;

    public JwtTokenFilter(JwtTokenService jwtTokenService, HospitalUserDetailsService hospitalUserDetailsService) {
        this.jwtTokenService = jwtTokenService;
        this.hospitalUserDetailsService = hospitalUserDetailsService;
    }

    private Optional<String> extractJwtFromRequest(HttpServletRequest httpServletRequest) {
        String authorization = httpServletRequest.getHeader("Authorization");

        if (authorization != null && authorization.startsWith("Bearer ")) {
            return Optional.of(authorization.substring("Bearer ".length() - 1));
        }

        return Optional.empty();
    }

    @Override
    public void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Optional<String> optJwt = extractJwtFromRequest(servletRequest);

        if (optJwt.isPresent()) {
            String jwt = optJwt.get();
            Optional<Claims> optClaims = jwtTokenService.retrieveClaims(jwt);

            if (optClaims.isPresent()) {
                Claims claims = optClaims.get();
                String subject = claims.getSubject();
                UserDetails userDetails = hospitalUserDetailsService.loadUserByCodigo(Integer.parseInt(subject));

                SecurityContextHolder.getContext().setAuthentication(new
                        UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities()));
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
