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
@Table(name = "detalle_giro")
public class DetalleGiroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_proveedor", nullable = false)
    private ProveedorEntity proveedor;
    
    @Column(name = "id_giro", nullable = false)
    private GiroEntity firo;


}
