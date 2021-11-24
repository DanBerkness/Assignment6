package com.danberkness;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;



public class FileRead {
	
	public  ArrayList<String> readModel3Data() throws IOException {
		BufferedReader reader = null;
		ArrayList<String> dateLine;
		LocalDateTime mod3Dates = LocalDateTime.now();
		try {
			reader = new BufferedReader(new FileReader("model3data.txt"));
			String burnLine = reader.readLine();
			String[] line = reader.readLine().split(",");
			String dates = line[0];
			String[] splitDate = line[0].split(" ");
			String month = splitDate[0];
			String year = splitDate[1];
			
			mod3Dates = LocalDateTime.parse(dates, DateTimeFormatter.ofPattern("MMM-yy"));
			System.out.println(mod3Dates);
			
			int monthlySales = Integer.parseInt(line[1]);	
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
		return null;
	}
	
}
