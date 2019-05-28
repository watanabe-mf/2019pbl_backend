package com.example.demo.controller;

import com.example.demo.entity.Tool;
import com.example.demo.service.ToolService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/tools")
public class ToolController {
    @NonNull
    private final ToolService toolService;

    // ツール作成
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Tool insertTool(@Validated @RequestBody Tool tool) {
        return toolService.save(tool);
    }

    // ツール更新
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tool updateTool(@PathVariable("id") Long id, @Validated @RequestBody Tool tool) {
        tool.setId(id);
        return this.toolService.save(tool);
    }

    // ツール全件取得
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Tool> getTools() {
        return toolService.findAll();
    }

    // ツール1件取得
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tool getTool(@PathVariable("id") Long id) {
        return toolService.findById(id).orElseThrow(RuntimeException::new);
    }

    // ツール削除
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        toolService.deleteById(id);
    }

    // 組織ツール未登録全件取得
    @GetMapping("unregistered/{organization_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tool> getUnregisteredOrganizationTools(@PathVariable("organization_id") Long organization_id) {
        return toolService.getUnregisteredOrganizationTools(organization_id);
    }
}