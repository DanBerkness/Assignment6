//		Collectors.groupingBy(d -> d.getDate().getYear()
package com.danberkness;

import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;





public class Main {
	public static void main(String[] args) throws IOException {
		FileRead fileRead = new FileRead();
		ArrayList<Tesla> model3Sales =new ArrayList<>();
		ArrayList<Tesla> modelSSales =new ArrayList<>();
		ArrayList<Tesla> modelXSales =new ArrayList<>();
		
		YearMonth firstYearDate = YearMonth.of(2017, 12);
		YearMonth secondYearDate = YearMonth.of(2018, 1);
		YearMonth thirdYearDate = YearMonth.of(2019, 1);
		YearMonth secondYearLastMonth = YearMonth.of(2018, 12);
		
		model3Sales = fileRead.readData("model3data.txt");
		modelSSales = fileRead.readData("modelsdata.txt");
		modelXSales = fileRead.readData("modelxdata.txt");
		
		Map<Integer, List<Tesla>> allDatesInFile = model3Sales.stream()
															  .collect(Collectors.groupingBy(d -> d.getDate().getYear()));
		System.out.println(allDatesInFile);
		Set<Entry<Integer, List<Tesla>>> entrySet = allDatesInFile.entrySet();
//		I can use this Entry Set to stream 

		
		Set<List<Tesla>> years = entrySet.stream()
										 
										 .map(e -> e.getValue())
										 .collect(Collectors.toSet());
		System.out.println(years);
		
		
//		Set<Integer> dateSet = entrySet.stream()
//									   .filter(c -> c.getKey().toString())
//									   .collect(Collectors.toSet());
				
		Map<YearMonth, Integer> teslasMap = model3Sales.stream()
													   .collect(Collectors.toMap(m -> m.getDate(), m -> m.getMonthlySales()));
	
		
		
		
		
		
		System.out.println("---Sales totals---");
										 
		Integer firstYearTotal = model3Sales.stream()
											
											.map(car -> car.getMonthlySales())
											.mapToInt(Integer :: intValue)
											.sum();
		System.out.println(firstYearTotal);
		Integer secondYearTotal = model3Sales.stream() // Broken until date is fixed.
											 .filter(car -> car.getDate().isBefore(thirdYearDate) && car.getDate().isAfter(secondYearDate))
											 .map(car -> car.getMonthlySales())
											 .mapToInt(Integer :: intValue)
											 .sum();
		System.out.println(secondYearTotal);
		Integer thirdYearTotal = model3Sales.stream()
											.filter(car -> car.getDate().isAfter(secondYearLastMonth))
											.map(car -> car.getMonthlySales())
											.mapToInt(Integer :: intValue)
											.sum();		
		System.out.println(thirdYearTotal);
		

		 }
}
