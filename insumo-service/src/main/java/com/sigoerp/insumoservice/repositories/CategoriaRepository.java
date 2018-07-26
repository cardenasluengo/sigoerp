/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.insumoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sigoerp.insumoservice.entities.CategoriaEntity;

/**
 *
 * @author daniel
 */
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    
}
