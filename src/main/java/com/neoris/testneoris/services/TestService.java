package com.neoris.testneoris.services;

import com.neoris.testneoris.adapters.TestAdapterRepository;
import com.neoris.testneoris.dtos.Test;
import com.neoris.testneoris.entities.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestAdapterRepository testAdapterRepository;

    public TestEntity save(Test test) {
        return  this.testAdapterRepository.save(test);
    }

    public List<Test> getAllTest() {
        return testAdapterRepository.getAllTest();
    }

}
