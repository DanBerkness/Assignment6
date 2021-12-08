package com.danberkness;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PopulateSales {
	public String populateModelData(ArrayList<SalesData> modelSales) {
		Map<Integer, List<SalesData>> salesPerYear = modelSales.stream()
															   .distinct()
															   .collect(Collectors.groupingBy(t -> t.getDate().getYear()));
		
		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("---------------------------");

		String bestMonth = salesPerYear.entrySet().parallelStream()
												  .map(date -> date.getKey() + " -> " + date.getValue().stream().collect(Collectors.summingInt(SalesData::getMonthlySales)))
												  .collect(Collectors.joining("\n"));
		return bestMonth;
	}
}
