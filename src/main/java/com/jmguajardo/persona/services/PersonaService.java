package com.jmguajardo.persona.services;

import java.time.LocalDateTime;
import java.util.List;

import com.jmguajardo.persona.exceptions.DouplicateRegisterException;
import com.jmguajardo.persona.exceptions.EmptyPersonaListException;
import com.jmguajardo.persona.exceptions.PersonaNotFoundException;
import com.jmguajardo.persona.models.entities.Empresa;
import com.jmguajardo.persona.models.entities.Persona;
import com.jmguajardo.persona.models.requests.CreateEmpresa;
import com.jmguajardo.persona.models.requests.CreatePersona;
import com.jmguajardo.persona.models.requests.Saludo;
import com.jmguajardo.persona.repositories.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonaService {
    
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    EmpresaService empresaService;

    public Persona createPersona(CreatePersona cPersona){
        Empresa empresa = empresaService.searchEmpresa(cPersona.getEmpresa())
            .orElseGet(() -> empresaService.createEmpresa(new CreateEmpresa(cPersona.getEmpresa(), cPersona.getDireccionEmpresa())));
        Persona persona = new Persona(cPersona);
        persona.setEmpresa(empresa);
        try {
            persona = personaRepository.save(persona);
        } catch (DataIntegrityViolationException e) {
            throw new DouplicateRegisterException();
        }
        return persona;
    }

    public List<Persona> getAllPersona(){
        List<Persona> personas = personaRepository.findAll();
        if(personas.isEmpty()) throw new EmptyPersonaListException(); 
        return personas;
    }

    public Persona getPersonaByNombre(String nombre){
        return personaRepository.findByNombre(nombre)
        .orElseThrow(() -> new PersonaNotFoundException());
    }

    public Saludo getSaludo(){
        LocalDateTime date = LocalDateTime.now();
        Integer hora = date.getHour();
        String url = "http://localhost:8082/api/saludo/get/morning";
        if(hora > 11 && hora < 18) url ="http://localhost:8082/api/saludo/get/evening";
        if(hora > 17 && hora < 4) url ="http://localhost:8082/api/saludo/get/night";
        RestTemplate template = new RestTemplate();
        Saludo saludo = template.getForObject(url, Saludo.class);
        return saludo;
    }

}
