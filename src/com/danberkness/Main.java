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
		String threeReport = "3", sReport = "S", xReport = "X";
		
		
		ArrayList<SalesData> modelSales = fileRead.readData("model3data.txt");
		String model3Report = populateSales.populateModelData(modelSales, threeReport);
		System.out.println(model3Report);
		System.out.println("");
		String model3BestMonth = populateSales.bestAndWorstMonth(modelSales, threeReport);
		System.out.println(model3BestMonth);
		
		modelSales = fileRead.readData("modelsdata.txt");
		String modelSReport = populateSales.populateModelData(modelSales, sReport);
		System.out.println(modelSReport);
		System.out.println("");
		String modelSBestMonth = populateSales.bestAndWorstMonth(modelSales, sReport);
		System.out.println(modelSBestMonth);
		
		modelSales = fileRead.readData("modelxdata.txt");
		String modelXReport = populateSales.populateModelData(modelSales, xReport);
		System.out.println(modelXReport);
		System.out.println("");
		String modelXBestMonth = populateSales.bestAndWorstMonth(modelSales, xReport);
		System.out.println(modelXBestMonth);
		
	}
}
