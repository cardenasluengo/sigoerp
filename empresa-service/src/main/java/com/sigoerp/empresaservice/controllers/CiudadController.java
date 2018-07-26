/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.empresaservice.controllers;

import com.sigoerp.empresaservice.entities.CiudadEntity;
import com.sigoerp.empresaservice.repositories.CiudadRepository;
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
@RequestMapping("/ciudad")
public class CiudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping()
    public Iterable<CiudadEntity> list() {
        return ciudadRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CiudadEntity> get(@PathVariable Long id) {

        Optional<CiudadEntity> ciudadO = ciudadRepository.findById(id);

        if (ciudadO.isPresent()) {
            return new ResponseEntity<>(ciudadO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<CiudadEntity> put(@PathVariable Long id, @RequestBody CiudadEntity ciudadEditar) {
        
        Optional<CiudadEntity> ciudadO = ciudadRepository.findById(id);
        if (ciudadO.isPresent()) {
            
            ciudadEditar.setId(ciudadO.get().getId());
            ciudadRepository.save(ciudadEditar);           
            return new ResponseEntity<>(ciudadEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
 
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody CiudadEntity nuevaCiudad) {
        
        nuevaCiudad = ciudadRepository.save(nuevaCiudad);

        Optional<CiudadEntity> ciudadO = ciudadRepository.findById(nuevaCiudad.getId());
        if (ciudadO.isPresent()) {
            return new ResponseEntity<>(nuevaCiudad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        
        Optional<CiudadEntity> ciudadO = ciudadRepository.findById(id);
        if (ciudadO.isPresent()) {
            ciudadRepository.deleteById(id);
            return new ResponseEntity<>(ciudadO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }

}
