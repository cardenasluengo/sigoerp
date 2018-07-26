/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.empresaservice.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
import com.sigoerp.empresaservice.entities.FuncionarioEntity;
import com.sigoerp.empresaservice.repositories.FuncionarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioRepository repository;
    
    @GetMapping()
    public List<FuncionarioEntity> list() {
        return repository.findAll();
    }
    
    @GetMapping("/{rut}")
    public ResponseEntity<FuncionarioEntity> get(@PathVariable String rut) {
        Optional<FuncionarioEntity> funcionario = repository.findById(rut);
        if(funcionario.isPresent()) {
            
            return new ResponseEntity(funcionario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{rut}")
    public ResponseEntity<FuncionarioEntity> put(@PathVariable String rut, @RequestBody FuncionarioEntity funcionarioEditar) {
        
        Optional<FuncionarioEntity> funcionarioO = repository.findById(rut);
        if (funcionarioO.isPresent()) {
            
            funcionarioEditar.setRut(funcionarioO.get().getRut());
            repository.save(funcionarioEditar);        
            return new ResponseEntity<>(funcionarioEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
 
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody FuncionarioEntity nuevoFuncionario) {
        
        nuevoFuncionario = repository.save(nuevoFuncionario);

        Optional<FuncionarioEntity> funcionarioO = repository.findById(nuevoFuncionario.getRut());
        if (funcionarioO.isPresent()) {
            return new ResponseEntity<>(nuevoFuncionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<?> delete(@PathVariable String rut) {
        
        Optional<FuncionarioEntity> funcionarioO = repository.findById(rut);
        if (funcionarioO.isPresent()) {
            repository.deleteById(rut);
            return new ResponseEntity<>(funcionarioO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
