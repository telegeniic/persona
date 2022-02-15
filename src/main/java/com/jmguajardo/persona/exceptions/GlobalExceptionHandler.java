package com.jmguajardo.persona.exceptions;

import com.jmguajardo.persona.payloads.ErrorDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(DouplicateRegisterException.class)
    public ResponseEntity<ErrorDetails> handleDouplicateRegister(DouplicateRegisterException ex){
        ErrorDetails errorDetails = new ErrorDetails(ex.getCod(), ex.getMessage());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmptyPersonaListException.class)
    public ResponseEntity<ErrorDetails> handleEmptyPersonaList(EmptyPersonaListException ex){
        ErrorDetails errorDetails = new ErrorDetails(ex.getCod(), ex.getMessage());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ErrorDetails> handlePersonaNotFound(PersonaNotFoundException ex){
        ErrorDetails errorDetail = new ErrorDetails(ex.getCod(), ex.getMessage());
        return new ResponseEntity<ErrorDetails>(errorDetail, HttpStatus.NOT_FOUND);
    }

}
