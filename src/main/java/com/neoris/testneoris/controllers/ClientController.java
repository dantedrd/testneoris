package com.neoris.testneoris.controllers;

import com.neoris.testneoris.dtos.AccountDto;
import com.neoris.testneoris.dtos.ClientDto;
import com.neoris.testneoris.dtos.ResponseDto;
import com.neoris.testneoris.services.AccountService;
import com.neoris.testneoris.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping()
    public ResponseDto<ClientDto> saveClient(@RequestBody ClientDto clientDto) {
        return new ResponseDto<>(clientService.saveClient(clientDto),"");
    }
}
