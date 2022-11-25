package com.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author PraveenKumarReddy
 *
 */
@SpringBootApplication
@EnableEurekaServer

public class ScheduleEurekaRegistryApplication {

	/**
	 * @param args for passing arguments
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(ScheduleEurekaRegistryApplication.class, args);
	}

}
