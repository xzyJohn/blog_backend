package com.blog.modules.system.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.modules.system.entity.Role;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.annotation.Resource;
import com.blog.modules.system.service.RoleService;
import org.springframework.web.bind.annotation.RestController;
import com.blog.modules.base.controller.BaseCrudController;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-12
 */
@RestController
@RequestMapping("/system/role")
public class RoleController extends BaseCrudController<Role> {

    @Resource
    private RoleService roleService;

    @Override
    @GetMapping
    public R<List<Role>> queryAll() {
        return super.queryAll();
    }

    @Override
    @GetMapping("/page")
    public R<Page<Role>> queryPage(@RequestParam(defaultValue = "0") Long current,
                                    @RequestParam(defaultValue = "10") Long size,
                                    @RequestParam(required = false) String q) {
        return super.queryPage(current, size, q);
    }

    @Override
    @GetMapping("/{id}")
    public R<Role> queryById(@PathVariable Long id) {
        return super.queryById(id);
    }

    @Override
    @PostMapping
    public R<Role> create(@RequestBody Role data) {
        roleService.createRole(data);
        return R.ok(data);
    }

    @Override
    @PutMapping
    public R<Role> update(@RequestBody Role data) {
        roleService.updateRole(data);
        return R.ok(data);
    }

    @Override
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Long id) {
        roleService.deleteRole(id);
        return R.ok(true);
    }
}
