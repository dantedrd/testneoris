package com.neoris.testneoris.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neoris.testneoris.dtos.*;
import com.neoris.testneoris.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movement")
public class MovementController {
    @Autowired
    private MovementService movementService;

    @PostMapping()
    public ResponseDto<MovementDto> saveResults(@RequestBody MovementDto movementDto) {
        return new ResponseDto<>(movementService.saveMovement(movementDto),"");
    }

    @GetMapping("/reports")
    public ResponseDto<List<ReportMovementDto>> getMovements(@RequestParam Map<String,String> movementRequest) {
        ObjectMapper mapper = new ObjectMapper();
        MovementRequestDto movementRequestDto = mapper.convertValue(movementRequest, MovementRequestDto.class);
        return new ResponseDto<>(movementService.getMovementByDate(movementRequestDto),"");
    }


}
