package com.jmguajardo.persona.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmpresa {
    
    private String empresa;

    private String direccion;
}
