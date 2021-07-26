package com.ejb.jpa;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_CUSTOMER")
@NamedQueries(value = { @NamedQuery(name = "allCustomers", query = "select e from Customer e") })
public class Customer {

	@Id
	@Column(name = "CUST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Embedded
	private Address address;

	public Address getAddress() {
		return address;
	}

	public CustomerProfile getProfile() {
		return profile;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setProfile(CustomerProfile profile) {
		this.profile = profile;
	}

	@OneToOne(mappedBy = "customer")
	private CustomerProfile profile;

	// in jpa mappedBY marks bidirectionality
	// the immutable side should have the mappedBy
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Set<Account> accounts;

	@ManyToMany
	@JoinTable(name = "CUSTOMER_LOAN", joinColumns = @JoinColumn(name = "custid"), inverseJoinColumns = @JoinColumn(name = "loanid"))
	private Set<Loan> loans;

	public Set<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	private String customerName;

	public Long getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
