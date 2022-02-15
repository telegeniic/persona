package com.jmguajardo.persona.exceptions;

import lombok.Getter;

@Getter
public class PersonaNotFoundException extends RuntimeException{
    
    private Integer cod = 1000;

    public PersonaNotFoundException(){
        super("Persona desconocida");
    }
}
