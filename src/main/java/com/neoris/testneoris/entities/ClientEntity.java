package com.neoris.testneoris.entities;

import com.neoris.testneoris.dtos.PersonDto;

import javax.persistence.*;

@Entity
@Table(name = "CLIENT")
public class ClientEntity extends PersonEntity {

    String clientid;
    String password;
    Boolean estado;

    @OneToOne(mappedBy = "client")
    private AccountEntity accountEntity;

    public ClientEntity() {
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clienteid) {
        this.clientid = clienteid;
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

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
