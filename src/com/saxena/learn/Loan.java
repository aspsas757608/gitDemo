package com.ejb.jpa;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Loan {

	@Id
	@Column(name = "LOAN_ID")
	private Long loanid;

	@ManyToMany(mappedBy="loans")
	private Set<Customer> customers; 

}
