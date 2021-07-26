package com.psl.employeeproject;

public class Politician implements Speaker {

	@Override
	public void speak(String msg) {
		System.out.println("Politician :: "+msg);

	}

}
