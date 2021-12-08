//		Collectors.groupingBy(d -> d.getDate().getYear()
package com.danberkness;

import java.io.IOException;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;





public class Main {
	public static void main(String[] args) throws IOException {
		FileRead fileRead = new FileRead();
		PopulateSales populateSales = new PopulateSales();
		ArrayList<SalesData> model3Sales =new ArrayList<>();
		ArrayList<SalesData> modelSSales =new ArrayList<>();
		ArrayList<SalesData> modelXSales =new ArrayList<>();
		
		
		modelSSales = fileRead.readData("modelsdata.txt");
		modelXSales = fileRead.readData("modelxdata.txt");
		
		
		ArrayList<SalesData> modelSales = fileRead.readData("model3data.txt");
		String model3Report = populateSales.populateModelData(modelSales);
		System.out.println(model3Report);


	}
}
