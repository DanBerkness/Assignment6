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
	YearMonth yearMonth = YearMonth.now();
	
	public  ArrayList<Tesla> readData() throws IOException {
		BufferedReader reader = null;
		ArrayList<Tesla> teslas =new ArrayList<>();
		
		try {
			reader = new BufferedReader(new FileReader("model3data.txt"));
			String burnLine = reader.readLine();
			String readLine ="";
			
			while ((readLine = reader.readLine()) != null) {
				String[] line = readLine.split(",");
				dateParsing(line);
				Integer monthlySalesFigure = Integer.parseInt(line[1]);
				Tesla tesla = new Tesla(monthlySalesFigure, yearMonth);
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

	private YearMonth dateParsing(String[] line) {
		String[] splitDate = line[0].split("-");
		String month = splitDate[0];
		String year = splitDate[1];
		String yearMonthDate = year + "-" + month;
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yy-MMM");
		yearMonth = YearMonth.parse(yearMonthDate, inputFormat);
		return yearMonth;
	}
	
}
