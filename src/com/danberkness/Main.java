package com.danberkness;

import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		FileRead fileRead = new FileRead();
		ArrayList<Tesla> model3Sales =new ArrayList<>();
		
		model3Sales = fileRead.readData();
		
		List<Integer> carsYear = model3Sales.stream().map(car -> car.getDate().getYear()).collect(Collectors.toList());
		
		carsYear.stream().map(null)
		
		
		System.out.println(carsYear);

	}
}
