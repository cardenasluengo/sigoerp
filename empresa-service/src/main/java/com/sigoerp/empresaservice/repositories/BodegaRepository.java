/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.empresaservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sigoerp.empresaservice.entities.BodegaEntity;

/**
 *
 * @author daniel
 */
public interface BodegaRepository extends JpaRepository<BodegaEntity, Long> {
    
}
