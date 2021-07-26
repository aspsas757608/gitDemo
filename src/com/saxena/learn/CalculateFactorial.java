package com.psl.employeeproject;

public class CalculateFactorial {
	public void calculate(int num)throws InvalidNumberException{
		int fact=1;	
		if(num>7){
			throw new InvalidNumberException(num);
		}
		for(int n=1;n<=num;n++){
			fact=fact*n;
		}
		System.out.println("Factorial OF "+num+" Is "+fact);
		
	}
}
