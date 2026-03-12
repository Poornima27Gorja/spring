package com.lpu.bank_profileDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProfileDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileDemoApplication.class, args);
	}

}
