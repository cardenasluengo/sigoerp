/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.repositories;

import com.sigoerp.contratoservice.entities.FuncionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author daniel
 */
public interface FuncionRepository extends JpaRepository<FuncionEntity, Long> {
    
}
