package com.danberkness;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PopulateSales {
	
	public String populateModelData(ArrayList<SalesData> modelSales, String report) {
		Map<Integer, List<SalesData>> salesPerYear = modelSales.stream()
															   .distinct()
															   .collect(Collectors.groupingBy(t -> t.getDate().getYear()));
		
		System.out.println("Model " + report + " Yearly Sales Report");
		System.out.println("---------------------------");

		String yearlyTotals = salesPerYear.entrySet().parallelStream()
													 .map(date -> date.getKey() + " -> " + date.getValue().stream().collect(Collectors.summingInt(SalesData::getMonthlySales)))
													 .collect(Collectors.joining("\n"));
		return yearlyTotals;
	}
	public String bestAndWorstMonth(ArrayList<SalesData> modelSales, String report) {
		String bestSalesMonth = "";
		String worstSalesMonth = "";
		
		Optional<String> sd = modelSales.stream()
				  .collect(Collectors.maxBy(Integer::compareTo).toString());
		
		return "The best month for Model " + report + " was: " + bestSalesMonth + "\n" + "The worst month for Model " + report + " was: " + worstSalesMonth + "\n";
		
		
	}
}
