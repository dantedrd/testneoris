package com.neoris.testneoris.repositories;

import com.neoris.testneoris.entities.MovementEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface MovementRepository extends CrudRepository<MovementEntity, Long> {
   @Query("SELECT m FROM MovementEntity m JOIN m.account a WHERE (m.date BETWEEN ?1 AND ?2) and a.client.identification=?3 ")
    public List<MovementEntity> findAllMovementsByDateAndIdentification(Date timeStart,Date timeEnd,Long identification);

}
