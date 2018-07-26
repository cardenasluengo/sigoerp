/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.models;
import com.sigoerp.contratoservice.entities.DetalleFuncionesEntity;
import com.sigoerp.contratoservice.entities.FuncionEntity;

import java.util.Set;
import lombok.Data;
/**
 *
 * @author daniel
 */
@Data
public class MenuModel {
    
    private Long id;
    private Funcionario funcionario;
    private boolean estado;
    private Set<MenuModuloModel> modulos; 

   
}


