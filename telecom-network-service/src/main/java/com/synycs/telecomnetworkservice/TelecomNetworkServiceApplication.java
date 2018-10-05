package com.synycs.telecomnetworkservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.synycs")
@EnableJpaRepositories
@SpringBootApplication
@EntityScan
public class TelecomNetworkServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelecomNetworkServiceApplication.class, args);
	}
}
