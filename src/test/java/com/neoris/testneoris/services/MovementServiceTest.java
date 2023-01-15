package com.neoris.testneoris.services;

import com.neoris.testneoris.adapters.MovementAdapterRepository;
import com.neoris.testneoris.dtos.*;
import com.neoris.testneoris.entities.MovementEntity;
import com.neoris.testneoris.enums.AccountType;
import com.neoris.testneoris.enums.MovementType;
import com.neoris.testneoris.exceptions.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class MovementServiceTest {
    @InjectMocks
    MovementService movementService;

    @Mock
    MovementAdapterRepository movementAdapterRepository;

    @Mock
    AccountService accountService;

    @Test
    public void shouldSaveMovementInCredit(){
        AccountDto accountDto=new AccountDto();
        accountDto.setAccountNumber(234234L);
        accountDto.setAmount(2000000);

        MovementDto movementDto=new MovementDto();
        movementDto.setMovement(300000);
        movementDto.setTypeMovement(MovementType.CREDIT);
        movementDto.setAccount(accountDto);

        AccountDto accountDtoRes=new AccountDto();
        accountDtoRes.setAccountNumber(234234L);
        accountDtoRes.setAmount(2300000);

        MovementDto movementDtoRes=new MovementDto();
        movementDtoRes.setMovement(300000);
        movementDtoRes.setTypeMovement(MovementType.CREDIT);
        movementDtoRes.setDate(new Date());
        movementDtoRes.setAccount(accountDtoRes);

        Mockito.when(movementAdapterRepository.save(any(MovementDto.class))).thenReturn(movementDtoRes);
        Mockito.when(accountService.findAccountByNumber(234234L)).thenReturn(accountDto);

        MovementDto movementDto1=movementService.saveMovement(movementDto);


        assertEquals(movementDto1.getAccount().getAmount(),accountDtoRes.getAmount());
    }

    @Test
    public void shouldSaveMovementInDebit(){

        AccountDto accountDto=new AccountDto();
        accountDto.setAccountNumber(234234L);
        accountDto.setAmount(2000000);

        MovementDto movementDto=new MovementDto();
        movementDto.setMovement(300000);
        movementDto.setTypeMovement(MovementType.DEBIT);
        movementDto.setAccount(accountDto);

        AccountDto accountDtoRes=new AccountDto();
        accountDtoRes.setAccountNumber(234234L);
        accountDtoRes.setAmount(1700000);

        MovementDto movementDtoRes=new MovementDto();
        movementDtoRes.setMovement(300000);
        movementDtoRes.setTypeMovement(MovementType.DEBIT);
        movementDtoRes.setDate(new Date());
        movementDtoRes.setAccount(accountDtoRes);

        Mockito.when(movementAdapterRepository.save(any(MovementDto.class))).thenReturn(movementDtoRes);
        Mockito.when(accountService.findAccountByNumber(234234L)).thenReturn(accountDto);

        MovementDto movementDto1=movementService.saveMovement(movementDto);


        assertEquals(movementDto1.getAccount().getAmount(),accountDtoRes.getAmount());
    }

    @Test
    public void shouldGenerateErrorWhenNotHaveFounds(){

        AccountDto accountDto=new AccountDto();
        accountDto.setAccountNumber(234234L);
        accountDto.setAmount(0);

        MovementDto movementDto=new MovementDto();
        movementDto.setMovement(300000);
        movementDto.setTypeMovement(MovementType.DEBIT);
        movementDto.setAccount(accountDto);

        AccountDto accountDtoRes=new AccountDto();
        accountDtoRes.setAccountNumber(234234L);
        accountDtoRes.setAmount(1700000);

        MovementDto movementDtoRes=new MovementDto();
        movementDtoRes.setMovement(300000);
        movementDtoRes.setTypeMovement(MovementType.DEBIT);
        movementDtoRes.setDate(new Date());
        movementDtoRes.setAccount(accountDtoRes);

        Mockito.when(accountService.findAccountByNumber(234234L)).thenReturn(accountDto);

        BusinessException thrown = Assertions.assertThrows(BusinessException.class, () -> {
            movementService.saveMovement(movementDto);
        }, "Error de negocio");

        Assertions.assertEquals("Error de negocio", thrown.getMessage());
    }


    @Test
    public void shouldGetMovementsForDate(){
        AccountDto accountDto=new AccountDto();
        accountDto.setClient(new ClientDto());
        accountDto.setTypeAccount(AccountType.CHECKING);
        accountDto.setAmount(323434L);

        MovementDto movementRequestDto=new MovementDto();
        movementRequestDto.setDate(new Date());
        movementRequestDto.setTypeMovement(MovementType.CREDIT);
        movementRequestDto.setAccount(accountDto);

        List<MovementDto> movementDtos=List.of(movementRequestDto);

        Mockito.when(movementAdapterRepository.getMovementsByDate(any(MovementRequestDto.class))).thenReturn(movementDtos);

        List<ReportMovementDto> reports=movementService.getMovementByDate(new MovementRequestDto());

        Assertions.assertEquals(reports.get(0).getAmount(), accountDto.getAmount());

    }
}