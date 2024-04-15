package com.notty.Notty.persistence.entity;

import jakarta.persistence.*;

@Entity
 @Table(name="rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol",nullable = false)
    private Integer idRol;
    @Column(length = 30,nullable = false )
    private String name;
    @Column(name = "active_rol",nullable = false,columnDefinition = "TINYINT")
    private boolean activeRol;


}
