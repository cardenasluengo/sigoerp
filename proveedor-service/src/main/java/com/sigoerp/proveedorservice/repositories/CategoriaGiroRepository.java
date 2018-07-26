/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.proveedorservice.repositories;

import com.sigoerp.proveedorservice.entities.CategoriaGiroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author daniel
 */
public interface CategoriaGiroRepository extends JpaRepository<CategoriaGiroEntity, Long> {
    
}
