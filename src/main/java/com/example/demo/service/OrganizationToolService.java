package com.example.demo.service;

import com.example.demo.entity.OrganizationTool;
import com.example.demo.entity.Tool;
import com.example.demo.repository.OrganizationToolRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// ツール操作のロジック
@Service
@Transactional
@RequiredArgsConstructor
public class OrganizationToolService {
    @NonNull
    private final OrganizationToolRepository organizationToolRepository;

    // 組織ツール全件検索
    public List<OrganizationTool> findByOrganizationId(Long organization_id) {
        return organizationToolRepository.findByOrganizationId(organization_id);
    }

    // 組織ツール検索
    public Optional<OrganizationTool> findById(Long id) {
        return organizationToolRepository.findById(id);
    }

    // 組織ツール名検索
//    public Optional<OrganizationTool> findByName(String name) {
//        return organizationToolRepository.findByName(name);
//    }

    // 組織ツール作成、更新
    public OrganizationTool save(OrganizationTool organizationTool) {
        return organizationToolRepository.save(organizationTool);
    }

    // 組織ツール削除
    public void deleteById(Long id) {
        organizationToolRepository.deleteById(id);
    }
}