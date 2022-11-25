package com.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author PraveenKumarReddy
 *
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient

public class ScheduleConfigServiceApplication {

	/**
	 * @param args for passing arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ScheduleConfigServiceApplication.class, args);
	}

}
