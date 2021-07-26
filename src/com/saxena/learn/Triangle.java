package com.psl.employeeproject;

public class Triangle extends Shape {
	public Triangle(double dim1,double dim2){
		super(dim1,dim2);
	}
	@Override
	public void calcArea() {
		area=dim1*dim2/0.5;
	}

}
