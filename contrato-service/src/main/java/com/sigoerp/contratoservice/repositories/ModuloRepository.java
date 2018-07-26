/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.repositories;

import com.sigoerp.contratoservice.entities.ModuloEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author daniel
 */
public interface ModuloRepository extends JpaRepository<ModuloEntity, Long> {

    @Query(
            value = "SELECT"
            + "  m.nombre AS modulo, s.nombre AS seccion, "
            + "  f.nombre AS funcion "
            + "FROM "
            + "  modulo AS m "
            + "  INNER JOIN seccion AS s "
            + "    ON m.id = s.modulo "
            + "  INNER JOIN funcion AS f "
            + "    ON s.id = f.seccion "
            + "  INNER JOIN detalle_funcion As df "
            + "  ON f.id = df.id_funcion AND df.id_usuario = 1",
            nativeQuery = true)
    List<?> menu();
    
    //@Param("rut") String rut
    

}
