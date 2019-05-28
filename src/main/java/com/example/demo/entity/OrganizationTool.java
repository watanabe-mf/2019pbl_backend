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
@Table(name = "organization_tools")
public class OrganizationTool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "organization_id")
    private Long organization_id;

    @NotNull
    @Column(name = "tool_id")
    private Long tool_id;

    @Column(name = "additional_information")
    private String additional_information;

    @NotNull
    @Column(name = "is_approved")
    private String is_approved;

    @NotNull
    @Column(name = "last_updated_user_id")
    private String last_updated_user_id;

    @Column(name = "created_at", insertable = true, updatable = false)
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    @ManyToOne(targetEntity = Tool.class)
    @JoinColumn(name="tool_id", referencedColumnName = "id", insertable =false, updatable = false)
    private Tool tool;

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