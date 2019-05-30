package com.example.demo.controller;

import com.example.demo.entity.OrganizationTag;
import com.example.demo.service.OrganizationTagService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/organization/{organization_id}/tags")
public class OrganizationTagsController {
    @NonNull
    private final OrganizationTagService organizationTagService;

    // 組織タグ作成
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationTag insertTag(@Validated @RequestBody OrganizationTag organizationTag) {
        return organizationTagService.save(organizationTag);
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

    // 組織ツール名検索
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<OrganizationTag> getOrganizationTagByName(@PathVariable("organization_id") Long organization_id, @RequestParam("name") String name) {
        System.out.println("name:" + name);
        return organizationTagService.findByName(organization_id, name);
    }

    // 組織タグ削除
//    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteById(@PathVariable("id") Long id) {
//        toolService.deleteById(id);
//    }
}