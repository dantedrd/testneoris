package com.neoris.testneoris.services;

import com.neoris.testneoris.adapters.AccountAdapterRepository;
import com.neoris.testneoris.adapters.ClientAdapterRepository;
import com.neoris.testneoris.dtos.AccountDto;
import com.neoris.testneoris.dtos.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    ClientAdapterRepository clientAdapterRepository;
    public ClientDto saveClient(ClientDto clientDto){
        clientDto.setClientid(UUID.randomUUID().toString());
        return clientAdapterRepository.saveClient(clientDto);
    }

    public ClientDto findClientByIdentification(Long identification){
        return clientAdapterRepository.findClientByIdentification(identification);
    }
}
