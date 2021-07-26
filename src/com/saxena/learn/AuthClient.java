package com.saxena.learn;

import java.io.File;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.bank.beans.AuthenticationRemote;

public class AuthClient {
	public static void main(String[] args) {
		try {

			File file = new File("c:/handle.ser");
			AuthenticationRemote auth = null;
			Properties config = new Properties();
			config.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jboss.naming.NamingContextFactory");
			config.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			InitialContext ctx = new InitialContext(config);
			auth = (AuthenticationRemote) ctx
					.lookup("BankApp/AuthenticationBean/remote");
			auth.authenticate("sdsd", "xx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
