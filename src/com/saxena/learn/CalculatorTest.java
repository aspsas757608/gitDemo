package com.psl.employeeproject;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calculator=new Calculator();
		System.out.println(calculator.sum(10.5, 12));
		System.out.println(calculator.sum(10, 12.6));
		System.out.println(calculator.sum(10, 12));
		System.out.println(calculator.sum(10, 12,13));
	}

}
