package com.example.demo.service;

import com.example.demo.entity.OrganizationTag;
import com.example.demo.repository.OrganizationTagRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// 組織ツール操作のロジック
@Service
@Transactional
@RequiredArgsConstructor
public class OrganizationTagService {
    @NonNull
    private final OrganizationTagRepository organizationTagRepository;

    // 組織ツール全件検索
//    public List<OrganizationTag> findByOrganizationId(Long organization_id) {
//        return organizationTagRepository.findByOrganizationId(organization_id);
//    }
//
//    // 組織ツール検索
//    public Optional<OrganizationTool> findById(Long id) {
//        return organizationToolRepository.findById(id);
//    }
//
    // 組織タグ名検索
    public List<OrganizationTag> findByName(Long organization_id, String name) {
        return organizationTagRepository.findByName(organization_id, name);
    }

    // 組織タグ作成、更新
    public OrganizationTag save(OrganizationTag organizationTag) {
        return organizationTagRepository.save(organizationTag);
    }

    // 組織ツール削除
//    public void deleteById(Long id) {
//        organizationToolRepository.deleteById(id);
//    }
}