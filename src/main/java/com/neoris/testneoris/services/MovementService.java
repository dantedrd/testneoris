package com.neoris.testneoris.services;

import com.neoris.testneoris.adapters.AccountAdapterRepository;
import com.neoris.testneoris.adapters.MovementAdapterRepository;
import com.neoris.testneoris.adapters.TestAdapterRepository;
import com.neoris.testneoris.dtos.AccountDto;
import com.neoris.testneoris.dtos.MovementDto;
import com.neoris.testneoris.dtos.MovementRequestDto;
import com.neoris.testneoris.dtos.ReportMovementDto;
import com.neoris.testneoris.enums.MovementType;
import com.neoris.testneoris.exceptions.BusinessException;
import com.neoris.testneoris.exceptions.Type;
import com.neoris.testneoris.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovementService {

    @Autowired
    MovementAdapterRepository movementAdapterRepository;

    @Autowired
    AccountService accountService;

   public MovementDto saveMovement(MovementDto movementDto){
       AccountDto accountDto=this.accountService.findAccountByNumber(movementDto.getAccount().getAccountNumber());
       validFunds(accountDto);
       accountDto=validCreditOrDebit(accountDto,movementDto);
       movementDto.setAccount(accountDto);
       movementDto.setDate(new Date());
       return movementAdapterRepository.save(movementDto);
   }

   private void validFunds(AccountDto accountDto){
       if(accountDto.getAmount()==0){
           throw new BusinessException(Type.NOT_HAS_FOUNDS);
       }
   }

   private AccountDto validCreditOrDebit(AccountDto accountDto,MovementDto movementDto){
       if(MovementType.CREDIT.equals(movementDto.getTypeMovement())){
           accountDto.setAmount(accountDto.getAmount()+movementDto.getMovement());
           return accountDto;
       }
       accountDto.setAmount(accountDto.getAmount()-movementDto.getMovement());
       return accountDto;
   }

    public List<ReportMovementDto> getMovementByDate(MovementRequestDto movementRequestDto){
        return movementAdapterRepository.getMovementsByDate(movementRequestDto)
                .stream().map(this::mapReport)
                .collect(Collectors.toList());
    }

    private ReportMovementDto mapReport(MovementDto movementDto){
       ReportMovementDto reportMovementDto=new ReportMovementDto();
       reportMovementDto.setDate(movementDto.getDate());
       reportMovementDto.setClient(movementDto.getAccount().getClient().getName());
       reportMovementDto.setAccountNumber(movementDto.getAccount().getAccountNumber());
       reportMovementDto.setType(movementDto.getAccount().getTypeAccount().getName());
       reportMovementDto.setInitialAmount(movementDto.getAccount().getInitialAmount());
       reportMovementDto.setState(movementDto.getAccount().getState());
       reportMovementDto.setMovement(MovementType.CREDIT.equals(movementDto.getTypeMovement())?""+movementDto.getMovement():"-"+movementDto.getMovement());
       reportMovementDto.setAmount(movementDto.getAccount().getAmount());
       return reportMovementDto;
   }
}
