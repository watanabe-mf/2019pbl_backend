package com.example.demo.service;

import com.example.demo.entity.Organization;
import com.example.demo.repository.OrganizationRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// ツール操作のロジック
@Service
@Transactional
@RequiredArgsConstructor
public class OrganizationService {
    @NonNull
    private final OrganizationRepository organizationRepository;

    // ツール全件検索
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    // ツール検索
    public Optional<Organization> findById(Long id) {
        return organizationRepository.findById(id);
    }

    // ツール名検索
    public Optional<Organization> findByName(String name) {
        return organizationRepository.findByName(name);
    }

    // ツール作成、更新
    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    // ツール削除
    public void deleteById(Long id) {
        organizationRepository.deleteById(id);
    }
}