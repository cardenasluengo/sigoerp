/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sigoerp.contratoservice.entities.DetalleFuncionesEntity;
import com.sigoerp.contratoservice.entities.UsuarioEntity;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface DetalleFuncionRepository extends JpaRepository<DetalleFuncionesEntity, Long> {
    
     List<DetalleFuncionesEntity> findAllByUsuario(UsuarioEntity usuario);
    
}
