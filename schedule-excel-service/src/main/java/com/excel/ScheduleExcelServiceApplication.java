package com.excel;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author PraveenKumarReddy
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableFeignClients
@EnableEurekaClient
@EnableScheduling
public class ScheduleExcelServiceApplication  {

	public static void main(String[] args) {
		
		SpringApplication.run(ScheduleExcelServiceApplication.class, args);
		
	}
	

}
