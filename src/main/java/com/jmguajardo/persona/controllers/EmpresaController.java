package com.jmguajardo.persona.controllers;

import com.jmguajardo.persona.models.requests.CreateEmpresa;
import com.jmguajardo.persona.models.responses.EmpresaResponse;
import com.jmguajardo.persona.services.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresa/")
public class EmpresaController {
    
    @Autowired
    EmpresaService empresaService;

    @PostMapping("post/crear_empresa")
    public EmpresaResponse createEmpresa(@RequestBody CreateEmpresa cEmpresa){
        return new EmpresaResponse(empresaService.createEmpresa(cEmpresa));
    }
}
