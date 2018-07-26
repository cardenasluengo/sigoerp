/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.empresaservice.controllers;

import com.sigoerp.empresaservice.entities.PaisEntity;
import com.sigoerp.empresaservice.repositories.PaisRepository;
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
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @GetMapping()
    public Iterable<PaisEntity> list() {
        return paisRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaisEntity> get(@PathVariable Long id) {

        Optional<PaisEntity> paisO = paisRepository.findById(id);

        if (paisO.isPresent()) {
            return new ResponseEntity<>(paisO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<PaisEntity> put(@PathVariable Long id, @RequestBody PaisEntity paisEditar) {
        
        Optional<PaisEntity> paisO = paisRepository.findById(id);
        if (paisO.isPresent()) {
            
            paisEditar.setId(paisO.get().getId());
            paisRepository.save(paisEditar);           
            return new ResponseEntity<>(paisEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
 
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody PaisEntity nuevoPais) {
        
        nuevoPais = paisRepository.save(nuevoPais);

        Optional<PaisEntity> paisO = paisRepository.findById(nuevoPais.getId());
        if (paisO.isPresent()) {
            return new ResponseEntity<>(nuevoPais, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        
        Optional<PaisEntity> paisO = paisRepository.findById(id);
        if (paisO.isPresent()) {
            paisRepository.deleteById(id);
            return new ResponseEntity<>(paisO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }

}
