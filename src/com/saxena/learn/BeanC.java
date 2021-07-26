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
public class BeanC implements C {

	@Resource
	private SessionContext sessionContext;

	@Override
	public void somec() {
		System.out.println("WHO CALLLED C"
				+ sessionContext.getCallerPrincipal());
	}
}
