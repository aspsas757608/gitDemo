package com.ejb.jpa;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IDAO {
	public abstract void create(Object account);

	public abstract void delete(Object account);

	public abstract void update(Object account);

	public abstract List<Account> findAllAccounts();

	public abstract List<Customer> findAllCustomers();

}