package com;

import java.io.File;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.bank.beans.AuthenticationRemote;
import com.ejb.security.Facade;
import com.ejb.security.FacadeRemote;

public class SecurityClient {
	public static void main(String[] args) {
		try {
			FacadeRemote facade = null;
			Properties config = new Properties();
			config.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jboss.naming.NamingContextFactory");
			config.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			InitialContext ctx = new InitialContext(config);
			facade = (FacadeRemote) ctx.lookup("BankApp/FacadeBean/remote");
			facade.hello();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
