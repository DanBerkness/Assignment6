package com.danberkness;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;



public class FileRead {
	
	
	public  ArrayList<SalesData> readData(String filePath) throws IOException {
		
		BufferedReader reader = null;
		ArrayList<SalesData> teslas =new ArrayList<>();
		
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String burnLine = reader.readLine();
			String readLine ="";
			
			while ((readLine = reader.readLine()) != null) {
				String[] line = readLine.split(",");
				SalesData tesla = new SalesData(line[1], line[0]);
				teslas.add(tesla);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Reader did not close correctly");
				e.printStackTrace();
			}
		}
		return teslas;
	}
}
