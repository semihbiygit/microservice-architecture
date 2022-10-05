package com.semih.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class AuthSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/v3/api-docs/**","/v1/api/auth/**","/swagger-ui/**").permitAll()
                .anyRequest().authenticated();
                http.addFilterBefore(null,null);

        return http.build();

    }

}
