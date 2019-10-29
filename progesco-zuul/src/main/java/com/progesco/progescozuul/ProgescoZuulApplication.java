package com.progesco.progescozuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableJpaAuditing
@EnableConfigurationProperties
public class ProgescoZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProgescoZuulApplication.class, args);
	}

}
