package com.psl.employeeproject;

public class InvalidNumberException extends Exception {
	private int details;
	
	public InvalidNumberException(int details){
		this.details=details;
	}
	@Override
	public String toString() {
	
		return "Exception Occured !!! ["+details+"]";
	}
}
