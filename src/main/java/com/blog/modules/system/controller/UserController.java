package com.blog.modules.system.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.modules.base.controller.BaseCrudController;
import com.blog.modules.system.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xzy
 * @Description:
 * @Date: Created in 9:55 2020/4/17
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseCrudController<User> {
    @Override
    @GetMapping
    public R<List<User>> queryAll() {
        return super.queryAll();
    }

    @Override
    @GetMapping("/page")
    public R<Page<User>> queryPage(@RequestParam(defaultValue = "0") Long current,
                                   @RequestParam(defaultValue = "10") Long size,
                                   @RequestParam(required = false) String q) {
        return super.queryPage(current, size, q);
    }

    @Override
    @GetMapping("/{id}")
    public R<User> queryById(@PathVariable Long id) {
        return super.queryById(id);
    }

    @Override
    @PostMapping
    public R<User> create(@RequestBody User data) {
        return super.create(data);
    }

    @Override
    @PutMapping
    public R<User> update(@RequestBody User data) {
        return super.update(data);
    }

    @Override
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}
