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
		Integer monthlySalesFigure = 0;
		
		
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String burnLine = reader.readLine();
			String readLine ="";
			
			while ((readLine = reader.readLine()) != null) {
				String[] line = readLine.split(",");
				
				String[] splitDate = line[0].split("-");
				String month = splitDate[0];
				String year = splitDate[1];
				String yearMonthDate = year + "-" + month;
				DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yy-MMM");
				YearMonth yearMonth = YearMonth.parse(yearMonthDate, inputFormat);
				monthlySalesFigure = Integer.parseInt(line[1]);
				SalesData tesla = new SalesData(monthlySalesFigure, yearMonth);
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
