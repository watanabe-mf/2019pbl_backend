package com.example.demo.controller;

import com.example.demo.entity.OrganizationTool;
import com.example.demo.service.OrganizationToolService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/organization/{organization_id}/tools")
public class OrganizationToolController {
    @NonNull
    private final OrganizationToolService organizationToolService;

    // 組織ツール作成
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationTool insertOrganizationTool(@Validated @RequestBody OrganizationTool organizationTool) {
        System.out.println(organizationTool);
        return organizationToolService.save(organizationTool);
    }

    // 組織ツール更新
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganizationTool updateOrganizationTool(@PathVariable("id") Long id, @Validated @RequestBody OrganizationTool organizationTool) {
        organizationTool.setId(id);
        return this.organizationToolService.save(organizationTool);
    }

    // 組織ツール全件取得
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<OrganizationTool> getOrganizationTools(@PathVariable("organization_id") Long organization_id) {
        return organizationToolService.findByOrganizationId(organization_id);
    }

    // 組織ツール1件取得
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganizationTool getOrganizationTool(@PathVariable("id") Long id) {
        return organizationToolService.findById(id).orElseThrow(RuntimeException::new);
    }

    // 組織ツール名検索
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<OrganizationTool> getOrganizationToolByName(@PathVariable("organization_id") Long organization_id, @RequestParam("name") String name) {
        System.out.println("name:" + name);
        return organizationToolService.findByName(organization_id, name);
    }

    // 組織ツール削除
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        organizationToolService.deleteById(id);
    }
}