
package com.springboot.springbootapp.errorhandler;

import org.aspectj.lang.JoinPoint;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.springboot.springbootapp.errorhandler.inter.IExceptionInterceptor;
import com.springboot.springbootapp.exception.BadGatewayException;

@Component
public class ExceptionInterceptor implements IExceptionInterceptor{

	@Override
	public void handleErrors(JoinPoint joinPoint, Throwable ex) {
		String serviceName = joinPoint.getSignature().getName();
		throw new BadGatewayException(serviceName, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, ex);
	}
}
