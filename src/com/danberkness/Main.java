package com.danberkness;

import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
	
		Integer monthlySalesFigure = 0;
//		Tesla tesla = new Tesla(monthlySalesFigure, yearMonth);
		FileRead fileRead = new FileRead();
		ArrayList<Tesla> model3Sales =new ArrayList<>();
		YearMonth secondYearSales = YearMonth.of(2018, 1);
		
		
		model3Sales = fileRead.readData(monthlySalesFigure);
		
				
		List<Tesla> firstYearSales = model3Sales.stream()
												.filter(car -> car.getDate().isBefore(secondYearSales))
												.collect(Collectors.toList());
						
		List<Integer> firstYearValues = firstYearSales.stream()
							  						  .map(car -> car.getMonthlySales())
							  						  .collect(Collectors.toList());
		
		firstYearValues.stream()
					   .map(carValues -> carValues.M)

	}
}
