package com.example.demo.service;

import com.example.demo.entity.Tool;
import com.example.demo.repository.ToolRepository;

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
public class ToolService {
    @NonNull
    private final ToolRepository toolRepository;

    // ツール全件検索
    public List<Tool> findAll() {
        return toolRepository.findAll();
    }

    // ツール検索
    public Optional<Tool> findById(Long id) {
        return toolRepository.findById(id);
    }

    // ツール作成、更新
    public Tool save(Tool tool) {
        return toolRepository.save(tool);
    }

    // ツール削除
    public void deleteById(Long id) {
        toolRepository.deleteById(id);
    }
}