package com.saxena.learn;

import javax.ejb.Remote;

@Remote
public interface AuthenticationRemote {
	
	public void authenticate(String uname, String pwd);

}
