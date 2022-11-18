package com.schedule.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

/**
 * This is a model class for all API errors
 * @author PraveenKumarReddy
 *
 */
public class ApiErrors {

	LocalDateTime timestamp;
	String message;
	HttpStatus status;
	int statusCode;
	String error;

	/**
	 * This is all arguments constructor for ApiErrors
	 * 
	 * @param timestamp  for passing LocalDateTime
	 * @param message    for passing message
	 * @param status     for passing status
	 * @param statusCode for passing statusCode
	 * @param error      for passing error
	 */
	public ApiErrors(LocalDateTime timestamp, String message, HttpStatus status, int statusCode, String error) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
		this.error = error;
	}

	/**
	 * getter method for LocalDateTime
	 * 
	 * @return the LocalDateTime
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * setter method for LocalDateTime
	 * 
	 * @param timestamp the LocalDateTime to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * getter method for String
	 * 
	 * @return the message 
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * setter method for String
	 * 
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * getter method for HttpStatus 
	 * 
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * setter method for HttpStatus
	 * 
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * getter method for status code 
	 * 
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * setter method for status code 
	 * 
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * 
	 * getter method for error
	 * 
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * setter method for error
	 * 
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 *This is a toString method
	 */
	@Override
	public String toString() {
		return "ApiErrors [timestamp=" + timestamp + ", message=" + message + ", status=" + status + ", statusCode="
				+ statusCode + ", error=" + error + "]";
	}

}
