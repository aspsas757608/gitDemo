package com.psl.employeeproject;

public class InheritanceTest {

	public static void main(String[] args) {
		SuperClass superClass=new SuperClass();
		SubClass subClass=new SubClass();
		superClass.printSuperVar();
		subClass.printSubVar();
		subClass.printSuperVar();
		SuperClass s1=new SuperClass();
		SubClass s2=new SubClass();
		SuperClass s3=new SubClass();
		SubClass s4=(SubClass)new SuperClass();
	}

}
