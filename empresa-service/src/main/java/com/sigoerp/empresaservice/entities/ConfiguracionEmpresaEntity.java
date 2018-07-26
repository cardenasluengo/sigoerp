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
@Table(name = "config_empresa")
public class ConfiguracionEmpresaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "color_p", nullable = false)
    private String colorP;
    
    @Column(name = "color_s", nullable = false)
    private String colorS;
    
    @Column(name = "logo", nullable = false)
    private String logo;
    
    @Column(name = "imagen", nullable = false)
    private String imagen;

    
}
