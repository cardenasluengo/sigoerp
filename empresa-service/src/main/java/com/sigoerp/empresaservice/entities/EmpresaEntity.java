/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.empresaservice.entities;
import java.util.Set;
import lombok.Data;
import javax.persistence.*;
/**
 *
 * @author daniel
 */

@Data
@Entity
@Table(name = "empresa")
public class EmpresaEntity {
    
    @Id
    @Column(unique = true, nullable = false)
    private String rut;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "direccion", nullable = false)
    private String direccion;
    
    @ManyToOne
    @JoinColumn(name = "id_ciudad", nullable = false)
    private CiudadEntity ciudad;
    
    @Column(name = "fono", nullable = false)
    private String fono;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "contacto", nullable = false)
    private String contacto;
    
    @OneToOne
    @JoinColumn(name = "config_empresa", nullable = false)
    private ConfiguracionEmpresaEntity configEmpresa;
    
    
       
    
}
