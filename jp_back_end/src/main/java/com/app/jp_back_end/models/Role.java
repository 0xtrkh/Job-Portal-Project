package com.app.jp_back_end.models;

import com.app.jp_back_end.models.types.ERole;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;

import java.time.LocalDateTime;
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
    @Enumerated(value = EnumType.STRING)
    private ERole roleName;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "role")
    private Set<User> users;

    @Timestamp
    @Column(name = "created_at", updatable = true, insertable = false, nullable = false)
    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        if (created == null) {
            created = LocalDateTime.now();
        }
    }

    public long getId() {
        return id;
    }

    public ERole getRoleName() {
        return roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRoleName(ERole roleName) {
        this.roleName = roleName;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName=" + roleName +
                ", users=" + users +
                ", created=" + created +
                '}';
    }
}
