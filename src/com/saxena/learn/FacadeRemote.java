package com.ejb.security;

import javax.ejb.Remote;

@Remote
public interface FacadeRemote {
	public String hello();
}
