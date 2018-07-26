/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.controllers;

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
import com.sigoerp.contratoservice.repositories.FuncionRepository;
import com.sigoerp.contratoservice.entities.FuncionEntity;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/funcion")
public class FuncionController {
    
    @Autowired
    private FuncionRepository repository;
    
    @GetMapping()
    public List<FuncionEntity> list() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FuncionEntity> get(@PathVariable String id) {
        Optional<FuncionEntity> funcion = repository.findById(Long.parseLong(id));
        if(funcion.isPresent()) {
            return new ResponseEntity(funcion.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object input) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
}
