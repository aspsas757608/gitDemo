package com.bank.authentication;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class CartBean implements CartInf {
	
	String CustomerName;
	String CustomerID;
	List<String> contents;
	
	public void initialize (String person)
	{
		
		if(person == null){
			System.out.println("Null person not allowed");
		}
		else{
			CustomerName = person;
		}
		
		CustomerID ="0";
		contents = new ArrayList<String>();
		
	}
	
	
	
	
	public void addBook(String title){
		
		contents.add(title);
	}
	
	public void removeBook(String title)
	{
		
		boolean result = contents.remove(title);
		
		if(result==false){
			
			System.out.println("not in cart");
		}
		
	}
	
	
	
	
	public List<String> getContents(){
		
		return contents;
	}
	
	
	
	@Remove
	public void remove(){
		contents = null;
	}

}
