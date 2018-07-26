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
@Table(name = "proveedor")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "representante", nullable = false)
    private String representante;
    
    @Column(name = "direccion", nullable = false)
    private String direccion;
    
    @Column(name = "id_ciudad", nullable = false)
    private String ciudad;
    
    @Column(name = "fono1", nullable = false)
    private String fono1;
    
    @Column(name = "fono2", nullable = false)
    private String fono2;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "empresa_cliente", nullable = false)
    private String empresaCliente;
    
    @Column(name = "rol", nullable = false)
    private String rol;


}
