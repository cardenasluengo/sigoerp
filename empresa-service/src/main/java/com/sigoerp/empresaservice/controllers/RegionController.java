/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.empresaservice.controllers;

import com.sigoerp.empresaservice.entities.RegionEntity;
import com.sigoerp.empresaservice.repositories.RegionRepository;
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
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping()
    public Iterable<RegionEntity> list() {
        return regionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionEntity> get(@PathVariable Long id) {

        Optional<RegionEntity> regionO = regionRepository.findById(id);

        if (regionO.isPresent()) {
            return new ResponseEntity<>(regionO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionEntity> put(@PathVariable Long id, @RequestBody RegionEntity regionEditar) {
        
        Optional<RegionEntity> regionO = regionRepository.findById(id);
        if (regionO.isPresent()) {
            
            regionEditar.setId(regionO.get().getId());
            regionRepository.save(regionEditar);           
            return new ResponseEntity<>(regionEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
 
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody RegionEntity nuevaRegion) {
        
        nuevaRegion = regionRepository.save(nuevaRegion);

        Optional<RegionEntity> regionO = regionRepository.findById(nuevaRegion.getId());
        if (regionO.isPresent()) {
            return new ResponseEntity<>(nuevaRegion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        
        Optional<RegionEntity> regionO = regionRepository.findById(id);
        if (regionO.isPresent()) {
            regionRepository.deleteById(id);
            return new ResponseEntity<>(regionO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }

}
