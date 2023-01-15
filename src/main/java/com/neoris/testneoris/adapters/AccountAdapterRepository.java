package com.neoris.testneoris.adapters;

import com.neoris.testneoris.dtos.AccountDto;
import com.neoris.testneoris.dtos.MovementDto;
import com.neoris.testneoris.repositories.AccountRepository;
import com.neoris.testneoris.repositories.MovementRepository;
import com.neoris.testneoris.util.AccountMapper;
import com.neoris.testneoris.util.MovementMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountAdapterRepository {
    private AccountRepository repository;

    private AccountMapper mapper;


    @Autowired
    public AccountAdapterRepository(AccountRepository repository,AccountMapper mapper) {
        this.repository = repository;
        this.mapper=mapper;
    }


    public AccountDto findByNumberAccount(Long accountNumber){
        return mapper.AccountEntityToAccount(this.repository.findByAccountNumber(accountNumber));
    }

    public AccountDto saveAccount(AccountDto accountDto){
        return mapper.AccountEntityToAccount(this.repository.save(mapper.AccountToAccountEntity(accountDto)));
    }

}