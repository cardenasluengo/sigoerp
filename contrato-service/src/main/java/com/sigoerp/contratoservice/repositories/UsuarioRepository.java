/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sigoerp.contratoservice.entities.UsuarioEntity;
import java.util.Optional;

/**
 *
 * @author daniel
 */
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    
    Optional<UsuarioEntity> findByFuncionario(String rut);
    
}
