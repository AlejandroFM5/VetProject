package com.mx.APIGatewayVeterinaria.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

public class SecurityConfig {
	
	// Configuración CORS
//    @Bean
//    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.addAllowedOrigin("http://localhost:4200"); 
//        corsConfig.addAllowedMethod(HttpMethod.GET); 
//        corsConfig.addAllowedMethod(HttpMethod.POST);
//        corsConfig.addAllowedMethod(HttpMethod.PUT);  
//        corsConfig.addAllowedMethod(HttpMethod.DELETE); 
//        corsConfig.addAllowedHeader("*"); 
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig); 
//        return source;
//    }
////
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .cors().configurationSource(corsConfigurationSource())
//            .and()
//            .authorizeRequests()
//                .requestMatchers(HttpMethod.GET, "/clientes/listar", "/mascotas/listar", "/responsables/listar", "/gestion/listar").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.POST, "/clientes/buscar-id", "/mascotas/buscar-id", "/responsables/buscar-id", "/gestion/buscar-id").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.PUT, "/clientes/editar", "/mascotas/editar", "/responsables/editar", "/gestion/editar").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.DELETE, "/clientes/eliminar", "/mascotas/eliminar", "/responsables/eliminar", "/gestion/eliminar").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .csrf().disable();
//        
//        return http.build();
//    }
//	 
}
