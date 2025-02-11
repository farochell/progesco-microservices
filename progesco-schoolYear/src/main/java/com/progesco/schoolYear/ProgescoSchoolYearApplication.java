package com.progesco.schoolYear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
@EnableJpaAuditing
public class ProgescoSchoolYearApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgescoSchoolYearApplication.class, args);
	}

}
