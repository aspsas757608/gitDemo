package com.psl.employeeproject;

public class TestEmployee {

	public static void main(String[] args) {
		Employee e1=new Employee();
		e1.printEmployee();
//		System.out.println("ID :: "+e1.getEmpId());
//		System.out.println("Name :: "+e1.getEmpName());
//		System.out.println("Salary :: "+e1.getEmpSal());
//		System.out.println("Present :: "+e1.isPresent());
		System.out.println("--------------------------");
		Employee e2=new Employee(5, "Ameya ", 33333, true);
		e2.printEmployee();
		System.out.println("--------------------------");
		Employee e3=new Employee(7, "Amit");
		e3.printEmployee();
		System.out.println("--------------------------");
		System.out.println("SIZE :: "+Employee.SIZE);
		System.out.println(e1 );
		System.out.println(e2);
		System.out.println(e3);
		Employee e4=e3;
		System.out.println(e4);
	}

}
