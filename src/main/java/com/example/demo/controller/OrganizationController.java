package com.example.demo.controller;

import com.example.demo.entity.Organization;
import com.example.demo.service.OrganizationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/organizations")
public class OrganizationController {
    @NonNull
    private final OrganizationService organizationService;

    // 組織作成
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Organization insertOrganization(@Validated @RequestBody Organization organization) {
        return organizationService.save(organization);
    }

    // 組織更新
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Organization updateOrganization(@PathVariable("id") Long id, @Validated @RequestBody Organization organization) {
        organization.setId(id);
        return this.organizationService.save(organization);
    }

    // 組織全件取得
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Organization> getOrganizations() {
        return organizationService.findAll();
    }

    // 組織1件取得
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Organization getOrganization(@PathVariable("id") Long id) {
        return organizationService.findById(id).orElseThrow(RuntimeException::new);
    }

    // 組織名検索
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Organization getOrganizationByName(@RequestParam("name") String name) {
        return organizationService.findByName(name).orElseThrow(RuntimeException::new);
    }

    // 組織削除
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        organizationService.deleteById(id);
    }
}