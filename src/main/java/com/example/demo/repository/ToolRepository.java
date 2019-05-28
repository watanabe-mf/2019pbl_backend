package com.example.demo.repository;

import com.example.demo.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToolRepository extends JpaRepository<Tool, Long> {
    @Query(value = "SELECT * FROM tools" +
        " WHERE id NOT IN(" +
        "SELECT tool_id FROM organization_tools" +
        " WHERE organization_id = :organization_id)", nativeQuery = true)
    public List<Tool> getUnregisteredOrganizationTools(@Param("organization_id") Long organization_id);
}