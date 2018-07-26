package com.devglan.model;

import javax.persistence.*;
import lombok.Data;


@Entity
@Table(name="funcion")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nombre")
    private String name;

}
