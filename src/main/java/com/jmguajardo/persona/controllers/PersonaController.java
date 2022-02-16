package com.jmguajardo.persona.controllers;

import java.util.ArrayList;
import java.util.List;

import com.jmguajardo.persona.models.entities.Persona;
import com.jmguajardo.persona.models.requests.CreatePersona;
import com.jmguajardo.persona.models.requests.Saludo;
import com.jmguajardo.persona.models.responses.PersonaResponse;
import com.jmguajardo.persona.models.responses.CreatedPersonaResponse;
import com.jmguajardo.persona.services.PersonaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(PersonaController.class);
    
    @Autowired
    PersonaService personaService;

    @PostMapping("post/agregar_persona")
    public CreatedPersonaResponse createPersona(@RequestBody CreatePersona cPersona){
        CreatedPersonaResponse rPersona = new CreatedPersonaResponse(personaService.createPersona(cPersona));
        Saludo saludo = personaService.getSaludo();
        rPersona.setSaludo(saludo.getSaludo());
        logger.info("tipo del saludo: "+saludo.getTipo());
        logger.info("contenido del saludo: "+saludo.getSaludo());
        logger.info("Persona agregada: "+rPersona);
        return rPersona;
    }

    @GetMapping("get/todas_las_personas")
    public List<PersonaResponse> getAllPersona(){
        List<Persona> personas = personaService.getAllPersona();
        List<PersonaResponse> response = new ArrayList<>();
        personas.forEach(p -> response.add(new PersonaResponse(p)));
        logger.info("Se esta accediendo a la lista de personas");
        logger.info("tamaño de la lista: "+response.size());
        return response;
    }

    @GetMapping("get/{nombre}")
    public PersonaResponse getPersonaByNombre(@PathVariable String nombre){
        logger.info("Se esta buscando el registro de la persona: "+nombre);
        return new PersonaResponse(personaService.getPersonaByNombre(nombre));
    }

}
