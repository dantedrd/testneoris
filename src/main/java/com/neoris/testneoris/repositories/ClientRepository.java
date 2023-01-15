package com.neoris.testneoris.repositories;

import com.neoris.testneoris.entities.AccountEntity;
import com.neoris.testneoris.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    public ClientEntity findByIdentification(Long identification);
}
