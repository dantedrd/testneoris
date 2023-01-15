package com.neoris.testneoris.adapters;

import com.neoris.testneoris.dtos.AccountDto;
import com.neoris.testneoris.dtos.ClientDto;
import com.neoris.testneoris.repositories.ClientRepository;
import com.neoris.testneoris.util.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientAdapterRepository {
    private ClientRepository repository;

    private ClientMapper mapper;


    @Autowired
    public ClientAdapterRepository(ClientRepository repository,ClientMapper mapper) {
        this.repository = repository;
        this.mapper=mapper;
    }

    public ClientDto findClientByIdentification(Long identification){
        return mapper.ClientEntityToClient(this.repository.findByIdentification(identification));
    }

    public ClientDto saveClient(ClientDto clientDto){
        return mapper.ClientEntityToClient(this.repository.save(mapper.ClientToClientEntity(clientDto)));
    }



}
