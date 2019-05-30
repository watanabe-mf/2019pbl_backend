package com.example.demo.controller;

import com.example.demo.entity.TaggingOrganizationTool;
import com.example.demo.service.TaggingOrganizationToolService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/tagging/organization/{organization_id}/tools")
public class TaggingOrganizationToolController {
    @NonNull
    private final TaggingOrganizationToolService taggingOrganizationToolService;

    // 組織ツールにタグ付け
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TaggingOrganizationTool taggingOrganizationTool(@Validated @RequestBody TaggingOrganizationTool taggingOrganizationTool) {
        return taggingOrganizationToolService.save(taggingOrganizationTool);
    }

    // 組織タグ更新
//    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Tool updateTool(@PathVariable("id") Long id, @Validated @RequestBody Tool tool) {
//        tool.setId(id);
//        return this.toolService.save(tool);
//    }

    // 組織タグ全件取得
//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public List<Tool> getTools() {
//        return toolService.findAll();
//    }

    // 組織タグ1件取得
//    @RequestMapping(method = RequestMethod.GET, value = "{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Tool getTool(@PathVariable("id") Long id) {
//        return toolService.findById(id).orElseThrow(RuntimeException::new);
//    }

    // ツールに紐付く組織タグ取得
    @GetMapping("{organization_tool_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<TaggingOrganizationTool> getOrganizationToolTagById(@PathVariable("organization_tool_id") Long organization_tool_id) {
        System.out.println("organization_tool_id:" + organization_tool_id);
        return taggingOrganizationToolService.findByOrganizationToolId(organization_tool_id);
    }

    // 組織タグ削除
//    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteById(@PathVariable("id") Long id) {
//        toolService.deleteById(id);
//    }
}