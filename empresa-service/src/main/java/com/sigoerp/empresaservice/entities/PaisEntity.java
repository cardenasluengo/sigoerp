/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.empresaservice.entities;

import lombok.Data;
import javax.persistence.*;
/**
 *
 * @author daniel
 */

@Data
@Entity
@Table(name = "pais")
public class PaisEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;

    
}