package br.com.ramires.learn.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestMainCSV {

    public static void main(String[] args) {

	String fileLocation = "VehicleModelCSV02.csv";
	try {
	    // read file
	    InputStream is = TestMainCSV.class.getClassLoader().getResourceAsStream(fileLocation);
	    // convert inputStream
	    InputStreamReader isReader = new InputStreamReader(is);
	    // Creating a BufferedReader object
	    BufferedReader br = new BufferedReader(isReader);

	    try {
		String line = br.readLine();
		int i = 0;
		while (line != null) {

		    if (i == 0) {
			line = br.readLine();
		    } else {

			String[] listItem = line.split("\\|");
			for (int j = 0; j < listItem.length; j++) {
			    System.out.println(listItem[j].toString());
			    
			}
			line = br.readLine();
		    }
		    i++;
		}
	    } catch (Exception e) {
		System.out.println("erro 2");
	    }

	} catch (Exception e) {
	    System.out.println("erro 1");
	}

    }

}
