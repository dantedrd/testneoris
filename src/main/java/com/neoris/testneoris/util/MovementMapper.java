package com.neoris.testneoris.util;

import com.neoris.testneoris.dtos.ClientDto;
import com.neoris.testneoris.dtos.MovementDto;
import com.neoris.testneoris.entities.ClientEntity;
import com.neoris.testneoris.entities.MovementEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {AccountMapper.class})
public interface MovementMapper {
    MovementEntity MovementToMovementEntity(MovementDto movementDto);
    MovementDto MovementEntityToMovement(MovementEntity movementEntity);

}
