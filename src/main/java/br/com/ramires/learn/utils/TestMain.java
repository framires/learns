package br.com.ramires.learn.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestMain {

    public static void main(String[] args) {

	String fileLocation = "HEROES.xlsx";
	try {

	    InputStream is = TestMain.class.getClassLoader().getResourceAsStream(fileLocation);
	    
	    Workbook workbook = new XSSFWorkbook(is);

	    Sheet sheet = workbook.getSheetAt(0);

	    Map<Integer, List<String>> data = new HashMap<>();
	    int i = 0;
	    for (Row row : sheet) {
		data.put(i, new ArrayList<String>());
		for (Cell cell : row) {
		    System.out.println(cell.getStringCellValue());
		}
		i++;
	    }
	} catch (Exception e) {
	    System.out.println(e.toString());
	}
    }

}
