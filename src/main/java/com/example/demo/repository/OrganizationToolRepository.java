package com.example.demo.repository;

import com.example.demo.entity.OrganizationTool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizationToolRepository extends JpaRepository<OrganizationTool, Long> {
    @Query(value = "SELECT * FROM organization_tools" +
            " WHERE organization_id = :organization_id", nativeQuery = true)
    public List<OrganizationTool> findByOrganizationId(@Param("organization_id") Long organization_id);
}