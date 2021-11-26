package com.danberkness;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Tesla {
	private Integer monthlySales;
	private YearMonth date;
	
	public Tesla(Integer monthlySales, YearMonth date) {
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
	public String toString() {
		return "Tesla [monthlySales=" + monthlySales + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, monthlySales);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tesla other = (Tesla) obj;
		return Objects.equals(date, other.date) && Objects.equals(monthlySales, other.monthlySales);
	}
	
}
