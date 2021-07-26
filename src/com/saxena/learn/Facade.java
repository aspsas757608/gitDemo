package com.ejb.security;

import javax.ejb.Local;

@Local
public interface Facade {

	public String hello();
}
