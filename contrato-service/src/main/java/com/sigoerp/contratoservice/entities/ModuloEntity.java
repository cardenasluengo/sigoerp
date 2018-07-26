/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.entities;

import com.sun.corba.se.spi.ior.Identifiable;
import java.util.Set;
import lombok.Data;
import javax.persistence.*;

/**
 *
 * @author daniel
 */
@Data
@Entity
@Table(name = "modulo")
public class ModuloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Override
    public int hashCode() {
        return (this.id == null) ? 0 : this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ModuloEntity mod = (ModuloEntity) obj;
        if (this.getId().equals(mod.getId())) {
            return true;
        }

        return false;
    }

}
