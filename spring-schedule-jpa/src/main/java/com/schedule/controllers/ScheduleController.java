package com.schedule.controllers;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.model.Schedule;
import com.schedule.service.IScheduleService;

/**
 * @author PraveenKumarReddy
 *
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	private Logger logger = LoggerFactory.getLogger(ScheduleController.class);
	@Autowired
	IScheduleService scheduleService;

	/**
	 * This method is used to map with the url
	 * 
	 * @return List of tasks in a schedule as a response entity
	 */
	@GetMapping("/get")
	public ResponseEntity<List<Schedule>> getAll() {
		logger.info("showing the schedule");
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "It returns the schedule");

		List<Schedule> schedule = scheduleService.getAll();

		ResponseEntity<List<Schedule>> responseEntity = new ResponseEntity<List<Schedule>>(schedule, header,
				HttpStatus.OK);
		return responseEntity;
	}

	/**
	 * This method is used to map with the URI and adds the schedule
	 * 
	 * @param schedule for passing the schedule object
	 * @return Schedule that is added
	 */
	@PostMapping("/add")
	public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) {
		logger.info("Adding task to schedule");
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "It adds a task to schedule");

		Schedule schedule2 = scheduleService.addSchedule(schedule);

		ResponseEntity<Schedule> responseEntity = new ResponseEntity<Schedule>(schedule2, header, HttpStatus.OK);
		return responseEntity;
	}

	/**
	 * This method is used to map with the URI and get the schedule based on day
	 * input
	 * 
	 * @param day for passing day value
	 * @return List of tasks per day in a schedule as a response entity
	 */
	@GetMapping("/day/{day}")
	public ResponseEntity<List<Schedule>> getByDay(@PathVariable("day") String day) {
		logger.info("showing the schedule by Day");
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "It returns the schedule by Day");
		List<Schedule> schedule = scheduleService.getByDay(day);
		ResponseEntity<List<Schedule>> responseEntity = new ResponseEntity<List<Schedule>>(schedule, header,
				HttpStatus.OK);
		return responseEntity;
	}

}
