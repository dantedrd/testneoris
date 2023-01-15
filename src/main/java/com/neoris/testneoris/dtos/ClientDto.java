package com.neoris.testneoris.dtos;

import com.neoris.testneoris.entities.AccountEntity;

public class ClientDto extends PersonDto {
    String clientid;
    String password;
    Boolean estado;

    private AccountDto accountEntity;

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public AccountDto getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountDto accountEntity) {
        this.accountEntity = accountEntity;
    }
}
