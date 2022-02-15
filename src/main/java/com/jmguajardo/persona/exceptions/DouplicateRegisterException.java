package com.jmguajardo.persona.exceptions;

import lombok.Getter;

@Getter
public class DouplicateRegisterException extends RuntimeException{

    private Integer cod = 800;

    public DouplicateRegisterException(){
        super("Nombre existe, guardar otro nombre");
    }
    
}
