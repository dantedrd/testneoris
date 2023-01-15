package com.neoris.testneoris.adapters;

import com.neoris.testneoris.dtos.Test;
import com.neoris.testneoris.entities.TestEntity;
import com.neoris.testneoris.repositories.TestRepository;
import com.neoris.testneoris.util.TestMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class TestAdapterRepository {
    private TestRepository repository;

    private TestMapper mapper = Mappers.getMapper(TestMapper.class);

    @Autowired
    public TestAdapterRepository(TestRepository repository) {
        this.repository = repository;
    }

    public TestEntity save(Test test) {
      return  this.repository.save(this.mapper.TestToTestEntity(test));
    }

    public List<Test> getAllTest() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .map(mapper::TestEntityToTest)
                .collect(Collectors.toList());
    }
}
