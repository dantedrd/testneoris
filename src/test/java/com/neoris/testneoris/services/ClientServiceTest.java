package com.neoris.testneoris.services;

import com.neoris.testneoris.adapters.AccountAdapterRepository;
import com.neoris.testneoris.adapters.ClientAdapterRepository;
import com.neoris.testneoris.dtos.AccountDto;
import com.neoris.testneoris.dtos.ClientDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;


@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @InjectMocks
    ClientService clientService;

    @Mock
    ClientAdapterRepository clientAdapterRepository;


    @Test
    public void shouldSaveClient(){
        ClientDto clientDto=new ClientDto();
        clientDto.setIdentification(12L);
        clientDto.setEstado(true);

        Mockito.when(clientAdapterRepository.saveClient(any(ClientDto.class))).thenReturn(clientDto);


        ClientDto clientDtoResult=clientService.saveClient(clientDto);

        assertEquals(clientDto.getIdentification(),clientDtoResult.getIdentification());
    }

    @Test
    public void shouldFindClient(){
        ClientDto clientDto=new ClientDto();
        clientDto.setIdentification(12L);
        clientDto.setEstado(true);

        Mockito.when(clientAdapterRepository.findClientByIdentification(eq(12L))).thenReturn(clientDto);
        ClientDto clientDtoResult=clientService.findClientByIdentification(12l);
        assertEquals(clientDtoResult.getIdentification(),clientDto.getIdentification());
    }
}