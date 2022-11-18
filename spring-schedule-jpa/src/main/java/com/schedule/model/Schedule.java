package com.schedule.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author PraveenKumarReddy
 *
 */
@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer taskId;
	String taskName;
	String description;
	Timestamp startTime;
	Timestamp endTime;
	String day;
	Boolean enabled;

	/**
	 * This is a default constructor
	 */
	public Schedule() {
		super();
	}

	/**
	 * This is a parameterized constructor
	 * 
	 * @param taskName    for passing taskName
	 * @param description for passing description
	 * @param startTime   for passing startTime
	 * @param endTime     for passing endTime
	 * @param day         for passing day
	 * @param enabled     for passing enabled
	 */
	public Schedule(String taskName, String description, Timestamp startTime, Timestamp endTime, String day,
			Boolean enabled) {
		super();
		this.taskName = taskName;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
		this.enabled = enabled;
	}

	/**
	 * This is a getter method
	 * 
	 * @return the taskId
	 */
	public Integer getTaskId() {
		return taskId;
	}

	/**
	 * This is a setter method
	 * 
	 * @param taskId the taskId to set
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	/**
	 * This is a getter method
	 * 
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * This is a setter method
	 * 
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * This is a getter method
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This is a setter method
	 * 
	 * @param description The description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * This is a setter method
	 * 
	 * @return The Timestamp
	 */
	public Timestamp getStartTime() {
		return startTime;
	}

	/**
	 * This is a setter method
	 * 
	 * @param startTime The startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	/**
	 * This is a getter method
	 * 
	 * @return The endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}

	/**
	 * This is a setter method
	 * 
	 * @param endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	/**
	 * This is a getter method
	 * 
	 * @return to get day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * This is a setter method
	 * 
	 * @param day day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * This is a getter method
	 * 
	 * @return to get enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * This is a setter method
	 * 
	 * @param enabled to set enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * This is a toString method
	 */
	@Override
	public String toString() {
		return "Schedule [taskName=" + taskName + ", description=" + description + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", day=" + day + ", enabled=" + enabled + "]";
	}

}
