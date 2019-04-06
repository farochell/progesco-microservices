package com.progesco.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.progesco")
public class ProgescoClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgescoClientApplication.class, args);
	}

}
