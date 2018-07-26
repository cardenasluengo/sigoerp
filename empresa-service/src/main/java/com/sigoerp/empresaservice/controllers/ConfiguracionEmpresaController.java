/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.empresaservice.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.sigoerp.empresaservice.entities.ConfiguracionEmpresaEntity;
import com.sigoerp.empresaservice.repositories.ConfiguracionEmpresaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/configempresa")
public class ConfiguracionEmpresaController {
    
    @Autowired
    private ConfiguracionEmpresaRepository repository;
    
    @GetMapping()
    public List<ConfiguracionEmpresaEntity> list() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ConfiguracionEmpresaEntity> get(@PathVariable String id) {
        Optional<ConfiguracionEmpresaEntity> config = repository.findById(Long.parseLong(id));
        if(config.isPresent()) {
            return new ResponseEntity(config.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ConfiguracionEmpresaEntity> put(@PathVariable Long id, @RequestBody ConfiguracionEmpresaEntity editar) {
        
        Optional<ConfiguracionEmpresaEntity> opt = repository.findById(id);
        if (opt.isPresent()) {            
            editar.setId(opt.get().getId());
            repository.save(editar);           
            return new ResponseEntity<>(editar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
 
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody ConfiguracionEmpresaEntity nuevo) {
        
        nuevo = repository.save(nuevo);

        Optional<ConfiguracionEmpresaEntity> opt = repository.findById(nuevo.getId());
        if (opt.isPresent()) {
            return new ResponseEntity<>(nuevo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        
        Optional<ConfiguracionEmpresaEntity> opt = repository.findById(id);
        if (opt.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
