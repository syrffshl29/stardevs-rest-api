//package com.starcodes.tabungin.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Matikan CSRF
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/auth/register", "/api/auth/login").permitAll()
//                        .anyRequest().authenticated() // Semua endpoint bebas akses
//                )
//                .httpBasic(Customizer.withDefaults()); // Pakai basic auth (jika nanti diperlukan)
//
//        return http.build();
//    }
//}
