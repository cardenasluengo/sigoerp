/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.entities;

import java.util.Set;
import lombok.Data;
import javax.persistence.*;
/**
 *
 * @author daniel
 */

@Data
@Entity
@Table(name = "seccion")
public class SeccionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "modulo", nullable = false)
    private ModuloEntity modulo;
    
    @Override
    public int hashCode() {
        return (this.id == null) ? 0 : this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        SeccionEntity sec = (SeccionEntity) obj;
        if (this.getId().equals(sec.getId())) {
            return true;
        }

        return false;
    }
   
    
    
}
