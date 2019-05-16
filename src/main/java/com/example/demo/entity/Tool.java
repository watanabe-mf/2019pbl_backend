package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tools")
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 1)
    @Column(name = "name")
    private String name;

    @Column(name = "detail")
    private String detail;

    @Column(name = "created_at", insertable = true, updatable = false)
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    @PrePersist
    public void onPrePersist() {
        setCreated_at(new Date());
        setUpdated_at(new Date());
    }

    @PreUpdate
    public void onPreUpdate() {
        setUpdated_at(new Date());
    }
}