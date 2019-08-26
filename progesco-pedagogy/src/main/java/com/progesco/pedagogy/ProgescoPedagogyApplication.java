package com.progesco.pedagogy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProgescoPedagogyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgescoPedagogyApplication.class, args);
	}

}
