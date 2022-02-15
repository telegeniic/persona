package com.jmguajardo.persona.exceptions;

import lombok.Getter;

@Getter
public class EmptyPersonaListException extends RuntimeException{

    private Integer cod = 1500;

    public EmptyPersonaListException(){
        super("No hay personas en la base de datos");
    }
}
