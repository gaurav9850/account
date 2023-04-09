package com.account.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UsersApplication{

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
		System.out.println("======================================");
		System.out.println("USER SERVICE STARTED");
		System.out.println("======================================");
	}
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}