package com.progesco.progescoschooling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
@EnableJpaAuditing
public class ProgescoSchoolingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgescoSchoolingApplication.class, args);
	}

}
