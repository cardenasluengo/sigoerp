/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.proveedorservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sigoerp.proveedorservice.entities.DetalleGiroEntity;

/**
 *
 * @author daniel
 */
public interface DetalleGiroRepository extends JpaRepository<DetalleGiroEntity, Long> {
    
}
