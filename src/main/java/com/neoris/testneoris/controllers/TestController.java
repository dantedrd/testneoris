package com.neoris.testneoris.controllers;

import com.neoris.testneoris.dtos.Test;
import com.neoris.testneoris.entities.TestEntity;
import com.neoris.testneoris.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("/add")
    public TestEntity saveResults(@RequestBody Test test) {
        return testService.save(test);
    }

    @GetMapping("/results")
    List<Test> getAll() {
        return testService.getAllTest();
    }
}
