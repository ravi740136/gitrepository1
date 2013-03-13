package appdriverng.common;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadFromExcel {
	static final Logger LOG = Logger.getLogger("deshaw.automation");
	// Read data from excel and prepare the source for Data Provider method
	public static String[][] getTableArray(String xlFilePath, String sheetName,String tableName) {
		String[][] tabArray = null;
		try {
			LOG.warn("Excel file Path: "+ xlFilePath);
			LOG.info("Sheet name is " + sheetName);
			LOG.info("Table name is " + tableName);
		
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int startRow, startCol, endRow, endCol, ci, cj;
			Cell tableStart = sheet.findCell(tableName);
			
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, startCol + 1,
					startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();
			LOG.warn("Test Case data: startRow=" + startRow + ", endRow=" + endRow
					+ ", " + "startCol=" + startCol + ", endCol=" + endCol);
			System.out.println("\n\n\n");
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;

			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			System.out.println("error in getTableArray()");
			e.printStackTrace();
		}

		return (tabArray);
	}
	
}
