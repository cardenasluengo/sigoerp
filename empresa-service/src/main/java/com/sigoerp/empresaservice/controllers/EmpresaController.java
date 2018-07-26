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
import com.sigoerp.empresaservice.entities.EmpresaEntity;
import com.sigoerp.empresaservice.repositories.EmpresaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    
    @Autowired
    private EmpresaRepository repository;
    
    @GetMapping()
    public List<EmpresaEntity> list() {
        return repository.findAll();
    }
    
    @GetMapping("/{rut}")
    public ResponseEntity<EmpresaEntity> get(@PathVariable String rut) {
        Optional<EmpresaEntity> empresa = repository.findById(rut);
        if(empresa.isPresent()) {
            return new ResponseEntity(empresa.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{rut}")
    public ResponseEntity<EmpresaEntity> put(@PathVariable String rut, @RequestBody EmpresaEntity editar) {
        
        Optional<EmpresaEntity> opt = repository.findById(rut);
        if (opt.isPresent()) {
            
            editar.setRut(opt.get().getRut());
            repository.save(editar);        
            return new ResponseEntity<>(editar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
 
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody EmpresaEntity nuevo) {
        
        nuevo = repository.save(nuevo);

        Optional<EmpresaEntity> opt = repository.findById(nuevo.getRut());
        if (opt.isPresent()) {
            return new ResponseEntity<>(nuevo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<?> delete(@PathVariable String rut) {
        
        Optional<EmpresaEntity> opt = repository.findById(rut);
        if (opt.isPresent()) {
            repository.deleteById(rut);
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
