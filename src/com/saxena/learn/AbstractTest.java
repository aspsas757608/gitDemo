package com.saxena.learn;

public class AbstractTest {

	public static void main(String[] args) {
		Shape s=null;
		s=new Rectangle(3.5, 4.5);
		doOperations(s);
		s=new Triangle(5.5,3.2);
		doOperations(s);
	}
	public static void doOperations(Shape s){
		s.calcArea();
		s.printArea();
	}
}
