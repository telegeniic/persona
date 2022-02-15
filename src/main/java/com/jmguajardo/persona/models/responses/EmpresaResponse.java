package com.jmguajardo.persona.models.responses;

import com.jmguajardo.persona.models.entities.Empresa;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpresaResponse {
    
    private String empresa;

    private String direccion;

    public EmpresaResponse(Empresa empresa){
        this.empresa = empresa.getEmpresa();
        this.direccion = empresa.getDireccion();
    }

}
