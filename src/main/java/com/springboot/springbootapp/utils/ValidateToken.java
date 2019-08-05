package com.springboot.springbootapp.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.springboot.springbootapp.exception.BadGatewayException;
import com.springboot.springbootapp.exception.CustomException;

import io.jsonwebtoken.Claims;

@Component
public class ValidateToken {

	public boolean judgeToken(HttpServletRequest request) {
        String token = request.getHeader("token");       
        if (token == null) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Token expired or Invalid",null);
        }else {
        Claims claims = new JWTUtils().decodeJWT(token);
        if(claims.getIssuer().equals("Admin")) {
        	return true;
        }else {
        	throw new CustomException(HttpStatus.BAD_REQUEST, "Token expired or Invalid",null);
        }
    }		
	}
}
