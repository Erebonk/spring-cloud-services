package com.ere.zuulgateway.config;


import com.ere.zuulgateway.component.JwtComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityCandidateConfig extends WebSecurityConfigurerAdapter {

    private final JwtComponent jwtComponent;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint((req, rsp, e) ->
                    rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                    .addFilterAfter(new JwtTokenFilter(jwtComponent), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, jwtComponent.getUri()).permitAll()
                .anyRequest().authenticated();
    }

}
