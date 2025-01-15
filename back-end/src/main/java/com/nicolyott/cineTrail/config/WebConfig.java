package com.nicolyott.cineTrail.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir todas as rotas
                .allowedOrigins("http://localhost:5173") // Permitir apenas o React em localhost:5173
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir os métodos necessários
                .allowedHeaders("*"); // Permitir qualquer cabeçalho
    }
}
