/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.insumoservice.entities;
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
@Table(name = "detalle_salida")
public class DetalleSalidaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_salida", nullable = false)
    private SalidaEntity salida;
    
    @ManyToOne
    @JoinColumn(name = "id_insumo", nullable = false)
    private InsumoEntity insumo;
    
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    
}
