package com.excel.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.export.ExcelExporter;
import com.excel.model.Schedule;
import com.excel.service.IScheduleService;

/**
 * @author PraveenKumarReddy
 *
 */
@RestController
@RequestMapping("/excel")
@PropertySource(value = "classpath:application.yml")
public class ExcelController {
	private Logger logger = LoggerFactory.getLogger(ExcelController.class);
	@Autowired
	IScheduleService scheduleService;
	@Autowired
	ExcelExporter exporter;

	@Value("${file.path}")
	String filepath;

	/**
	 * This is a scheduling enabled method is used to export the excel file into
	 * specified location scheduler will schedule the job At 12:00 AM on every
	 * Monday through Friday​
	 * The fields read from left to right are interpreted as follows
	 * second(0-59) 
	 * minute(0-59) 
	 * hour(0-23)
	 * day of month(1-31)
	 * month(1-12)
	 * day of week(0-6)(Sunday is 0)
	 * 
	 * @return String for response message
	 * @throws IOException for input output exception
	 */
	@GetMapping("/export")
	@Scheduled(cron = "0 0 0 * * 1-5")
	@RolesAllowed("ADMIN")
	public ResponseEntity<String> excelExport() throws IOException {

		List<Schedule> schedule = scheduleService.getByDay(LocalDateTime.now().getDayOfWeek().name());
		exporter = new ExcelExporter(schedule);
		logger.info("importing the data from excel sheet");
		exporter.exportData();
		logger.info("data imported successfully");
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "It adds the data in to workbook");
		FileOutputStream outputStream = new FileOutputStream(filepath.concat(LocalDate.now().toString()+".xlsx"));
		XSSFWorkbook workbook = exporter.getWorkbook();
		logger.info("writing Excel sheet into FileOutputStream");

		workbook.write(outputStream);
		logger.info("Data Written SuccesssFully into location at " + LocalDateTime.now());
		workbook.close();
		outputStream.close();
		String body = "Excel sheet Exported To specific location at " + LocalDateTime.now();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(body, header, HttpStatus.OK);
		return responseEntity;
	}

}
