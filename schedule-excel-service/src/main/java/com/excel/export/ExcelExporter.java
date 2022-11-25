package com.excel.export;

import java.sql.Timestamp;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.excel.model.Schedule;

/**
 * @author PraveenKumarReddy
 *
 */
@Component
public class ExcelExporter {
	Logger logger = LoggerFactory.getLogger(ExcelExporter.class);

	private XSSFWorkbook workbook = new XSSFWorkbook();
	private XSSFSheet sheet;
	private List<Schedule> scheduleList;

	/**
	 * This is parameterized constructor
	 * 
	 * @param scheduleList for passing the schedule
	 */
	public ExcelExporter(List<Schedule> scheduleList) {
		super();
		this.scheduleList = scheduleList;

	}

	/**
	 * This is getter method for Workbook
	 * 
	 * @return The Workbook
	 */
	public XSSFWorkbook getWorkbook() {
		return workbook;
	}

	/**
	 * This is setter method for Workbook
	 * 
	 * @param workbook workbook to set
	 */
	public void setWorkbook(XSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	/**
	 * This method is used to create a cell with the parameters values
	 * 
	 * @param row         for passing the row
	 * @param columnCount for passing the column number
	 * @param value       for passing the Object value
	 * @param style       for passing the CellStyle
	 */
	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else if (value instanceof Timestamp) {
			cell.setCellValue((Timestamp) value);
		} else {
			cell.setCellValue((String) value);
		}
		style.setWrapText(true);
		sheet.autoSizeColumn(columnCount);
		cell.setCellStyle(style);
	}

	/**
	 * This Method is used to create a CellStyle for a cell with the parameter
	 * values
	 * 
	 * @param font    for passing the font for cell
	 * @param bgColor for passing the background color for the cell
	 * @return CellStyle for adding it to the cell
	 */
	private CellStyle createCellStyle(XSSFFont font, IndexedColors bgColor) {
		CellStyle style = workbook.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFillBackgroundColor(bgColor.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setWrapText(true);
		return style;

	}

	/**
	 * This Method is used to write he header lines in sheet for the workbook
	 */
	private void writeHeaderLines() {
		logger.info("Writing the header lines");

		logger.info("Creating sheet in workbook");
		sheet = workbook.createSheet("Schedule");
		logger.info("sheet created ");

		logger.info("Creating row for header1 in sheet");
		Row row = sheet.createRow(0);
		logger.info("row for header1 created");

		logger.info("Creating font for cell");
		XSSFFont font = workbook.createFont();
		logger.info("font created");

		font.setBold(true);
		font.setFontHeight(16);
		font.setFontName("Times New Roman");
		font.setColor(HSSFColorPredefined.BLACK.getIndex());

		logger.info("creating cells for header-row-1");
		CellStyle styleForHeader1 = createCellStyle(font, IndexedColors.GREY_50_PERCENT);
		createCell(row, 0, "Daily Schedule", styleForHeader1);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
		logger.info("cells for header-row-1 created");

		logger.info("Creating row for header2 in sheet");
		row = sheet.createRow(1);
		logger.info("row for header2 created");

		
		logger.info("creating cells for header-row-2");
		CellStyle styleForHeader2 = createCellStyle(font, IndexedColors.GREY_40_PERCENT);
		createCell(row, 0, "S.No", styleForHeader2);
		createCell(row, 1, "Day", styleForHeader2);
		createCell(row, 2, "Task Name", styleForHeader2);
		createCell(row, 3, "Start Time", styleForHeader2);
		createCell(row, 4, "End Time", styleForHeader2);
		createCell(row, 5, "Description", styleForHeader2);
		createCell(row, 6, "Enabled", styleForHeader2);
		logger.info("cells for header-row-2 created");

	}

	/**
	 * This method is used to produce the data lines that should be added to
	 * workbook
	 */
	private void writeDataLines() {

		int rowCount = 2;
		logger.info("Creating font for Data cells");
		XSSFFont font = workbook.createFont();
		logger.info("font for data cells created");
		font.setFontHeight(12);
		font.setFontName("Times New Roman");
		font.setColor(HSSFColorPredefined.BLACK.getIndex());
				
		CellStyle styleForAll = createCellStyle(font, IndexedColors.GREY_25_PERCENT);
		
		CellStyle styleForDate = createCellStyle(font, IndexedColors.GREY_25_PERCENT);
				CreationHelper createHelper = workbook.getCreationHelper();
		styleForDate.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy hh:mm:ss"));

	
		logger.info("Writing schedule data into cells by creating them in for loop");
		int serialNo = 1;
		for (Schedule schedule : scheduleList) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, serialNo++, styleForAll);
			createCell(row, columnCount++, schedule.getDay(), styleForAll);
			createCell(row, columnCount++, schedule.getTaskName(), styleForAll);
			createCell(row, columnCount++, schedule.getStartTime(), styleForDate);
			createCell(row, columnCount++, schedule.getEndTime(), styleForDate);
			createCell(row, columnCount++, schedule.getDescription(), styleForAll);
			createCell(row, columnCount++, schedule.getEnabled(), styleForAll);
		}
		logger.info("schedule data written into cells");

	}

	/**
	 * This method is used to export the entire data created here
	 */
	public void exportData() {
		logger.info("exporting the excel sheet data ");
		writeHeaderLines();
		writeDataLines();
		logger.info("excel sheet data exported");


	}

}
