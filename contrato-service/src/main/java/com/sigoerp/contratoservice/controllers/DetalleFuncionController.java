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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.sigoerp.contratoservice.entities.DetalleFuncionesEntity;
import com.sigoerp.contratoservice.entities.UsuarioEntity;
import com.sigoerp.contratoservice.repositories.DetalleFuncionRepository;
import com.sigoerp.contratoservice.repositories.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/detallefunciones")
public class DetalleFuncionController {
    
    @Autowired
    private DetalleFuncionRepository detalleRepository;
    private UsuarioRepository usuarioReporitory;
    
    
    @GetMapping()
    public List<DetalleFuncionesEntity> list() {
        return detalleRepository.findAll();
    }
    
    @GetMapping("/byusuario/{id}")
    public List<DetalleFuncionesEntity> listByUsuario(String id) {
        
        Optional<UsuarioEntity> usuario = usuarioReporitory.findById(Long.parseLong(id));
        if(usuario.isPresent()) {
            return detalleRepository.findAllByUsuario(usuario.get());
            
        } else {
            return null;
        }
     
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<DetalleFuncionesEntity> get(@PathVariable String id) {
        Optional<DetalleFuncionesEntity> detalle = detalleRepository.findById(Long.parseLong(id));
        if(detalle.isPresent()) {
            return new ResponseEntity(detalle.get(), HttpStatus.OK);
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
