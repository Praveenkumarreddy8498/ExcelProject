package com.schedule.service;

import java.util.List;

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
	 * @param schedule
	 * @return schedule that is added
	 */
	Schedule addSchedule(Schedule schedule);

	/**This method pass the value to repository and get the return value
	 * @param day
	 * @return list of schedule
	 */
	List<Schedule> getByDay(String day);

}
