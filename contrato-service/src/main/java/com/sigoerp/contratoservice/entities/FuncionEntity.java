/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Set;
import lombok.Data;
import javax.persistence.*;
/**
 *
 * @author daniel
 */

@Data
@Entity
@Table(name = "funcion")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="id")
public class FuncionEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "acceso", nullable = false)
    private String acceso;
    
    @Column(name = "mantencion", nullable = false)
    private boolean mantencion;
    
    @Column(name = "tabla_main", nullable = false)
    private String tablaMain;
       
    @ManyToOne
    @JoinColumn(name = "seccion", nullable = false)
    private SeccionEntity seccion;
    
    @Override
    public int hashCode() {
        return (this.id == null) ? 0 : this.id.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        FuncionEntity fun = (FuncionEntity) obj;
        if (this.getId().equals(fun.getId())) {
            return true;
        }

        return false;
    }
    
}
