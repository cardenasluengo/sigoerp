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
public class MenuModuloModel {
    
    private Long id;
    private String nombre;
    private Set<MenuSeccionModel> secciones;

    public MenuModuloModel(Long id, String nombre, Set<MenuSeccionModel> secciones) {
        this.id = id;
        this.nombre = nombre;
        this.secciones = secciones;
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

        MenuModuloModel mod = (MenuModuloModel) obj;
        if (this.getId().equals(mod.getId())) {
            return true;
        }

        return false;
    }
    
    
   
}


