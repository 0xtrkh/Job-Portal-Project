package com.app.jp_back_end.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id", nullable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_generator")
    @SequenceGenerator(name = "role_generator", sequenceName = "role_generator", allocationSize = 1, initialValue = 1)
    private long id;

    @Column(name = "role_name", nullable = false, updatable = false)
    private ERole roleName;

    


}
