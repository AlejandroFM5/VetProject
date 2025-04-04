package com.mx.APIGatewayVeterinaria.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer{
public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**")
	.allowedHeaders("*")
	.allowedOrigins("http://localhost:4200")
	.allowedMethods("GET","POST","PUT","DELETE")
	.allowCredentials(true);
}
}
