package com.excel.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
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
	private Logger logger=LoggerFactory.getLogger(ExcelController.class);
	@Autowired
	IScheduleService scheduleService;
	@Autowired
	ExcelExporter exporter;
	
	
	@Value("${file.path}")
	String filepath;

	/**
	 * This method is used to export the excel file into specified location
	 * @return String for response message
	 * @throws IOException for input output exception
	 */
	@GetMapping("/export")
	@Scheduled(cron = "0 * * * * 1-5")

	public String excelExport() throws IOException {

		List<Schedule> schedule = scheduleService.getByDay(LocalDateTime.now().getDayOfWeek().name());
		exporter = new ExcelExporter(schedule);
		exporter.exportData();
		logger.info("exporting the data");
		FileOutputStream outputStream = new FileOutputStream(filepath);
		XSSFWorkbook workbook = exporter.getWorkbook();
		workbook.write(outputStream);
		logger.info("Data Written SuccesssFully "+LocalDateTime.now());
		workbook.close();
		outputStream.close();
		return "Excel sheet Exported To specific location at " + LocalDateTime.now();
	}

}
