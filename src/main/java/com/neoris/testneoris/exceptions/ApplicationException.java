package com.neoris.testneoris.exceptions;

import org.springframework.http.HttpStatus;


public class ApplicationException extends RuntimeException {

    private final HttpStatus status;
    private final String reason;
    private final ApplicationError.ApplicationErrorCode code;
    private final ApplicationError.ApplicationCode app;

    public ApplicationException(HttpStatus status, ApplicationError.ApplicationCode appCode, ApplicationError.ApplicationErrorCode appErrorCode){
        super(appErrorCode.desc);
        this.status = status;
        this.app = appCode;
        this.code = appErrorCode;
        this.reason = "";
    }

    public ApplicationException(HttpStatus status, ApplicationError.ApplicationCode appCode, ApplicationError.ApplicationErrorCode appErrorCode, String reason){
        super(appErrorCode.desc);
        this.status = status;
        this.app = appCode;
        this.code = appErrorCode;
        this.reason = reason;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    public ApplicationError.ApplicationErrorCode getCode() {
        return code;
    }

    public ApplicationError.ApplicationCode getApp() {
        return app;
    }
}
