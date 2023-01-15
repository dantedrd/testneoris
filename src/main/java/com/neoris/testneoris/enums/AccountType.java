package com.neoris.testneoris.enums;

public enum AccountType {
    SAVINGS("SAVINGS","Ahorro"),
    CHECKING("CHECKING","Corriente");

    private final String code;
    private final String name;
    AccountType(String code,String name){
        this.code=code;
        this.name=name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
