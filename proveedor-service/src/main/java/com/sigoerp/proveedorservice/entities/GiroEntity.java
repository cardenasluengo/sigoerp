/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.proveedorservice.entities;

import lombok.Data;
import javax.persistence.*;

/**
 *
 * @author daniel
 */
@Data
@Entity
@Table(name = "giro")
public class GiroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "id_categoria", nullable = false)
    private CategoriaGiroEntity categoria;


}
