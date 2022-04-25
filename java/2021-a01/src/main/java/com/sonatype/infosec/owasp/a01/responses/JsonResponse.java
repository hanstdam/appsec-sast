package com.sonatype.infosec.owasp.a01.responses;

import Enumerations.ApiErrorCode;

public class JsonResponse {
	String message;
	Integer errorCode;

    public JsonResponse(ApiErrorCode errorCode, String message) {
        this.message = message;
        this.errorCode = errorCode.getErrorCode();
    }

    public String getMessage() {
        return message;
    }

    public Integer getErrorCode() {
    	return errorCode;
    }
}
