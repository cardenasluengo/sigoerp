/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sivalabs.oauth2server.models;
import java.io.Serializable;
import java.util.Set;
import lombok.Data;
/**
 *
 * @author daniel
 */
@Data
public class Usuario implements Serializable {
    
    private Long id;
    private String rut;
    private String password;
    private boolean estado;
    private Set<Funcion> funciones;
    
}
