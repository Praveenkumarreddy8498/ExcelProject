package com.excel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author PraveenKumarReddy
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ScheduleCloudGatewayApplication {
	/**
	 * @param args for passing arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ScheduleCloudGatewayApplication.class, args);
	}

}
