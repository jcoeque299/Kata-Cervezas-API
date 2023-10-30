package com.example.KataCervezas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:9090") //No hay ningun cliente configurado para el puerto 9090, pero si programase uno, lo lanzaria en este puerto
                        .allowedMethods("GET","POST","PUT","PATCH","DELETE")
                        .maxAge(3600);

            }
        };
    }
}
