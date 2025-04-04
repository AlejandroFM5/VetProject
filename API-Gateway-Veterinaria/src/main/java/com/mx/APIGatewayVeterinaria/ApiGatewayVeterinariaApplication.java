package com.mx.APIGatewayVeterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayVeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayVeterinariaApplication.class, args);
	}

}
