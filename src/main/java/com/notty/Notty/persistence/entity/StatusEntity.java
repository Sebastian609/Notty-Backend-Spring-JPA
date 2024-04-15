package com.notty.Notty.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="status")
@Getter
@Setter
@NoArgsConstructor
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_status",nullable = false)
    private Integer idStatus;
    @Column(name = "active_status",nullable = false,columnDefinition = "TINYINT")
    private boolean activeRol;
}
