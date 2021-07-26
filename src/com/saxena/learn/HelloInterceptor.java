package com.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext

public class HelloInterceptor {
	
	@AroundInvoke
	public Object log(InvocationContext context) throws Exception
	{
		System.out.println("Log after" + context.getMethod);
		
		Object result = context.proceed();
		System.out.println("Log after" +  context.getMethod());
		return result;
	}
	
	@AroundInvoke
	public Object log1(InvocationContext context) throws Exception
	{
		
	}

}
