package com.neoris.testneoris.controllers;

import com.neoris.testneoris.dtos.AccountDto;
import com.neoris.testneoris.dtos.MovementDto;
import com.neoris.testneoris.dtos.ResponseDto;
import com.neoris.testneoris.services.AccountService;
import com.neoris.testneoris.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping()
    public ResponseDto<AccountDto> saveAccount(@RequestBody AccountDto accountDto) {
        return new ResponseDto<>(accountService.saveAccount(accountDto),"");
    }
}
