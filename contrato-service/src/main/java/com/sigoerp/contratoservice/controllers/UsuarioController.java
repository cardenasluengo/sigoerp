/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.controllers;

import com.sigoerp.contratoservice.entities.ModuloEntity;
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
import com.sigoerp.contratoservice.entities.UsuarioEntity;
import com.sigoerp.contratoservice.models.UsuarioCorto;
import com.sigoerp.contratoservice.models.UsuarioLargo;
import com.sigoerp.contratoservice.service.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/usuario")
@Slf4j
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;
    
    
    @GetMapping()
    public List<UsuarioCorto> list() {
        return service.findAll();
    }
    
    @PreAuthorize("hasRole('prestamos')")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioLargo> get(@PathVariable String id) {
        
        Optional<UsuarioLargo> usuario = service.findById(Long.parseLong(id));
        if(usuario.isPresent()) {
            return new ResponseEntity(usuario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @PreAuthorize("hasRole('otro')")
    @GetMapping("/byrut/{rut}")
    public ResponseEntity<UsuarioCorto> getUserByRut(@PathVariable String rut) {
        Optional<UsuarioLargo> usuario = service.findUserByRut(rut);
        if(usuario.isPresent()) {
            return new ResponseEntity(usuario.get(), HttpStatus.OK);
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
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
