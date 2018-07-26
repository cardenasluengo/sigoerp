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
@Table(name = "funcionario")
public class FuncionarioEntity {
    
    @Id
    @Column(unique = true, nullable = false)
    private String rut;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "apellido_p", nullable = false)
    private String apellidoP;
    
    @Column(name = "apellido_m", nullable = false)
    private String apellidoM;
    
    @Column(name = "direccion", nullable = false)
    private String direccion;
    
    @ManyToOne
    @JoinColumn(name = "id_ciudad", nullable = false)
    private CiudadEntity ciudad;
    
    @Column(name = "fono1", nullable = false)
    private String fono1;
    
    @Column(name = "fono2", nullable = false)
    private String fono2;
    
    @Column(name = "email", nullable = false)
    private String email;
         
    @ManyToOne
    @JoinColumn(name = "empresa", nullable = false)
    private EmpresaEntity empresa;
    
}
