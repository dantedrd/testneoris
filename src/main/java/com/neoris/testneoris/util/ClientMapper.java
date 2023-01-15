package com.neoris.testneoris.util;

import com.neoris.testneoris.dtos.ClientDto;
import com.neoris.testneoris.entities.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(ignore = true, target = "accountEntity")
    ClientEntity ClientToClientEntity(ClientDto clientDto);
    @Mapping(ignore = true, target = "accountEntity")
    ClientDto ClientEntityToClient(ClientEntity clientEntity);

}
