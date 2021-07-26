package com.saxena.learn;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class BaseDAO implements IDAO {

	@PersistenceContext(unitName = "BankEJB")
	private EntityManager em;

	public void create(Object account) {
		em.persist(account);
	}

	public void delete(Object account) {
		em.remove(account);
	}

	public void update(Object account) {
		em.merge(account);
	}

	public List<Account> findAllAccounts() {
		Query query = em.createQuery("from Account");
		return query.getResultList();
	}

	public List<Customer> findAllCustomers() {
		Query query = em.createQuery("from Customer");
		return query.getResultList();
	}
}
