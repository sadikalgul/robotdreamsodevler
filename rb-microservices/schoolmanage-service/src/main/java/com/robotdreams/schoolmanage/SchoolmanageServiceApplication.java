package com.robotdreams.schoolmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
		scanBasePackages = {
				"com.robotdreams.schoolmanage",
				"com.robotdreams.rabbitMQ"
		}
)
@EnableEurekaClient
@EnableFeignClients(
		basePackages = {
				"com.robotdreams.client.notification"
		}
)
public class SchoolmanageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolmanageServiceApplication.class, args);
	}

}
