package com.jmguajardo.persona.controllers;

import java.util.ArrayList;
import java.util.List;

import com.jmguajardo.persona.models.entities.Persona;
import com.jmguajardo.persona.models.requests.CreatePersona;
import com.jmguajardo.persona.models.responses.PersonaResponse;
import com.jmguajardo.persona.models.responses.CreatedPersonaResponse;
import com.jmguajardo.persona.services.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personas/")
public class PersonaController {
    
    @Autowired
    PersonaService personaService;

    @PostMapping("post/agregar_persona")
    public CreatedPersonaResponse createPersona(@RequestBody CreatePersona cPersona){
        CreatedPersonaResponse rPersona = new CreatedPersonaResponse(personaService.createPersona(cPersona));
        rPersona.setSaludo(personaService.getSaludo().getSaludo());
        return rPersona;
    }

    @GetMapping("get/todas_las_personas")
    public List<PersonaResponse> getAllPersona(){
        List<Persona> personas = personaService.getAllPersona();
        List<PersonaResponse> response = new ArrayList<>();
        personas.forEach(p -> response.add(new PersonaResponse(p)));
        return response;
    }

    @GetMapping("get/{nombre}")
    public PersonaResponse getPersonaByNombre(@PathVariable String nombre){
        return new PersonaResponse(personaService.getPersonaByNombre(nombre));
    }

}
