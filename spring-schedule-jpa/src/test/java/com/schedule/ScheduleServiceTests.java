package com.schedule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.schedule.model.Schedule;
import com.schedule.repository.IScheduleRepository;
import com.schedule.service.ScheduleServiceImpl;

/**
 * @author PraveenKumarReddy
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public 	class ScheduleServiceTests {

	@Autowired
	private ScheduleServiceImpl serviceImpl;
	
	@MockBean
	private IScheduleRepository repository;
	/**
	 * This is a test case for getAll method
	 */
	@Test
	public void getAllTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Schedule("Yoga", "Good For Health", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.MONDAY.name(), true),new Schedule("Reading a Book", "Increases Knowledge", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 30, 0)), DayOfWeek.MONDAY.name(), true)).collect(Collectors.toList()));
		assertEquals(2, serviceImpl.getAll().size());
	}
	/**
	 * This is a test case for getByDay method
	 */
	@Test
	public void getByDayTest() {
		when(repository.findByDay("MONDAY")).thenReturn(Stream
				.of(new Schedule("Yoga", "Good For Health", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.MONDAY.name(), true),new Schedule("Reading a Book", "Increases Knowledge", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 30, 0)), DayOfWeek.MONDAY.name(), true)).collect(Collectors.toList()));
		assertEquals(2, serviceImpl.getByDay("MONDAY").size());
	}
	/**
	 * This is a test case for addSchedule method
	 */
	@Test
	public void addScheduleTest() {
		Schedule schedule=new Schedule("Yoga", "Good For Health", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.MONDAY.name(), true);
		when(repository.save(schedule)).thenReturn(schedule);
		assertEquals(schedule, serviceImpl.addSchedule(schedule));
	}
	

}
