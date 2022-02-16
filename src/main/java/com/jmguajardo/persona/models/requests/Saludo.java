package com.jmguajardo.persona.models.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Saludo {

    private Long id;
    
    private String tipo;

    private String saludo;
}
