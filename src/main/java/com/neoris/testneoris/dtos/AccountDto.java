package com.neoris.testneoris.dtos;


import com.neoris.testneoris.enums.AccountType;

public class AccountDto {
    Long accountNumber;
    AccountType typeAccount;
    long initialAmount;

    long amount;
    Boolean state;
    private MovementDto movement;
    private ClientDto client;

    public AccountDto() {
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(AccountType typeAccount) {
        this.typeAccount = typeAccount;
    }

    public long getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(long initialAmount) {
        this.initialAmount = initialAmount;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public MovementDto getMovement() {
        return movement;
    }

    public void setMovement(MovementDto movement) {
        this.movement = movement;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
