package com.notty.Notty.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="rol")
@Getter
@Setter
@NoArgsConstructor
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol",nullable = false)
    private Integer idRol;
    @Column(length = 30,nullable = false )
    private String name;
    @Column(name = "active_rol",nullable = false, columnDefinition = "TINYINT")
    private boolean activeRol;
    @Column(name = "granted_date",nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime grantedDate;

    @ManyToOne
    @JoinColumn(name = "idUser",referencedColumnName = "id_user",nullable = false,updatable = true)
    @JsonBackReference
    private UserEntity user;


}
