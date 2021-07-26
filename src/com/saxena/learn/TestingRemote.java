package com.bank.remoteApp;

import com.bank.authentication.AuthenticationRemote;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class TestRemoteJVM_EJB {
	
		
		public static void main(String[] args)
		{
			try {
				
				Properties config = new Properties();
				
				config.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.NamingContextFactory");
				
				config.put(Context.PROVIDER_URL, "jnp://localhost:1099");
				
				InitialContext ctx = new InitialContext(config);
				
				AuthenticationRemote auth  = (AuthenticationRemote) ctx.lookup("StateLessEJBProject/SessionEJBFile/remote");
				
				System.out.println("inside remote application");
				
			}
			
			catch (Exception e){
				e.printStackTrace();
			}
			
		}
		
		
	}