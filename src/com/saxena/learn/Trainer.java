package com.psl.employeeproject;

public class Trainer implements Speaker {

	@Override
	public void speak(String msg) {
		System.out.println("Trainer :: "+msg);

	}

}
