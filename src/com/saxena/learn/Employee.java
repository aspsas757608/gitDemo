package com.psl.employeeproject;
public class Employee {
	
	private int empId=0;
	private String empName=null;
	private double empSal;
	private boolean present;
	private int days[];
	public static final int SIZE=10;
	
	public Employee(){
		this.empId=-1;
		this.empName="N/A";
		this.empSal=-1;
		this.present=true;
		days=new int[SIZE];
		for(int i=0;i<days.length;i++){
			days[i]=-1;
		}
	}
	public Employee(int empId,String empName,double empSal,boolean present){
		this();
		this.empId=empId;
		this.empName=empName;
		this.empSal=empSal;
		this.present=present;
	}
	public Employee(int empId,String empName){
		this();
		this.empId=empId;
		this.empName=empName;
		//this();
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = present;
	}
	
	public void printEmployee(){
		System.out.println("EMPID   :: "+this.empId);
		System.out.println("NAME    :: "+this.empName);
		System.out.println("SALARY  :: "+this.empSal);
		System.out.println("PRESENT :: "+this.present);
		System.out.print("DAYS :: [");
		for(int num : days){
			System.out.print(num +" ");
		}
		System.out.println("].");
	}
	@Override
	public boolean equals(Object obj) {
		Employee emp=(Employee)obj;
		if(this.empId==emp.empId){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		
		return this.empId+" : "+this.empName;
	}
}
