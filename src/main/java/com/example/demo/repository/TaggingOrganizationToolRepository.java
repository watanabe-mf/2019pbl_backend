package com.example.demo.repository;

import com.example.demo.entity.TaggingOrganizationTool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaggingOrganizationToolRepository extends JpaRepository<TaggingOrganizationTool, Long> {
//    @Query(value = "SELECT * FROM organization_tools" +
//            " WHERE organization_id = :organization_id", nativeQuery = true)
//    public List<OrganizationTool> findByOrganizationId(@Param("organization_id") Long organization_id);
//
    @Query(value = "SELECT * FROM tagging_organization_tool" +
            " WHERE organization_tool_id = :organization_tool_id", nativeQuery = true)
    public List<TaggingOrganizationTool> findByOrganizationToolId(@Param("organization_tool_id") Long organization_tool_id);
}