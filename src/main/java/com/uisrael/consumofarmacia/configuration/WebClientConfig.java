package com.uisrael.consumofarmacia.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
	@Bean
	WebClient wevClient(WebClient.Builder builder) {
		return builder.baseUrl("http://localhost:8083/api").build();// fines academicos
	}

}
