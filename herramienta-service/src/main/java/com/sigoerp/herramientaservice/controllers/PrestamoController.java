/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.herramientaservice.controllers;

import com.sigoerp.herramientaservice.entities.PrestamoEntity;
import com.sigoerp.herramientaservice.repositories.PrestamoRepository;
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
@RequestMapping("/prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoRepository repository;

    @GetMapping()
    public Iterable<PrestamoEntity> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoEntity> get(@PathVariable Long id) {

        Optional<PrestamoEntity> opt = repository.findById(id);

        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestamoEntity> put(@PathVariable Long id, @RequestBody PrestamoEntity editar) {
        
        Optional<PrestamoEntity> opt = repository.findById(id);
        
        if (opt.isPresent()) {            
            editar.setId(opt.get().getId());
            repository.save(editar);           
            return new ResponseEntity<>(editar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
 
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody PrestamoEntity nuevo) {
        
        nuevo = repository.save(nuevo);

        Optional<PrestamoEntity> opt = repository.findById(nuevo.getId());
        if (opt.isPresent()) {
            return new ResponseEntity<>(nuevo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        
        Optional<PrestamoEntity> opt = repository.findById(id);
        if (opt.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }

}
