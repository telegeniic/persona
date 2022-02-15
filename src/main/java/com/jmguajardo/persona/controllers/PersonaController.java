package com.jmguajardo.persona.controllers;

import com.jmguajardo.persona.models.requests.CreatePersona;
import com.jmguajardo.persona.models.responses.PersonaResponse;
import com.jmguajardo.persona.services.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public PersonaResponse createPersona(@RequestBody CreatePersona cPersona){
        PersonaResponse rPersona = new PersonaResponse(personaService.createPersona(cPersona));
        return rPersona;
    }

}
