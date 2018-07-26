/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.herramientaservice.entities;
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
@Table(name = "detalle_prestamo")
public class DetallePrestamoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_herramienta", nullable = false)
    private HerramientaEntity herramienta;
    
    @ManyToOne
    @JoinColumn(name = "id_prestamo", nullable = false)
    private PrestamoEntity prestamo;
    
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    
}
