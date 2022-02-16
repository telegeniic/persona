package com.jmguajardo.persona.exceptions;

import com.jmguajardo.persona.payloads.ErrorDetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler(DouplicateRegisterException.class)
    public ResponseEntity<ErrorDetails> handleDouplicateRegister(DouplicateRegisterException ex){
        ErrorDetails errorDetails = new ErrorDetails(ex.getCod(), ex.getMessage());
        logger.warn("Excepcion: DouplicateRegisterExcepcion");
        logger.warn("Causa: Se intento crear un nuevo registro con un nombre ya existente, estos deben ser unicos");
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmptyPersonaListException.class)
    public ResponseEntity<ErrorDetails> handleEmptyPersonaList(EmptyPersonaListException ex){
        ErrorDetails errorDetails = new ErrorDetails(ex.getCod(), ex.getMessage());
        logger.warn("Excepcion: EmptyPersonalListException");
        logger.warn("Causa: Se intento acceder a la lista de personas, pero esta se encuentra vacia, favor de crear primero un registro");
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersonaNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlePersonaNotFound(PersonaNotFoundException ex){
        ErrorDetails errorDetail = new ErrorDetails(ex.getCod(), ex.getMessage());
        logger.warn("Excepcion: PersonaNotFound");
        logger.warn("Causa: Se intento buscar una persona, de la cual no se tiene registro, favor de crear primero el registro o corregir el nombre a buscar");
        return new ResponseEntity<ErrorDetails>(errorDetail, HttpStatus.NOT_FOUND);
    }

}
