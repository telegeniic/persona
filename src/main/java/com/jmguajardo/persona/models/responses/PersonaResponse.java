package com.jmguajardo.persona.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmguajardo.persona.models.entities.Persona;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaResponse {

    private String saludo;

    private String nombre;

    private Integer edad;

    private String empresa;

    @JsonProperty("direccion_empresa")
    private String direccionEmpresa;

    public PersonaResponse(Persona persona){
        this.nombre = persona.getNombre();
        this.edad = persona.getEdad();
        this.empresa = persona.getEmpresa().getEmpresa();
        this.direccionEmpresa = persona.getEmpresa().getDireccion();
    }

}
