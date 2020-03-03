package com.ere.authserver.config;

import com.ere.authserver.domain.UserCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Filters
 *  first: try to find out user
 *  second: create token
 *
 * @author ilya
 * @version 1.0
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtSecurityComponent jwtSecurityComponent;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtSecurityComponent jwtSecurityComponent) {
        this.authenticationManager = authenticationManager;
        this.jwtSecurityComponent = jwtSecurityComponent;
        this.setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher(jwtSecurityComponent.getUri(), "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            var userCredentials = new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);
            var authToken = new UsernamePasswordAuthenticationToken(
                    userCredentials.getUsername(), userCredentials.getPassword(), Collections.emptyList());
            return authenticationManager.authenticate(authToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        var now = System.currentTimeMillis();
        var token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + jwtSecurityComponent.getExpiration() * 1000))  // in milliseconds
                .signWith(SignatureAlgorithm.HS512, jwtSecurityComponent.getSecret().getBytes())
                .compact();
        response.addHeader(jwtSecurityComponent.getHeader(), jwtSecurityComponent.getPrefix() + token);
    }
}
