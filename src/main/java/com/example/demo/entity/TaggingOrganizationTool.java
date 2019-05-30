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
@Table(name = "tagging_organization_tool")
public class TaggingOrganizationTool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "organization_tool_id")
    private Long organization_tool_id;

    @NotNull
    @Column(name = "organization_tag_id")
    private Long organization_tag_id;

    @Column(name = "created_at", insertable = true, updatable = false)
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    @ManyToOne(targetEntity = OrganizationTool.class)
    @JoinColumn(name="organization_tool_id", referencedColumnName = "id", insertable =false, updatable = false)
    private OrganizationTool organizationTool;

    @ManyToOne(targetEntity = OrganizationTag.class)
    @JoinColumn(name="organization_tag_id", referencedColumnName = "id", insertable =false, updatable = false)
    private OrganizationTag organizationTag;

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