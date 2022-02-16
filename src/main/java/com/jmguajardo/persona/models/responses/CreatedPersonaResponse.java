package com.jmguajardo.persona.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmguajardo.persona.models.entities.Persona;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedPersonaResponse {

    private String saludo;

    private String id;

    private String nombre;

    private Integer edad;

    private String empresa;

    @JsonProperty("direccion_empresa")
    private String direccionEmpresa;

    public CreatedPersonaResponse(Persona persona){
        this.id = persona.getId().toString();
        this.nombre = persona.getNombre();
        this.edad = persona.getEdad();
        this.empresa = persona.getEmpresa().getEmpresa();
        this.direccionEmpresa = persona.getEmpresa().getDireccion();
    }

}
