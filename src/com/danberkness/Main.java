package com.danberkness;

import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Main {
	public static void main(String[] args) throws IOException {
	
		Integer monthlySalesFigure = 0;
		Tesla tesla = new Tesla(monthlySalesFigure, null);
		FileRead fileRead = new FileRead();
		ArrayList<Tesla> model3Sales =new ArrayList<>();
		YearMonth firstYearDate = YearMonth.of(2017, 12);
		YearMonth secondYearDate = YearMonth.of(2018, 1);
		YearMonth thirdYearDate = YearMonth.of(2019, 1);
		YearMonth secondYearLastMonth = YearMonth.of(2018, 12);
		
		
		
		model3Sales = fileRead.readData(monthlySalesFigure);
		
		List<Tesla> has = model3Sales.stream()
										 .toList();
		Map<YearMonth, Integer> tMap = model3Sales.stream()
												  .collect(Collectors.toMap(m -> m.getDate(), m -> m.getMonthlySales()));
	
		java.util.Set<YearMonth> keySet = tMap.keySet();
		System.out.println(keySet);
		java.util.Set<Integer> valueSet = tMap.stream().flatMap(c -> c.getMonthlySales()).collect(Collectors.toSet());
		
										 
		Integer firstYearTotal = model3Sales.stream()
											.filter(car -> car.getDate().isBefore(secondYearDate))
											.map(car -> car.getMonthlySales())
											.mapToInt(Integer :: intValue)
											.sum();
		
		Integer secondYearTotal = model3Sales.stream()
											 .filter(car -> car.getDate().isBefore(thirdYearDate) && car.getDate().isAfter(firstYearDate))
											 .map(car -> car.getMonthlySales())
											 .mapToInt(Integer :: intValue)
											 .sum();
		
		Integer thirdYearTotal = model3Sales.stream()
											.filter(car -> car.getDate().isAfter(secondYearLastMonth))
											.map(car -> car.getMonthlySales())
											.mapToInt(Integer :: intValue)
											.sum();		
	
		

		 }
}
