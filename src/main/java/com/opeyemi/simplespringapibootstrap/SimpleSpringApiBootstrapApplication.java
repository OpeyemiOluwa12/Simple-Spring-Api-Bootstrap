package com.opeyemi.simplespringapibootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SimpleSpringApiBootstrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringApiBootstrapApplication.class, args);
	}

}
