package com.springboot.springbootapp.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class BadGatewayException extends AbstractApplicationException {

	private static final long serialVersionUID = 1L;

	private final String message;

	private final transient Map<String, Object> parameters;

	public static final String SERVICE_NAME = "SERVICE_NAME";

	public static final String HTTP_STATUS_CODE = "HTTP_STATUS_CODE";

	public BadGatewayException(final String serviceName, final String gatewayErrMsg, final HttpStatus gatewayStatus,
			final Throwable cause) {
		super(cause);
		this.parameters = initMap(serviceName, gatewayErrMsg, gatewayStatus);
		this.message = gatewayErrMsg;
	}

	private Map<String, Object> initMap(final String serviceName, final String gatewayErrMsg,
			final HttpStatus gatewayStatus) {
		final Map<String, Object> ret = new HashMap<>();
		ret.put(SERVICE_NAME, serviceName);
		ret.put(HTTP_STATUS_CODE, gatewayStatus);
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
