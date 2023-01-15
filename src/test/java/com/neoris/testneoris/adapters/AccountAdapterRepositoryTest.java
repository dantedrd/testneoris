package com.neoris.testneoris.adapters;

import com.neoris.testneoris.dtos.AccountDto;
import com.neoris.testneoris.entities.AccountEntity;
import com.neoris.testneoris.repositories.AccountRepository;
import com.neoris.testneoris.util.AccountMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountAdapterRepositoryTest {
    @InjectMocks
    AccountAdapterRepository accountAdapterRepository;


    @Mock
    private AccountRepository repository;

    @Mock
    private AccountMapper mapper;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(true);
    }
    @Test
    public void shouldFindAccount(){
        AccountEntity accountEntity=new AccountEntity();
        accountEntity.setAccountNumber(12L);
        accountEntity.setAmount(200000);

        AccountDto accountDto=new AccountDto();
        accountDto.setAccountNumber(12L);
        accountDto.setAmount(200000);

        Mockito.when(repository.findByAccountNumber(Mockito.anyLong())).thenReturn(accountEntity);
        Mockito.when(mapper.AccountEntityToAccount(Mockito.any(AccountEntity.class))).thenReturn(accountDto);

        AccountDto accountDtoRes=accountAdapterRepository.findByNumberAccount(12L);

        assertEquals(accountDtoRes.getAmount(),accountDto.getAmount());
    }

    @Test
    public void shouldSaveAccount(){
        AccountEntity accountEntity=new AccountEntity();
        accountEntity.setAccountNumber(12L);
        accountEntity.setAmount(200000);

        AccountDto accountDto=new AccountDto();
        accountDto.setAccountNumber(12L);
        accountDto.setAmount(200000);

        Mockito.when(repository.save(Mockito.any(AccountEntity.class))).thenReturn(accountEntity);
        Mockito.when(mapper.AccountToAccountEntity(Mockito.any(AccountDto.class))).thenReturn(accountEntity);
        Mockito.when(mapper.AccountEntityToAccount(Mockito.any(AccountEntity.class))).thenReturn(accountDto);

        AccountDto accountDtoRes=accountAdapterRepository.saveAccount(accountDto);

        assertEquals(accountDtoRes.getAmount(),accountDto.getAmount());
    }
}