package com.psl.employeeproject;

public class InnerClassTest {

	public static void main(String[] args) {
		OuterClass outObject=new OuterClass();
		outObject.printOutVar();
		//OuterClass.InnerClass inObject= new OuterClass().new InnerClass();
		OuterClass.InnerClass inObject= new OuterClass.InnerClass();
		inObject.printInVar();

	}

}
