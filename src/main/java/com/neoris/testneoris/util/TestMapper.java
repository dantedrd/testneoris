package com.neoris.testneoris.util;

import com.neoris.testneoris.dtos.Test;
import com.neoris.testneoris.entities.TestEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestMapper {
    TestEntity TestToTestEntity(Test test);
    Test TestEntityToTest(TestEntity test);
}
