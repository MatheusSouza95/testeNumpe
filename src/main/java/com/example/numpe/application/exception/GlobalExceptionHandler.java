package com.example.numpe.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* Classe para a captura de forma global da exceção IllegalArgumentException,
   com isso podemos interceptar o codigo e tratar o retorno.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentException(IllegalArgumentException ex){
        ExceptionResponse response  = new ExceptionResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.toString()) ;
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
