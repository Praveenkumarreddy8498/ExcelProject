package com.excel.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.excel.model.Schedule;


/**
 * This class acts as a feign client(Declarative Client) 
 * @author PraveenKumarReddy
 *
 */
@FeignClient(name = "SCHEDULE-SERVICE")
public interface IScheduleService {
	
	/** This method is used to map with the url 
	 * @param day
	 * @return List of schedule
	 */
	@GetMapping("schedule/day/{day}")
	List<Schedule> getByDay(@PathVariable("day") String day);
	
}
