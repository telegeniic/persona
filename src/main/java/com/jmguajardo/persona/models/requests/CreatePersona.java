package com.jmguajardo.persona.models.requests;

import com.jmguajardo.persona.models.entities.Empresa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersona {
    
    private String nombre;

    private Integer edad;

    private Empresa empresa;
}
