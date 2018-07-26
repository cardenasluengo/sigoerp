package com.devglan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name="funcionario")
    private String username;
    
    @Column(name="password")
    @JsonIgnore
    private String password;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "detalle_funcion",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_funcion"))
    private Set<Role> roles;
    
}
