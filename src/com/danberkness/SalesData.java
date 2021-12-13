package com.danberkness;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class SalesData implements Comparable<SalesData> {
	private Integer monthlySales;
	private YearMonth date;

	
	

	public SalesData(Integer monthlySales, YearMonth date) {
		this.monthlySales = monthlySales;
		this.date = date;
	}

	public Integer getMonthlySales() {
		return monthlySales;
	}

	public void setMonthlySales(Integer monthlySales) {
		this.monthlySales = monthlySales;
	}

	public YearMonth getDate() {
		return date;
	}

	public void setDate(YearMonth yearMonth) {
		this.date = yearMonth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(monthlySales);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesData other = (SalesData) obj;
		return Objects.equals(monthlySales, other.monthlySales);
	}

	@Override
	public String toString() {
		return "VehicleSalesData [monthlySales=" + monthlySales + ", date=" + date + "]" ;
	}

	@Override
	public int compareTo(SalesData that) {
		if (this.monthlySales > that.monthlySales) {
			return 1;
		} else if (this.monthlySales.equals(that.monthlySales)) {
			return 0;
		} else {
			return -1;
		}

	}
	
}
