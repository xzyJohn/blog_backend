package com.blog.modules.system.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.modules.system.entity.Permission;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.annotation.Resource;
import com.blog.modules.system.service.PermissionService;
import org.springframework.web.bind.annotation.RestController;
import com.blog.modules.base.controller.BaseCrudController;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-12
 */
@RestController
@RequestMapping("/system/permission")
public class PermissionController extends BaseCrudController<Permission> {

    @Resource
    private PermissionService permissionService;

    @Override
    @GetMapping
    public R<List<Permission>> queryAll() {
        return super.queryAll();
    }

    @Override
    @GetMapping("/page")
    public R<Page<Permission>> queryPage(@RequestParam(defaultValue = "0") Long current,
                                    @RequestParam(defaultValue = "10") Long size,
                                    @RequestParam(required = false) String q) {
        return super.queryPage(current, size, q);
    }

    @Override
    @GetMapping("/{id}")
    public R<Permission> queryById(@PathVariable Long id) {
        return super.queryById(id);
    }

    @Override
    @PostMapping
    public R<Permission> create(@RequestBody Permission data) {
        return super.create(data);
    }

    @Override
    @PutMapping
    public R<Permission> update(@RequestBody Permission data) {
        return super.update(data);
    }

    @Override
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}
