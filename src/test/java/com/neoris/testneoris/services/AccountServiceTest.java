package com.neoris.testneoris.services;

import com.neoris.testneoris.adapters.AccountAdapterRepository;
import com.neoris.testneoris.dtos.AccountDto;
import com.neoris.testneoris.dtos.ClientDto;
import com.neoris.testneoris.dtos.MovementDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @InjectMocks
    AccountService accountService;

    @Mock
    AccountAdapterRepository accountRepository;

    @Mock
    ClientService clientService;

    @Test
    public void shouldSaveAccount(){
        ClientDto clientDto=new ClientDto();
        clientDto.setIdentification(12L);
        clientDto.setEstado(true);

        AccountDto accountDto=new AccountDto();
        accountDto.setAccountNumber(12L);
        accountDto.setAmount(12);
        accountDto.setClient(clientDto);

        Mockito.when(clientService.findClientByIdentification(anyLong())).thenReturn(clientDto);
        Mockito.when(accountRepository.saveAccount(any(AccountDto.class))).thenReturn(accountDto);


        AccountDto accountDtoResult=accountService.saveAccount(accountDto);

        assertEquals(accountDtoResult.getAccountNumber(),accountDto.getAccountNumber());


    }

    @Test
    public void shouldFindAccount(){
        AccountDto accountDto=new AccountDto();
        accountDto.setAccountNumber(12L);
        accountDto.setAmount(12);

        Mockito.when(accountRepository.findByNumberAccount(eq(12L))).thenReturn(accountDto);
        AccountDto accountDtoResult=accountService.findAccountByNumber(12l);
        assertEquals(accountDtoResult.getAccountNumber(),accountDto.getAccountNumber());
    }


}