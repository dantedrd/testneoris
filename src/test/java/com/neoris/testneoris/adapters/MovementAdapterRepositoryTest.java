package com.neoris.testneoris.adapters;

import com.neoris.testneoris.dtos.ClientDto;
import com.neoris.testneoris.dtos.MovementDto;
import com.neoris.testneoris.dtos.MovementRequestDto;
import com.neoris.testneoris.entities.ClientEntity;
import com.neoris.testneoris.entities.MovementEntity;
import com.neoris.testneoris.enums.MovementType;
import com.neoris.testneoris.repositories.ClientRepository;
import com.neoris.testneoris.repositories.MovementRepository;
import com.neoris.testneoris.util.ClientMapper;
import com.neoris.testneoris.util.MovementMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class MovementAdapterRepositoryTest {
    @InjectMocks
    MovementAdapterRepository movementAdapterRepository;


    @Mock
    private MovementRepository repository;

    @Mock
    private MovementMapper mapper;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(true);
    }
    @Test
    public void shouldSaveMovement(){
        MovementEntity movementEntity=new MovementEntity();
        movementEntity.setMovement(233L);
        movementEntity.setTypeMovement("CREDIT");

        MovementDto movementDto=new MovementDto();
        movementDto.setMovement(233L);
        movementDto.setTypeMovement(MovementType.CREDIT);

        Mockito.when(repository.save(Mockito.any(MovementEntity.class))).thenReturn(movementEntity);
        Mockito.when(mapper.MovementToMovementEntity(Mockito.any(MovementDto.class))).thenReturn(movementEntity);
        Mockito.when(mapper.MovementEntityToMovement(Mockito.any(MovementEntity.class))).thenReturn(movementDto);

        MovementDto movementDtoRes=movementAdapterRepository.save(movementDto);

        assertEquals(movementDtoRes.getMovement(),movementDto.getMovement());
    }

    @Test
    public void shouldFindMovements(){
        MovementRequestDto movementRequestDto=new MovementRequestDto();
        movementRequestDto.setStartDate(new Date());
        movementRequestDto.setEndDate(new Date());
        movementRequestDto.setIdentification(1233L);

        MovementDto movementDto=new MovementDto();
        movementDto.setMovement(233L);
        movementDto.setTypeMovement(MovementType.CREDIT);

        MovementEntity movementEntity=new MovementEntity();
        movementEntity.setMovement(233L);
        movementEntity.setTypeMovement("CREDIT");

        List<MovementEntity> movementEntities=List.of(movementEntity);

        Mockito.when(repository.findAllMovementsByDateAndIdentification(Mockito.any(Date.class),Mockito.any(Date.class),Mockito.any(Long.class))).thenReturn(movementEntities);
        Mockito.when(mapper.MovementEntityToMovement(Mockito.any(MovementEntity.class))).thenReturn(movementDto);

        List<MovementDto> movementDtos=movementAdapterRepository.getMovementsByDate(movementRequestDto);

        assertEquals(movementDtos.get(0).getMovement(),movementDto.getMovement());
    }

}