/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.models;

import lombok.Data;

@Data
public class Empresa {
    private String rut;
    private String nombre;
    private ConfiguracionEmpresa configEmpresa;
    
    
}
