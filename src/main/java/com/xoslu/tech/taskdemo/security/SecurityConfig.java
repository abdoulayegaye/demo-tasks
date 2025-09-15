package com.xoslu.tech.taskdemo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/tasks/public").permitAll()   // accessible sans login
                        .anyRequest().authenticated()                   // tout le reste nécessite un token
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt());      // activer JWT
        return http.build();
    }
}
