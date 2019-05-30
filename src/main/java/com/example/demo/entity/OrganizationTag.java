package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organization_tags")
public class OrganizationTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "organization_id")
    private Long organization_id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "created_at", insertable = true, updatable = false)
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    @ManyToOne(targetEntity = Organization.class)
    @JoinColumn(name="organization_id", referencedColumnName = "id", insertable =false, updatable = false)
    private Organization organization;

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