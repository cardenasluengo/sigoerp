/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.models;

import java.util.Set;
import lombok.Data;
/**
 *
 * @author daniel
 */
@Data
public class MenuSeccionModel {
    
    private Long id;
    private String nombre;
    private Set<MenuFuncionModel> funciones;

    public MenuSeccionModel(Long id, String nombre, Set<MenuFuncionModel> funciones) {
        this.id = id;
        this.nombre = nombre;
        this.funciones = funciones;
    }
    
     @Override
    public int hashCode() {
        return (this.id == null) ? 0 : this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        MenuSeccionModel sec = (MenuSeccionModel) obj;
        if (this.getId().equals(sec.getId())) {
            return true;
        }

        return false;
    }
    
    
   
}


