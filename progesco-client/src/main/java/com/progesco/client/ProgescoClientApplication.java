package com.progesco.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.progesco")
@EnableDiscoveryClient
public class ProgescoClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgescoClientApplication.class, args);
	}

}
