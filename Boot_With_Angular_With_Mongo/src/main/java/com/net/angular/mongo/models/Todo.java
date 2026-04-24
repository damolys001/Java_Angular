package com.net.angular.mongo.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
public class Todo {

    @Id
    @Column(nullable = false, updatable = false)
    private String id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @Column(nullable = false)
    private Boolean completed = Boolean.FALSE;

    @Column(nullable = false, updatable = false)
    private Date createdAt;

    public Todo() {
        super();
    }

    public Todo(String title) {
        this.title = title;
    }

    @PrePersist
    public void prePersist() {
        if (id == null || id.trim().isEmpty()) {
            id = UUID.randomUUID().toString();
        }
        if (createdAt == null) {
            createdAt = new Date();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return String.format("Todo[id=%s, title='%s', completed='%s']", id, title, completed);
    }
}
