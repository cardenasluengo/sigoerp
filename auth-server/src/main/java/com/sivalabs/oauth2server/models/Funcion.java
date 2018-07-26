/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sivalabs.oauth2server.models;
import java.io.Serializable;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
/**
 *
 * @author daniel
 */

@Data
public class Funcion implements GrantedAuthority{
    
    private Long id;
    private String nombre;

    @Override
    public String getAuthority() {
        return this.nombre;
    }
    
}
