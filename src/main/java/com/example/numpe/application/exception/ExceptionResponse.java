package com.example.numpe.application.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/* Classe de mapeamento do retorno da exceção que foi capturada */

public class ExceptionResponse {
    private String errorMessage;
    private String erroCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ExceptionResponse (String errorMessage,String errorCode){
        this.errorMessage = errorMessage;
        this.erroCode = errorCode;
        this.timestamp = LocalDateTime.now();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErroCode() {
        return erroCode;
    }

    public void setErroCode(String erroCode) {
        this.erroCode = erroCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
