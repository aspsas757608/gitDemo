package com.psl.employeeproject;

public abstract class Shape {
	double dim1,dim2;
	double area=0;
	public Shape(){
		
	}
	public Shape(double dim1,double dim2){
		this.dim1=dim1;
		this.dim2=dim2;
	}
	abstract public void calcArea();
	public void printArea(){
		System.out.println("Area :: "+area);
	}
}
