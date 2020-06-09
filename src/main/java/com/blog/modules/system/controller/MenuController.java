package com.blog.modules.system.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.modules.system.entity.Menu;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.annotation.Resource;
import com.blog.modules.system.service.MenuService;
import org.springframework.web.bind.annotation.RestController;
import com.blog.modules.base.controller.BaseCrudController;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController extends BaseCrudController<Menu> {

    @Resource
    private MenuService menuService;

    @GetMapping("/tree")
    public R<List<Menu>> menuTree(){
        List<Menu> tree = menuService.getMenuTree();
        return R.ok(tree);
    }

    @Override
    @GetMapping
    public R<List<Menu>> queryAll() {
        return super.queryAll();
    }

    @Override
    @GetMapping("/page")
    public R<Page<Menu>> queryPage(@RequestParam(defaultValue = "0") Long current,
                                    @RequestParam(defaultValue = "10") Long size,
                                    @RequestParam(required = false) String q) {
        return super.queryPage(current, size, q);
    }

    @Override
    @GetMapping("/{id}")
    public R<Menu> queryById(@PathVariable Long id) {
        return super.queryById(id);
    }

    @Override
    @PostMapping
    public R<Menu> create(@RequestBody Menu data) {
        return super.create(data);
    }

    @Override
    @PutMapping
    public R<Menu> update(@RequestBody Menu data) {
        return super.update(data);
    }

    @Override
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}
