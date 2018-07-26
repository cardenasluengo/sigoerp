/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.insumoservice.entities;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
/**
 *
 * @author daniel
 */
@Data
@Entity
@Table(name = "salida")
public class SalidaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    
    @Column(name = "hora", nullable = false)
    private Time hora;
    
    @Column(name = "solicitante", nullable = false)
    private String solicitante;
    
    @Column(name = "responsable", nullable = false)
    private String responsable;
    
    @Column(name = "id_bodega", nullable = false)
    private Long bodega;
    
    @Column(name = "suprimida", nullable = false)
    private boolean suprimida;
    
    
    
    
}
