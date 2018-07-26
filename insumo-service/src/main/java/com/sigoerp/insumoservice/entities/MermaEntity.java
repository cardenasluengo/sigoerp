/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.insumoservice.entities;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
/**
 *
 * @author daniel
 */
@Data
@Entity
@Table(name = "merma")
public class MermaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    
    @Column(name = "motivo", nullable = false)
    private String motivo;
    
    @Column(name = "responsable", nullable = false)
    private String responsable;
    
    @ManyToOne
    @JoinColumn(name = "id_insumo", nullable = false)
    private InsumoEntity insumo;
    
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    
    @Column(name = "anulada", nullable = false)
    private boolean anulada;
    
    @Column(name = "correccion", nullable = false)
    private boolean correccion;
    
    @Column(name = "id_bodega", nullable = false)
    private long bodega;
    
    
    
}
