package com.danberkness;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		FileRead fileRead = new FileRead();
		
		System.out.println(fileRead.readModel3Data());
	}
}
