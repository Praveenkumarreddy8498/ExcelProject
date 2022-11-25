package com.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.schedule.model.Schedule;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IScheduleService {

	/***This method will get the data from repository
	 * @return list of schedule
	 */
	List<Schedule> getAll();

	/**This method pass the value to repository and get the return value 
	 * @param schedule for passing the schedule
	 * @return schedule that is added
	 */
	Schedule addSchedule(Schedule schedule);

	/**This method pass the value to repository and get the return value
	 * @param day for passing the day
	 * @return list of schedule
	 */
	List<Schedule> getByDay(String day);

}
