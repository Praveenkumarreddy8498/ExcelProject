package com.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schedule.model.Schedule;

/**
 * @author PraveenKumarReddy
 *
 */
public interface IScheduleRepository extends JpaRepository<Schedule, Integer>  {

	/**This method will get the data from JpaRepository and returns the data
	 * @param day for passing day value
	 * @return List of schedule
	 */
	List<Schedule> findByDay(String day);
	
}
