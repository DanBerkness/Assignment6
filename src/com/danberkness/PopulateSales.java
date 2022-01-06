package com.danberkness;

import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PopulateSales {

	public void populateModelData(List<SalesData> modelSales, String report) {
		
		Optional<SalesData> worstMonth, bestMonth;
		
		Map<Integer, List<SalesData>> salesPerYear = modelSales.stream()
				   											   .collect(Collectors.groupingBy(t -> t.getDate().getYear()));
	
		System.out.println("Model " + report + " Yearly Sales Report");
		System.out.println("---------------------------");

		String yearlyTotals = salesPerYear.entrySet()
										  .stream()
										  .map(date -> date.getKey() + " -> " + date.getValue()
										  .stream().collect(Collectors.summingInt(SalesData::getMonthlySales)))
										  .collect(Collectors.joining("\n"));
		
		System.out.println(yearlyTotals);
		
		worstMonth = modelSales.parallelStream()
							   .min((SalesData obj1, SalesData obj2 )-> obj1.getMonthlySales().compareTo(obj2.getMonthlySales()));
		System.out.println();
		
		bestMonth = modelSales.parallelStream()
							  .max((SalesData obj1, SalesData obj2 )-> obj1.getMonthlySales().compareTo(obj2.getMonthlySales()));
		
		
		System.out.print("The best month for Model " + report + " was: ");
		bestMonth.stream().map(w -> w.getDate().format(DateTimeFormatter.ofPattern("yyyy-MMM"))).forEach(System.out::println);
		System.out.print("The worst month for Model " + report + " was: ");
		worstMonth.stream().map(w -> w.getDate().format(DateTimeFormatter.ofPattern("yyyy-MMM"))).forEach(System.out::println);
	}

}