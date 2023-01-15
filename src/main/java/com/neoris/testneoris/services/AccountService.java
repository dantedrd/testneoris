package com.neoris.testneoris.services;

import com.neoris.testneoris.adapters.AccountAdapterRepository;
import com.neoris.testneoris.dtos.AccountDto;
import com.neoris.testneoris.dtos.ClientDto;
import com.neoris.testneoris.dtos.MovementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    AccountAdapterRepository accountRepository;

    @Autowired
    ClientService clientService;

    public AccountDto saveAccount(AccountDto accountDto){
        ClientDto clientDto=clientService.findClientByIdentification(accountDto.getClient().getIdentification());
        accountDto.setClient(clientDto);
       return accountRepository.saveAccount(accountDto);
    }

    public AccountDto findAccountByNumber(Long accountNumber){
       return accountRepository.findByNumberAccount(accountNumber);
    }
}
