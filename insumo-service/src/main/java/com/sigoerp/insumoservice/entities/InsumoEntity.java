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
@Table(name = "insumo")
public class InsumoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "modelo", nullable = false)
    private String modelo;
    
    @Column(name = "stock_minimo", nullable = false)
    private int stockMinimo;
    
    @ManyToOne
    @JoinColumn(name = "id_unidad_medida", nullable = false)
    private UnidadMedidaEntity unidadMedida;
    
    @ManyToOne
    @JoinColumn(name = "id_subcategoria", nullable = false)
    private SubCategoriaEntity subcategoria;
    
    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private MarcaEntity marca;
    
    
}
