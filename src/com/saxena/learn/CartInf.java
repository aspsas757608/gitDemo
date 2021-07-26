package com.bank.authentication;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CartInf {
	
	public void initialize (String person);
	//public void initialize (String person, String id);
	public void addBook(String title);
	public void removeBook(String title);
	public List<String> getContents();
	public void remove();
	
}
