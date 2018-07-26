/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.empresaservice.repositories;

import com.sigoerp.empresaservice.entities.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author daniel
 */
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, String> {
    
}
