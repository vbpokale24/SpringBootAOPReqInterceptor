package com.springboot.springbootapp.errorhandler.inter;

import org.aspectj.lang.JoinPoint;

public interface IExceptionInterceptor {
	public void handleErrors(JoinPoint joinPoint, Throwable ex);
}
