package com.neoris.testneoris.adapters;

import com.neoris.testneoris.dtos.MovementDto;
import com.neoris.testneoris.dtos.MovementRequestDto;
import com.neoris.testneoris.repositories.MovementRepository;
import com.neoris.testneoris.util.MovementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovementAdapterRepository {

    private MovementRepository repository;

    private MovementMapper mapper;


    @Autowired
    public MovementAdapterRepository(MovementRepository repository,MovementMapper mapper) {
        this.repository = repository;
        this.mapper=mapper;
    }

    public MovementDto save(MovementDto movementDto) {
       return this.mapper.MovementEntityToMovement(this.repository
                .save(this.mapper.MovementToMovementEntity(movementDto)));
    }



    public List<MovementDto> getMovementsByDate(MovementRequestDto movementRequestDto) {
        return this.repository.findAllMovementsByDateAndIdentification(movementRequestDto.getStartDate(),movementRequestDto.getEndDate(),movementRequestDto.getIdentification())
                .stream()
                .map(this.mapper::MovementEntityToMovement)
                .collect(Collectors.toList());
    }


}
