/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sigoerp.contratoservice.entities.SeccionEntity;

/**
 *
 * @author daniel
 */
public interface SeccionRepository extends JpaRepository<SeccionEntity, Long> {
    
}
