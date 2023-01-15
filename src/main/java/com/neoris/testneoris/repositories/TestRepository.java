package com.neoris.testneoris.repositories;
import com.neoris.testneoris.entities.TestEntity;
import org.springframework.data.repository.CrudRepository;


public interface TestRepository extends CrudRepository<TestEntity, Long> {
}
