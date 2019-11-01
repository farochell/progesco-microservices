package com.progesco.progescoadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaAuditing
@EnableDiscoveryClient
public class ProgescoAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProgescoAdminApplication.class, args);
	}

}
