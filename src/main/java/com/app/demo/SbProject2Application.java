package com.app.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RestController

public class SbProject2Application {
	
	@GetMapping("/hello")
	public String getMessage() {
		return "Welcome to jenkins ci/cd deploy";
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Spring Boot");
		SpringApplication.run(SbProject2Application.class, args);
	}
		 
}
