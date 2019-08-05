package com.springboot.springbootapp.errorhandler.inter;

import org.aspectj.lang.JoinPoint;

public interface IErrorHandlerAspect {
	 public void handleErrors(JoinPoint joinPoint, Exception ex);
}
