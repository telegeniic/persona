package com.jmguajardo.persona.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jmguajardo.persona.models.requests.CreatePersona;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="personas")
public class Persona {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre", unique=true)
    private String nombre;

    @Column(name="edad")
    private Integer edad;

    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresa;

    public Persona(CreatePersona cPersona){
        this.nombre = cPersona.getNombre();
        this.edad = cPersona.getEdad();
    }
    
}
