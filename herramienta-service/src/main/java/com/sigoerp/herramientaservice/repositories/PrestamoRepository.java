/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.herramientaservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sigoerp.herramientaservice.entities.PrestamoEntity;

/**
 *
 * @author daniel
 */
public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Long> {
    
}
