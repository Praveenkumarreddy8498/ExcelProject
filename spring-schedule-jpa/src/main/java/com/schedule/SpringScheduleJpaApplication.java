package com.schedule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.schedule.service.IScheduleService;

/**
 * @author PraveenKumarReddy
 *
 */
@SpringBootApplication

public class SpringScheduleJpaApplication implements CommandLineRunner {

	/**
	 * This is main method
	 * @param args for passing arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringScheduleJpaApplication.class, args);
	}

	@Autowired

	IScheduleService scheduleService;

	/**
	 * This is run method
	 * @param args for passing arguments
	 * @throws Exception for any exception that will occur
	 */
	@Override
	public void run(String... args) throws Exception {
		//Monday
		/*Schedule task1=new Schedule("Yoga", "Good For Health", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.MONDAY.name(), true);
		Schedule task2=new Schedule("Reading a Book", "Increases Knowledge", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 30, 0)), DayOfWeek.MONDAY.name(), true);
		Schedule task3=new Schedule("Java Course", "Backend Programming", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 9, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 1, 0, 0)), DayOfWeek.MONDAY.name(), true);
		Schedule task4=new Schedule("Angular Course", "Frontend Programming", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 2, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 5, 0, 0)), DayOfWeek.MONDAY.name(), true);
		Schedule task5=new Schedule("Plying Volleyball", "Keeps us enthusiastic", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 5, 30, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.MONDAY.name(), true);
		scheduleService.addSchedule(task1);
		scheduleService.addSchedule(task2);
		scheduleService.addSchedule(task3);
		scheduleService.addSchedule(task4);
		scheduleService.addSchedule(task5);

		//Tuesday
		Schedule task6=new Schedule("Yoga", "Good For Health", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.TUESDAY.name(), true);
		Schedule task7=new Schedule("Reading a Book", "Increases Knowledge", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 30, 0)), DayOfWeek.TUESDAY.name(), true);
		Schedule task8=new Schedule("Spring Course", "Backend Programming", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 9, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 1, 0, 0)), DayOfWeek.TUESDAY.name(), true);
		Schedule task9=new Schedule("TypeScript Course", "Frontend Programming", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 2, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 5, 0, 0)), DayOfWeek.TUESDAY.name(), true);
		Schedule task10=new Schedule("Playing Hockey", "Keeps us enthusiastic", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 5, 30, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.TUESDAY.name(), true);
		scheduleService.addSchedule(task6);
		scheduleService.addSchedule(task7);
		scheduleService.addSchedule(task8);
		scheduleService.addSchedule(task9);
		scheduleService.addSchedule(task10);
		
		//wednesday
		Schedule task11=new Schedule("Yoga", "Good For Health", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.WEDNESDAY.name(), true);
		Schedule task12=new Schedule("Reading a Book", "Increases Knowledge", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 30, 0)), DayOfWeek.WEDNESDAY.name(), true);
		Schedule task13=new Schedule("Python Course", "Backend Programming", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 9, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 1, 0, 0)), DayOfWeek.WEDNESDAY.name(), true);
		Schedule task14=new Schedule("JavaScript Course", "Frontend Programming", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 2, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 5, 0, 0)), DayOfWeek.WEDNESDAY.name(), true);
		Schedule task15=new Schedule("Playing Carroms", "Keeps us enthusiastic", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 5, 30, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.WEDNESDAY.name(), true);
		scheduleService.addSchedule(task11);
		scheduleService.addSchedule(task12);
		scheduleService.addSchedule(task13);
		scheduleService.addSchedule(task14);
		scheduleService.addSchedule(task15);
		
		//thursday
		Schedule task16=new Schedule("Yoga", "Good For Health", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.THURSDAY.name(), true);
		Schedule task17=new Schedule("Reading a Book", "Increases Knowledge", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 30, 0)), DayOfWeek.THURSDAY.name(), true);
		Schedule task18=new Schedule("Python Course", "Backend Programming", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 9, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 1, 0, 0)), DayOfWeek.THURSDAY.name(), true);
		Schedule task19=new Schedule("JavaScript Course", "Frontend Programming", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 2, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 5, 0, 0)), DayOfWeek.THURSDAY.name(), true);
		Schedule task20=new Schedule("Playing Chess", "Increases IQ", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 5, 30, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.THURSDAY.name(), true);
		scheduleService.addSchedule(task16);
		scheduleService.addSchedule(task17);
		scheduleService.addSchedule(task18);
		scheduleService.addSchedule(task19);
		scheduleService.addSchedule(task20);
		
		//friday
		
		Schedule task21=new Schedule("Yoga", "Good For Health", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.FRIDAY.name(), true);
		Schedule task22=new Schedule("Reading a Book", "Increases Knowledge", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 7, 30, 0)), DayOfWeek.FRIDAY.name(), true);
		Schedule task23=new Schedule("Node.js", "Backend Technology", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 9, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 1, 0, 0)), DayOfWeek.FRIDAY.name(), true);
//		Schedule task24=new Schedule("JavaScript Course", "Frontend Programming", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 2, 0, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 5, 0, 0)), DayOfWeek.WEDNESDAY.name(), false);
		Schedule task25=new Schedule("Playing Cricket", "Keeps us in shape,coordination", Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 3, 30, 0)), Timestamp.valueOf(LocalDateTime.of(2022, 11, 21, 6, 30, 0)), DayOfWeek.FRIDAY.name(), true);
		scheduleService.addSchedule(task21);
		scheduleService.addSchedule(task22);
		scheduleService.addSchedule(task23);
//		scheduleService.addSchedule(task24);
		scheduleService.addSchedule(task25);*/
		
		
		

	}

}
