package com.springboot.springbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.handler.MappedInterceptor;

@org.springframework.context.annotation.Configuration
@ComponentScan("com.springboot.springbootapp.*")
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class Configuration {

	@Bean
	@Autowired
	public MappedInterceptor getMappedInterceptor(MyHandlerInterceptor myHandlerInterceptor) {
		return new MappedInterceptor(new String[] { "/**" }, myHandlerInterceptor);
	}

}
