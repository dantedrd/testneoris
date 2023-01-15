package com.neoris.testneoris.util;

import com.neoris.testneoris.dtos.AccountDto;
import com.neoris.testneoris.dtos.ClientDto;
import com.neoris.testneoris.entities.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {ClientMapper.class})
public interface AccountMapper {
    //@Mapping(ignore = true, target = "accountNumber")
    AccountEntity AccountToAccountEntity(AccountDto accountDto);
    AccountDto AccountEntityToAccount(AccountEntity accountEntity);

}
