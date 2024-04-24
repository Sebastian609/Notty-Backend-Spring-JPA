    package com.notty.Notty.persistence.entity;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import java.util.List;
    import java.time.LocalDateTime;

    @Entity
    @Table(name = "user")
    @Getter
    @Setter
    @NoArgsConstructor
    public class UserEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_user",nullable = false)
        private Integer idUser;
        @Column(length = 30,nullable = false)
        private String name;
        @Column(name="first_last_name",length = 30,nullable = false)
        private String firstLastName;
        @Column(name="second_last_name",length = 30,nullable = false)
        private String secondLastName;
        @Column(length = 320,nullable = false)
        private String mail;
        @Column(length = 16,nullable = false)
        private String password;
        @Column(length = 20,nullable = false)
        private String phone;
        @Column(nullable = false, columnDefinition = "DATETIME")
        private LocalDateTime birthday;
        @Column(name="sign_in_at", nullable = false, columnDefinition = "DATETIME")
        private LocalDateTime signInAt;
        @Column(name = "active_user",nullable = false, columnDefinition = "TINYINT")
        private Boolean activeUser;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_rol")
        private RolEntity rol;

        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
        private List<TeamMembership> teamMemberships;

        @OneToMany(mappedBy = "userOwner", fetch = FetchType.LAZY) //lista de tareas individuales

        private List<TaskEntity> personalTasks;
    }
