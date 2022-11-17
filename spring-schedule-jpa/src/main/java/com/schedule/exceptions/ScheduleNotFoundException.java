package com.schedule.exceptions;

/**
 * @author PraveenKumarReddy
 *
 */
public class ScheduleNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ScheduleNotFoundException() {
		super();
	}

	/**
	 * @param message for passing message
	 */
	public ScheduleNotFoundException(String message) {
		super(message);
	}
	

}
