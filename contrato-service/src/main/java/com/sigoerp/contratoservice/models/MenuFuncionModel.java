/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.models;

import lombok.Data;
/**
 *
 * @author daniel
 */
@Data
public class MenuFuncionModel {
    
    private Long id;
    private String nombre;
    private String acceso;
    private boolean mantencion;

    public MenuFuncionModel(Long id, String nombre, String acceso, boolean mantencion) {
        this.id = id;
        this.nombre = nombre;
        this.acceso = acceso;
        this.mantencion = mantencion;
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

        MenuFuncionModel fun = (MenuFuncionModel) obj;
        if (this.getId().equals(fun.getId())) {
            return true;
        }

        return false;
    }
    
   
}


