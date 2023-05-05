package com.achsat.crypto.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) throws Exception {
        http.authorizeExchange(
                    (authorize)-> authorize
                            .pathMatchers("/account/inq/bo/**").hasAuthority("SCOPE_account-inquiry-backoffice")
                            .pathMatchers("/account/fin/**").hasAuthority("SCOPE_account-financial")
                            .anyExchange().authenticated()
                )
                .oauth2ResourceServer(
                        (resourceServer)-> resourceServer.jwt(Customizer.withDefaults())
                );
        return http.build();
    }
}
