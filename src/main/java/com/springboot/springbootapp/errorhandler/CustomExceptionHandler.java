
package com.springboot.springbootapp.errorhandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.springbootapp.exception.BadGatewayException;
import com.springboot.springbootapp.exception.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleException(HttpServletRequest req, Exception exception) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		String code = null;
		String message = "Internal Server Error";
		BadGatewayException badGateWayException = null;
		ErrorResponse errorResponse = new ErrorResponse();
		//check exception and set the appropiate httpStatuscode
		if (exception instanceof BadGatewayException) {
			badGateWayException = (BadGatewayException) exception;
			errorResponse.setCode(badGateWayException.getParameters().get("HTTP_STATUS_CODE").toString());
			errorResponse.setMessage(badGateWayException.getMessage());
		}
		return new ResponseEntity<>(errorResponse, status);
	}

}
