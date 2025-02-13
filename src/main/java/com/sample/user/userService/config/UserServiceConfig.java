package com.sample.user.userService.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserServiceConfig {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}

}
