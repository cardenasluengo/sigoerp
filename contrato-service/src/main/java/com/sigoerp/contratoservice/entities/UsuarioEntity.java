/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigoerp.contratoservice.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sigoerp.contratoservice.models.Funcionario;
import java.util.Set;
import lombok.Data;
import javax.persistence.*;

/**
 *
 * @author daniel
 */

@Data
@Entity
@Table(name = "usuario")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="id")
public class UsuarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@OneToOne a clase Funcionario por medio del FuncionarioService
    @Column(name = "funcionario", nullable = false)
    private String funcionario;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "estado", nullable = false)
    private boolean estado;

    
}
