package com.neoris.testneoris.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends ApplicationException {

    public BusinessException(Type type) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, ApplicationError.ApplicationCode.GENERAL, ApplicationError.ApplicationErrorCode.BUSINESS_ERROR, type.getMessage());
    }

    public BusinessException(Type type, String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, ApplicationError.ApplicationCode.GENERAL, ApplicationError.ApplicationErrorCode.BUSINESS_ERROR, String.format(type.getMessage(), message));
    }
}
