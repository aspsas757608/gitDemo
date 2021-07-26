package com.psl.employeeproject;

public class TestException {

	public static void main(String[] args) {
		CalculateFactorial cf=new CalculateFactorial();
		try{
		cf.calculate(4);
		cf.calculate(6);
		cf.calculate(8);
		}catch(InvalidNumberException e){
			//System.out.println(e);
			e.printStackTrace();
		}
	}

}
