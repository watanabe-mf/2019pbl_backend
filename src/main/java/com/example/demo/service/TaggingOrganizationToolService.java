package com.example.demo.service;

import com.example.demo.entity.TaggingOrganizationTool;
import com.example.demo.repository.TaggingOrganizationToolRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

// 組織ツール操作のロジック
@Service
@Transactional
@RequiredArgsConstructor
public class TaggingOrganizationToolService {
    @NonNull
    private final TaggingOrganizationToolRepository taggingOrganizationToolRepository;

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
    // ツールに紐付く組織タグ取得
    public List<TaggingOrganizationTool> findByOrganizationToolId(Long organization_tool_id) {
        return taggingOrganizationToolRepository.findByOrganizationToolId(organization_tool_id);
    }

    // 組織タグ作成、更新
    public TaggingOrganizationTool save(TaggingOrganizationTool taggingOrganizationTool) {
        return taggingOrganizationToolRepository.save(taggingOrganizationTool);
    }

    // 組織ツール削除
//    public void deleteById(Long id) {
//        organizationToolRepository.deleteById(id);
//    }
}