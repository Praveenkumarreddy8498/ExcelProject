package com.schedule.exceptions;

/**
 * This is an Exception class
 * @author PraveenKumarReddy
 *
 */
public class ScheduleNotFoundException extends RuntimeException {

	/**
	 * This adds a default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This is a constructor for ScheduleNotFoundException class
	 */
	public ScheduleNotFoundException() {
		super();
	}

	/**
	 * This is a parameterized constructor for ScheduleNotFoundException class
	 * 
	 * @param message for passing message
	 */
	public ScheduleNotFoundException(String message) {
		super(message);
	}

}
