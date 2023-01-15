package com.neoris.testneoris.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Movement")
public class MovementEntity {
    @Id
    Long id;
    Date date;
    String typeMovement;

    long movement;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AccountEntity account;

    public MovementEntity() {
    }

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

    public String getTypeMovement() {
        return typeMovement;
    }

    public void setTypeMovement(String typeMovement) {
        this.typeMovement = typeMovement;
    }



    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public long getMovement() {
        return movement;
    }

    public void setMovement(long movement) {
        this.movement = movement;
    }


}
