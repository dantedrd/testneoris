package com.neoris.testneoris.exceptions;

import java.util.function.Supplier;

public enum Type {
    NOT_HAS_FOUNDS("Saldo no disponible");

    private final String message;

    public String getMessage() {
        return message;
    }

    public BusinessException build() {
        return new BusinessException(this);
    }

    public Supplier<Throwable> defer() {
        return () -> new BusinessException(this);
    }

    Type(String message) {
        this.message = message;
    }

}
