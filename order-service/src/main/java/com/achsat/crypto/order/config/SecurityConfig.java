package com.achsat.crypto.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(
                (auth) -> auth
                        .requestMatchers("/orders/inq/**").hasAuthority("SCOPE_order-inquiry")
                        .requestMatchers("/orders/fin/**").hasAuthority("SCOPE_order-financial")
                        .anyRequest()
                        .authenticated()
        ).oauth2ResourceServer(
                resourceServer -> resourceServer.jwt(Customizer.withDefaults())
        );

        return http.build();
    }

}
