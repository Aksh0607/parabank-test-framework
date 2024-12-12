package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private XSSFWorkbook workbook;

	public XSSFSheet getSheet(String filePath , String sheetName) throws Exception {
	    File file = new File(filePath);
	    FileInputStream fis = new FileInputStream(file);
	    this.workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheet(sheetName);
	    if (sheet == null) {
	        throw new Exception("Sheet with name '" + sheetName + "' not found in the file '" + filePath + "'");
	    }
	    return sheet;
	}


	public Map<String, String> getRowDataAsMap(String filePath, String sheetName, int rowIndex) throws Exception {
	    Map<String, String> dataMap = new HashMap<>();
	    XSSFSheet sheet = getSheet(filePath, sheetName);

	    Row headerRow = sheet.getRow(0);
	    if (headerRow == null) {
	        throw new Exception("Header row is missing in sheet '" + sheetName + "'");
	    }

	    Row dataRow = sheet.getRow(rowIndex);
	    if (dataRow == null) {
	        throw new Exception("Data row at index " + rowIndex + " is missing in sheet '" + sheetName + "'");
	    }

	    int numberOfCells = headerRow.getPhysicalNumberOfCells();
	    for (int cell = 0; cell < numberOfCells; cell++) {
	        String header = headerRow.getCell(cell).getStringCellValue();
	        Cell dataCell = dataRow.getCell(cell);
	        dataMap.put(header, getStringValue(dataCell));
	    }
	    return dataMap;
	}


	private String getStringValue(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return String.valueOf(cell.getCellFormula());
		default:
			return " ";
		}

	}
	
}
