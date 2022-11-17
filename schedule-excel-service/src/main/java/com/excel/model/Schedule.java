package com.excel.model;

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
	
	public Schedule() {
		super();
	}

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
	 * @return the taskId
	 */
	public Integer getTaskId() {
		return taskId;
	}

	
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return  the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description The description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return The Timestamp
	 */
	public Timestamp getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime The startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return The endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return to get day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @return to get enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled to set enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Schedule [taskName=" + taskName + ", description=" + description + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", day=" + day + ", enabled=" + enabled + "]";
	}
	
	
	
	
}
