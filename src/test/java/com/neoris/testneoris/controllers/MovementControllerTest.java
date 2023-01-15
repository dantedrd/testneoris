package com.neoris.testneoris.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neoris.testneoris.dtos.*;
import com.neoris.testneoris.services.ClientService;
import com.neoris.testneoris.services.MovementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovementController.class)
class MovementControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovementService service;

    @Test
    public void shouldSaveMovement() throws Exception {
        MovementDto movementDto=new MovementDto();
        movementDto.setMovement(12L);


        when(service.saveMovement(any(MovementDto.class))).thenReturn(movementDto);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/movement")
                        .content(asJsonString(movementDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.movement").exists());
    }

    @Test
    public void shouldGetMovements() throws Exception {
        ReportMovementDto reportMovementDto=new ReportMovementDto();
        reportMovementDto.setMovement("3445");

        List<ReportMovementDto> movementDtos=List.of(reportMovementDto);

        when(service.getMovementByDate(any(MovementRequestDto.class))).thenReturn(movementDtos);

        mockMvc.perform(get("/api/movement/reports")
                        .param("startDate", "1673672400000")
                        .param("endDate", "1673672400000")
                        .param("identification", "23324234")
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}