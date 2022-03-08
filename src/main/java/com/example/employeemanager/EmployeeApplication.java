package com.example.employeemanager;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public CorsFilter CorsFilter() {
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration = new CorsConfiguration();
        
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","PATCH"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Jwt-Token", "Origin Accept", "X-Requested-With"));
        configuration.setExposedHeaders(Arrays.asList("Authorization", "Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Jwt-Token", "Origin Accept", "Filename", "Access-Control-Allow-Credentials"));

        source.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(source);
	}

}
