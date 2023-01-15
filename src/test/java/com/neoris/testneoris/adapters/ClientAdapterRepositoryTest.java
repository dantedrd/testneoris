package com.neoris.testneoris.adapters;

import com.neoris.testneoris.dtos.AccountDto;
import com.neoris.testneoris.dtos.ClientDto;
import com.neoris.testneoris.entities.AccountEntity;
import com.neoris.testneoris.entities.ClientEntity;
import com.neoris.testneoris.repositories.AccountRepository;
import com.neoris.testneoris.repositories.ClientRepository;
import com.neoris.testneoris.util.AccountMapper;
import com.neoris.testneoris.util.ClientMapper;
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
class ClientAdapterRepositoryTest {
    @InjectMocks
    ClientAdapterRepository clientAdapterRepository;


    @Mock
    private ClientRepository repository;

    @Mock
    private ClientMapper mapper;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(true);
    }
    @Test
    public void shouldFindClient(){
        ClientEntity clientEntity=new ClientEntity();
        clientEntity.setIdentification(2232L);
        clientEntity.setEstado(true);

        ClientDto clientDto=new ClientDto();
        clientDto.setIdentification(2232L);
        clientDto.setEstado(true);

        Mockito.when(repository.findByIdentification(Mockito.anyLong())).thenReturn(clientEntity);
        Mockito.when(mapper.ClientEntityToClient(Mockito.any(ClientEntity.class))).thenReturn(clientDto);

        ClientDto accountDtoRes=clientAdapterRepository.findClientByIdentification(2232L);

        assertEquals(accountDtoRes.getIdentification(),clientDto.getIdentification());
    }

    @Test
    public void shouldSaveAccount(){
        ClientEntity clientEntity=new ClientEntity();
        clientEntity.setIdentification(2232L);
        clientEntity.setEstado(true);

        ClientDto clientDto=new ClientDto();
        clientDto.setIdentification(2232L);
        clientDto.setEstado(true);

        Mockito.when(repository.save(Mockito.any(ClientEntity.class))).thenReturn(clientEntity);
        Mockito.when(mapper.ClientToClientEntity(Mockito.any(ClientDto.class))).thenReturn(clientEntity);
        Mockito.when(mapper.ClientEntityToClient(Mockito.any(ClientEntity.class))).thenReturn(clientDto);

        ClientDto accountDtoRes=clientAdapterRepository.saveClient(clientDto);

        assertEquals(accountDtoRes.getIdentification(),clientDto.getIdentification());
    }
}