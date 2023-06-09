package com.achsat.crypto.coin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
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
                        .requestMatchers("/coins/inq/**").hasAuthority("SCOPE_coins-inquiry")
                        .requestMatchers("/coins/fin/**").hasAuthority("SCOPE_coins-financial")
                        .anyRequest()
                        .authenticated()
        ).oauth2ResourceServer(
                resourceServer -> resourceServer.jwt(Customizer.withDefaults())
        );

        return http.build();
    }

}
