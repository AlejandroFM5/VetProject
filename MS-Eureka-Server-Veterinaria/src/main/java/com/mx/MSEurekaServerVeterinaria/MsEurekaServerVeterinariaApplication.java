package com.mx.MSEurekaServerVeterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsEurekaServerVeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEurekaServerVeterinariaApplication.class, args);
	}

}
