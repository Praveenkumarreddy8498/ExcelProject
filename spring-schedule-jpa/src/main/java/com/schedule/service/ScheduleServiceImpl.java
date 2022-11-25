package com.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);
	@Autowired
	IScheduleRepository scheduleRepository;

	/**
	 * This method will get the data from repository
	 * 
	 * @return list of schedule
	 */
	@Override
	public List<Schedule> getAll() {
		logger.info("Getting the schedule in service");

		List<Schedule> schedule = scheduleRepository.findAll();
		if (schedule.isEmpty()) {
			logger.warn("Exception occured while getting the schedule");
			throw new ScheduleNotFoundException();
		}
		logger.info("Got the schedule in service");

		return schedule;
	}

	/**
	 * This method pass the value to repository and get the return value
	 * 
	 * @param schedule for passing the schedule object
	 * @return schedule object that is added
	 */
	@Override
	public Schedule addSchedule(Schedule schedule) {
		logger.info("Adding the schedule to repository");
		Schedule addedSchedule=scheduleRepository.save(schedule);
		logger.info("Added the schedule to database");
		return addedSchedule; 
	}

	/**
	 * This method pass the value to repository and get the return value
	 * 
	 * @param day for passing day value
	 * @return List of schedule
	 */
	@Override
	public List<Schedule> getByDay(String day) {
		logger.info("Getting the schedule by day in service");

		List<Schedule> schedule = scheduleRepository.findByDay(day);

		if (schedule.isEmpty()) {
			logger.warn("Exception occured while getting by day");
			throw new ScheduleNotFoundException();
		}
		logger.info("Got the schedule by day in service");

		return schedule;
	}

}
