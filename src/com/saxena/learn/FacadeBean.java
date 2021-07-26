package com.ejb.security;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@DeclareRoles({ "ADMIN", "MANAGER" })
@RolesAllowed({ "ADMIN", "MANAGER" })
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@RunAs("CONTROLLER")
public class FacadeBean implements FacadeRemote, Facade {

	@Resource
	private SessionContext sessionContext;

	@EJB
	private A a;

	@EJB
	private B b;

	@EJB
	private C c;

	public String hello() {
		System.out
				.println("WHO CALLLED " + sessionContext.getCallerPrincipal());
		a.somea();
		b.someb();
		c.somec();
		return "";
	}
}
