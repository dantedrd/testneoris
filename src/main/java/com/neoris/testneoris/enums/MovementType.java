package com.neoris.testneoris.enums;

public enum MovementType {

    DEBIT("DEBIT","Retiro"),
    CREDIT("CREDIT","Deposito");

    private final String code;
    private final String name;
    MovementType(String code,String name){
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
