package com.neoris.testneoris.dtos;

import com.neoris.testneoris.entities.AccountEntity;
import com.neoris.testneoris.enums.MovementType;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

public class MovementDto {
    Long id;
    Date date;
    MovementType typeMovement;

    long movement;
    private AccountDto account;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MovementType getTypeMovement() {
        return typeMovement;
    }

    public void setTypeMovement(MovementType typeMovement) {
        this.typeMovement = typeMovement;
    }

    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }

    public long getMovement() {
        return movement;
    }

    public void setMovement(long movement) {
        this.movement = movement;
    }

}
