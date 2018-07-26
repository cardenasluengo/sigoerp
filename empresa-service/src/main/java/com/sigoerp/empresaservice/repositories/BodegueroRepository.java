/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.empresaservice.repositories;

import org.springframework.data.repository.CrudRepository;
import com.sigoerp.empresaservice.entities.BodegueroEntity;

/**
 *
 * @author daniel
 */
public interface BodegueroRepository extends CrudRepository<BodegueroEntity, Long> {
    
}
