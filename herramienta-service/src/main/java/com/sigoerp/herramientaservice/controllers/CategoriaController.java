/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.herramientaservice.controllers;

import com.sigoerp.herramientaservice.entities.CategoriaEntity;
import com.sigoerp.herramientaservice.repositories.CategoriaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daniel
 */
@CrossOrigin
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping()
    public Iterable<CategoriaEntity> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEntity> get(@PathVariable Long id) {

        Optional<CategoriaEntity> opt = repository.findById(id);

        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaEntity> put(@PathVariable Long id, @RequestBody CategoriaEntity editar) {
        
        Optional<CategoriaEntity> opt = repository.findById(id);
        
        if (opt.isPresent()) {            
            editar.setId(opt.get().getId());
            repository.save(editar);           
            return new ResponseEntity<>(editar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
 
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody CategoriaEntity nuevo) {
        
        nuevo = repository.save(nuevo);

        Optional<CategoriaEntity> opt = repository.findById(nuevo.getId());
        if (opt.isPresent()) {
            return new ResponseEntity<>(nuevo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        
        Optional<CategoriaEntity> opt = repository.findById(id);
        if (opt.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }

}
