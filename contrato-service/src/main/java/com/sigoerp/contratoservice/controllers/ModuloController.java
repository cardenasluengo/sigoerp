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
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.sigoerp.contratoservice.repositories.ModuloRepository;
import com.sigoerp.contratoservice.entities.ModuloEntity;

import com.sigoerp.contratoservice.models.MenuModel;
import com.sigoerp.contratoservice.service.MenuService;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author daniel
 */
@CrossOrigin
@RestController
@RequestMapping("/modulo")
@Slf4j
public class ModuloController {
    
    @Autowired
    private ModuloRepository repository;
    
    @Autowired
    private MenuService menuService;
    
    @GetMapping()
    public List<ModuloEntity> list() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ModuloController> get(@PathVariable String id) {      
        Optional<ModuloEntity> modulo = repository.findById(Long.parseLong(id));
        if(modulo.isPresent()) {
            return new ResponseEntity(modulo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/getmenu/{rut}")
    public ResponseEntity<MenuModel> getMenu(@PathVariable String rut) {
        
        Optional<MenuModel> menu = menuService.findByRut(rut);
        if(menu.isPresent()) {
            return new ResponseEntity(menu.get(), HttpStatus.OK);
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
    public Object handleError(HttpServletRequest req, Exception ex) {
        Object errorObject = new Object();
        return errorObject;
    }
    
}
