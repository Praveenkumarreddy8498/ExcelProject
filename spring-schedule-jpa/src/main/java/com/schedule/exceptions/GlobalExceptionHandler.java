package com.schedule.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.schedule.model.ApiErrors;

/**
 * This Class will handle the exceptions occured in controller
 * @author PraveenKumarReddy
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * This method Handles HttpRequestMethodNotSupportedException
	 * 
	 * @param ex      for passing exception
	 * @param headers for passing headers
	 * @param status  for passing status
	 * @param request for passing request
	 * @return ResponseEntity
	 */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Request Method Not Supported";

		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		headers.add("info", message);
		return ResponseEntity.status(status).body(errors);
	}

	/**
	 * This method Handles HttpMediaTypeNotSupportedException
	 * 
	 * @param ex      for passing exception
	 * @param headers for passing headers
	 * @param status  for passing status
	 * @param request for passing request
	 * @return ResponseEntity
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Media Type Not Supported";

		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		headers.add("info", message);

		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	/**
	 * This method Handles MissingPathVariableException
	 * 
	 * @param ex      for passing exception
	 * @param headers for passing headers
	 * @param status  for passing status
	 * @param request for passing request
	 * @return ResponseEntity
	 */
	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Missing Path Variable";

		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);

		headers.add("info", message);

		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	/**
	 * This method Handles MissingServletRequestParameterException
	 * 
	 * @param ex      for passing exception
	 * @param headers for passing headers
	 * @param status  for passing status
	 * @param request for passing request
	 * @return ResponseEntity
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Missing Servlet Request parameter";

		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		headers.add("info", message);

		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	/**
	 * This method Handles TypeMismatchException
	 * 
	 * @param ex      for passing exception
	 * @param headers for passing headers
	 * @param status  for passing status
	 * @param request for passing request
	 * @return ResponseEntity
	 */
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Type Mismatch";

		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, status, status.value(), error);
		headers.add("info", message);

		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	/**
	 * This method Handles ScheduleNotFoundException
	 * 
	 * @param ex for passing exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(ScheduleNotFoundException.class)
	public ResponseEntity<Object> handleBookNotFound(ScheduleNotFoundException ex) {

		String message = ex.getMessage();
		String error = "Schedule Not Found Exception";

		ApiErrors errors = new ApiErrors(LocalDateTime.now(), message, HttpStatus.GONE, HttpStatus.GONE.value(), error);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", message);

		return ResponseEntity.status(HttpStatus.GONE).headers(headers).body(errors);
	}

}
