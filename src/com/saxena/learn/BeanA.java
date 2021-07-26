package com.saxena.learn;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagementType;
import javax.ejb.TransactionManagement;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@RolesAllowed("CONTROLLER")
public class BeanA implements A {

	@Resource
	private SessionContext sessionContext;

	public String somea() {

		System.out.println("WHO CALLLED A"
				+ sessionContext.getCallerPrincipal());

		return null;
	}

}
