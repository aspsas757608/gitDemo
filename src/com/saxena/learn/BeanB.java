package com.saxena.learn;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
@RolesAllowed("CONTROLLER")
public class BeanB implements B {
	
	@Resource
	private SessionContext sessionContext;

	public void someb() {
		System.out
				.println("WHO CALLLED B" + sessionContext.getCallerPrincipal());

	}

}
