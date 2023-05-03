package com.achsat.crypto.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(
                (auth) -> auth
                        .requestMatchers("/customer/get").hasAuthority("SCOPE_customer-inquiry")
                        .requestMatchers("/customer/create").hasAuthority("SCOPE_customer-update")
                        .anyRequest()
                        .authenticated()
                ).oauth2ResourceServer(
                resourceServer -> resourceServer.jwt(Customizer.withDefaults())
        );

        return http.build();
    }

}
