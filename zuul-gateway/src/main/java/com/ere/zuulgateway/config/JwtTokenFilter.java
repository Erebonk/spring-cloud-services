package com.ere.zuulgateway.config;

import com.ere.zuulgateway.component.JwtComponent;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtComponent jwtComponent;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var header = request.getHeader(jwtComponent.getHeader());

        if (header == null || !header.startsWith(jwtComponent.getPrefix())) {
            filterChain.doFilter(request, response);
        } else {
            try {
                var token = header.replace(jwtComponent.getPrefix(), "");
                var claims = Jwts.parser()
                        .setSigningKey(jwtComponent.getSecret().getBytes())
                        .parseClaimsJws(token)
                        .getBody();

                var username = claims.getSubject();

                if(username != null) {
                    var authorities = (List<String>) claims.get("authorities");
                    var auth = new UsernamePasswordAuthenticationToken(
                            username, null, authorities.stream()
                            .map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            } catch (Exception ex) {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        }
    }

}
