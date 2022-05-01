package com.CyberSuccessAutomation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private static Workbook wb;
	private static Row row;
	private static Sheet sheet;

	/**
	 * Create workbook instance based on the file extension *
	 * 
	 * @param filePath
	 * @param FileInputStream input
	 */
	private static void getWorkbookInstance(String filePath, FileInputStream input) throws IOException {
		String extension = filePath.substring(filePath.indexOf("."));
		if (extension.equals(".xlsx")) {
			wb = new XSSFWorkbook(input);
		} else if (extension.equals(".xlx")) {
			wb = new HSSFWorkbook(input);
		}
	}

	/**
	 * This method return the excel file data based on the provided sheet name *
	 * 
	 * @param filePath
	 * @param sheetName
	 */
	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {

		FileInputStream input = new FileInputStream(filePath);

		// create workbook instance based on the file extention
		getWorkbookInstance(filePath, input);

		// get sheet control
		sheet = wb.getSheet(sheetName); // wb.getSheetAt(0);

		// get total num of rows
		int totalRows = sheet.getLastRowNum();

		// get control on 0th row
		row = sheet.getRow(0);

		// get total columns length
		int totalColumns = row.getPhysicalNumberOfCells();

		System.out.println("Total Columns: " + totalColumns);

		System.out.println("Total Rows: " + totalRows);

		Object[][] excelObject = new Object[totalRows + 1][totalColumns];

		for (int i = 1; i <= totalRows; i++) {

			for (int j = 0; j < totalColumns; j++) {

				Cell cell = sheet.getRow(i).getCell(j);
				excelObject[i][j] = Objects.isNull(cell) ? null : getCellData(cell);
			}
		}
		// close workbook instance
		wb.close();
		return excelObject;
	}

	/**
	 * This method returns value from cell based of the cell value type
	 * 
	 * @param cell
	 */
	private static Object getCellData(Cell cell) {
		switch (cell.getCellType()) {

		case NUMERIC:
			return cell.getNumericCellValue();
		case STRING:
			return cell.getStringCellValue();
		case BOOLEAN:
			return cell.getBooleanCellValue();
		default:
			return "";
		}
	}

	/**
	 * This method will set the values in cells based on the provided index *
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @param value
	 */
	public static void setExcelData(String filePath, String sheetName, int rowNum, int colNum, String value)
			throws IOException {

		FileInputStream input = new FileInputStream(filePath);

		// get workbook instance
		getWorkbookInstance(filePath, input);

		// create sheet in the workbook
		if (Objects.isNull(wb.getSheet(sheetName))) {
			sheet = wb.createSheet(sheetName); // create sheet

		} else {
			sheet = wb.getSheet(sheetName);
		}
		// create row based on the provided index
		Row row = sheet.createRow(rowNum);

		// create cell on row and set the value
		row.createCell(colNum).setCellValue(value);

		// save the file data
		FileOutputStream output = new FileOutputStream(filePath);

		// write the data into excel file
		wb.write(output);

		// close workbook instance
		wb.close();

	}

}