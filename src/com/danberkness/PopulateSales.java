package com.danberkness;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PopulateSales {

	public String populateModelData(ArrayList<SalesData> modelSales, String report) {
		
		Map<Integer, List<SalesData>> salesPerYear = modelSales.stream()
				   .collect(Collectors.groupingBy(t -> t.getDate().getYear()));
		

		System.out.println("Model " + report + " Yearly Sales Report");
		System.out.println("---------------------------");

		String yearlyTotals = salesPerYear.entrySet().stream()
													 .map(date -> date.getKey() + " -> " + date.getValue()
													 .stream().collect(Collectors.summingInt(SalesData::getMonthlySales)))
													 .collect(Collectors.joining("\n"));
		return yearlyTotals;
	}

	public String bestAndWorstMonth(ArrayList<SalesData> modelSales, String report) {

		List<SalesData> sd = modelSales.stream()
									   .collect(Collectors.toList());
		

		List<Integer> salesValues = sd.stream()
									  .map(date -> date.getMonthlySales().intValue())
									  .collect(Collectors.toList());
		
		
		
		
		
		
		
		
		
		
		Map<Object, List<SalesData>>  bestMonth = modelSales.stream()
				
				   
				   .collect(Collectors.groupingBy(d -> d.getDate().getMonth()));

		System.out.println(bestMonth);
		
		
		
		
		
		
		
		
		
//		String bestSalesMonth = 
		
//		System.out.println(bestSalesMonth);


		Integer worstSalesMonth = salesValues.stream().min(Integer::compare).get();

		return "The best month for Model " + report + " was: " +/* bestSalesMonth +*/ "\n" + "The worst month for Model "
				+ report + " was: " + worstSalesMonth + "\n";

	}
}
