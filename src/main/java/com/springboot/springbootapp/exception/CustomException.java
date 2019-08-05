package com.springboot.springbootapp.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class CustomException extends AbstractApplicationException {

	private static final long serialVersionUID = 1L;
	
    private final transient Map<String, Object> parameters;
    
    private static final String HTTP_STATUS_CODE=null;
    
    private static String message = "ERR_MSG";

    
    public CustomException(HttpStatus httpStatusCode, final String errMsg, final Throwable cause) {
        super(cause);
        this.parameters = initMap(errMsg, httpStatusCode);       
    }

    private Map<String, Object> initMap(final String errMsg, HttpStatus httpStatusCode) {
        final Map<String, Object> ret = new HashMap<>();
        ret.put(message, errMsg);
        ret.put(HTTP_STATUS_CODE, httpStatusCode);
        return ret;
    }
	
	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public Map<String, Object> getParameters() {
		return Collections.unmodifiableMap(parameters);
	}   
    
}
