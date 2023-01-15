package com.neoris.testneoris;

import com.neoris.testneoris.dtos.ResponseDto;
import com.neoris.testneoris.exceptions.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<ResponseDto<String>> validationException(BusinessException ex){
     return new ResponseEntity<>(new ResponseDto<>("",ex.getReason()),ex.getStatus());
    }
}
