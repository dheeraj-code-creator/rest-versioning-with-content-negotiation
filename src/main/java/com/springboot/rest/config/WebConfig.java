package com.springboot.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	public void configureContentNegotiation(ContentNegotiationConfigurer congifurer) {
		congifurer.defaultContentType(MediaType.APPLICATION_JSON);

	}

}
