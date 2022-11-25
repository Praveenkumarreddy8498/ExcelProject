package com.excel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
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
