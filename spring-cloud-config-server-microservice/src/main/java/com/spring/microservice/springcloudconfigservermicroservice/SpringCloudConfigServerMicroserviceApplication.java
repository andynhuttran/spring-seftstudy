package com.spring.microservice.springcloudconfigservermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerMicroserviceApplication.class, args);
	}

}
