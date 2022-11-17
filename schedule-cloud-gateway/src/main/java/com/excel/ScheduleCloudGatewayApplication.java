package com.excel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

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
