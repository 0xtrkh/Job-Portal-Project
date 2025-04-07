package com.app.jp_back_end.models;


import com.app.jp_back_end.models.types.Status;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "applications")
public class Application {

    @Id
    @Column(name = "application_id", nullable = false, unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_generator")
    @SequenceGenerator(name = "application_generator", sequenceName = "application_generator", allocationSize = 1, initialValue = 1)
    private long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "", orphanRemoval = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Job job;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "", orphanRemoval = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Company company;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "")
    @JoinTable(name = "application_seeker",
            joinColumns = {@JoinColumn(name = "application_id")},
            inverseJoinColumns = {@JoinColumn(name= "user_id")}
    )
    private Set<User> seeker = new HashSet<>();

    @Column(name = "status", nullable = false, updatable = true, insertable = true, unique = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "resume_link", nullable = false, updatable = true, insertable = true, unique = true)
    private String resumeLink;
    @Timestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name = "updated_at", nullable = true, updatable = true)
    private LocalDateTime updated;

    @Column(name = "applied_at", nullable = true, updatable = false)
    private LocalDateTime appliedAt;

    @Column(name = "deleted", nullable = false, updatable = true)
    private boolean deleted = false;

    @PrePersist
    private void onCreate() {
        if (created == null) {
            created = LocalDateTime.now();
        }
    }

    @PreUpdate
    private void onUpdate() {
        updated = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<User> getSeeker() {
        return seeker;
    }

    public void setSeeker(Set<User> seeker) {
        this.seeker = seeker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", job=" + job +
                ", company=" + company +
                ", seeker=" + seeker +
                ", status=" + status +
                ", resumeLink='" + resumeLink + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", appliedAt=" + appliedAt +
                ", deleted=" + deleted +
                '}';
    }
}
