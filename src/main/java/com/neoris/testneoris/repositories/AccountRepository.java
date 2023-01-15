package com.neoris.testneoris.repositories;

import com.neoris.testneoris.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    public AccountEntity findByAccountNumber(Long acountNumber);
}
