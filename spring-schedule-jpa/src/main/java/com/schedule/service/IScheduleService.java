package com.schedule.service;

import java.util.List;

import com.schedule.model.Schedule;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IScheduleService {

	/***This method will get the data from repository
	 * @return
	 */
	List<Schedule> getAll();

	/**This method pass the value to repository and get the return value 
	 * @param schedule
	 * @return
	 */
	Schedule addSchedule(Schedule schedule);

	/**This method pass the value to repository and get the return value
	 * @param day
	 * @return
	 */
	List<Schedule> getByDay(String day);

}
