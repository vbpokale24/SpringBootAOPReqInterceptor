package com.springboot.springbootapp.errorhandler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.springbootapp.errorhandler.inter.IErrorHandlerAspect;

@Aspect
@Component
public class ErrorHandlerAspect implements IErrorHandlerAspect{

	@Autowired
	ExceptionInterceptor exceptionInterceptor;
	
	@Override
	@AfterThrowing(pointcut="execution(*  com.springboot.springbootapp..*(..)) && "+
	           "!execution (* com.springboot.springbootapp.errorhandler.ExceptionInterceptor..*(..))", throwing="ex")
    public void handleErrors(JoinPoint joinPoint, Exception ex) {
		exceptionInterceptor.handleErrors(joinPoint, ex);
    }
}
