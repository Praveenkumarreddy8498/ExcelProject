package com.schedule.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.exceptions.ScheduleNotFoundException;
import com.schedule.model.Schedule;
import com.schedule.repository.IScheduleRepository;


/**
 * @author PraveenKumarReddy
 *
 */
@Service
public class ScheduleServiceImpl implements IScheduleService {
	@Autowired
	IScheduleRepository scheduleRepository;

	/**This method will get the data from repository
	 * @return list of schedule
	 */
	@Override
	public List<Schedule> getAll() {
		 List<Schedule> schedule=scheduleRepository.findAll();
		if(schedule.isEmpty())
			throw new ScheduleNotFoundException();
		return schedule;
	}
	

	/**
	 * This method pass the value to repository and get the return value 
	 * @param schedule for passing the schedule object
	 * @return schedule object that is added 
	 */
	@Override
	public Schedule addSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}
	/**
	 * This method pass the value to repository and get the return value 
	 * @param day for passing day value
	 * @return List of schedule
	 */
	@Override

	public List<Schedule> getByDay(String day) {
		 List<Schedule> schedule=scheduleRepository.findByDay(day);
			if(schedule.isEmpty())
				throw new ScheduleNotFoundException();
		return schedule;
	}
	
	
}
