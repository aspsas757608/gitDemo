package com.psl.employeeproject;

public class OuterClass {
	int out_var=100;
	
	public void printOutVar(){
		System.out.println("OuterClass out_var :: "+out_var);
		new InnerClass().printInVar();
	}
	static class InnerClass{
		int in_var=200;
		public void printInVar(){
			System.out.println("InnerClass in_var :: "+in_var);
			//printOutVar();
		}
	}
}
