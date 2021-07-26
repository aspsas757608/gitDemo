package com.bank.authentication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class SessionEJBFile implements authenticateInf {
	
	@PostConstruct
	public void initialized(){
		
		System.out.println("@postconstructed");
	}
	
	public  void authenticate(String uname, String pwd){
		
		System.out.println("Inside authenticate method");
		
	}
	
	
	@PreDestroy
	public void destroying(){
		
		System.out.println("preDestroy");
	}
	

}
