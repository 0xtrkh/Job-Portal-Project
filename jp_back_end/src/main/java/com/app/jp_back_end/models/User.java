package com.app.jp_back_end.models;


import jakarta.persistence.*;
import jdk.jfr.Timestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", nullable = false, unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator",sequenceName = "user_generator", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(name = "first_name", nullable = false,length = 50, updatable = true, insertable = true)
    private String firstName;

    @Column(name = "last_name", nullable = false,length = 50, updatable = true, insertable = true)

    private String lastName;

    @Column(name = "email", nullable = false,length = 50, updatable = true, insertable = true, unique = true)
    private String email;
    @Column(name = "password", nullable = false,length = 255, updatable = true, insertable = true, unique = false)
    private String password;


    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false, updatable = false, insertable = true, unique = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "role_id"))
    private Role role;

    @Timestamp
    @Column(name = "created_at", updatable = true, insertable = false, nullable = false)
    private LocalDateTime created;

    @Timestamp
    @Column(name = "update_at", updatable = true, insertable = false, nullable = false)
    private LocalDateTime modified;

    @Column(name = "is_deleted", updatable = true)
    private boolean deleted;



    @PrePersist
    public void prepersist() {
        if (created == null) {
            created = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preupdate() {
        modified = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
