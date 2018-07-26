/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.herramientaservice.entities;

import java.sql.Time;
import java.util.Date;
import lombok.Data;
import javax.persistence.*;
/**
 *
 * @author daniel
 */

@Data
@Entity
@Table(name = "prestamo")
public class PrestamoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    
    @Column(name = "hora", nullable = false)
    private Time hora;
    
    @Column(name = "solicitante", nullable = false)
    private String solicitante;
    
    @Column(name = "prestador", nullable = false)
    private String prestador;
    
    @Column(name = "devolucion", nullable = false)
    private boolean devolucion;
    
    @Column(name = "fecha_devolucion", nullable = false)
    private Date fechaDevolucion;
    
    @Column(name = "id_bodega", nullable = false)
    private Long bodega;
    
    
}
