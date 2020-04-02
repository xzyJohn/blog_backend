package com.blog.modules.base.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.modules.base.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xzy
 * @Description:
 * @Date: Created in 13:50 2020/4/2
 */
public abstract class BaseCrudController<T> extends BaseController {
    @Autowired
    private MyService<T> myService;

    /**
     * 查询所有数据
     * @return list
     */
    @GetMapping("/list")
    public R<List<T>> queryAll(){
        List<T> list=myService.list();
        return R.ok(list);
    }

    /**
     * 分页条件查询，若需要条件查询，重写此方法
     * @param current 当前页
     * @param size 每一页的条数
     * @param q 条件
     * @return page
     */
    @GetMapping("/page")
    public R<Page<T>> queryPage(@RequestParam(defaultValue = "1") Long current,
                                @RequestParam(defaultValue = "10") Long size,
                                @RequestParam(required = false) String q){
        Page<T> page=new Page<>(current,size);
        if (StringUtils.isNotBlank(q)) {
            //在此做条件查询
            page = myService.page(page, Wrappers.emptyWrapper());
        } else {
            page = myService.page(page);
        }
        return R.ok(page);
    }

    /**
     * 根据id查询数据
     * @param id id
     * @return 结果
     */
    @GetMapping("/{id}")
    public R<T> queryById(@PathVariable Long id){
        T data = myService.getById(id);
        return R.ok(data);
    }

    /**
     * 新增数据
     * @param data 数据
     * @return 结果
     */
    @PostMapping
    public R<T> create(@RequestBody T data){
        boolean saved = myService.save(data);
        if(saved){
            return R.ok(data);
        }
        return R.failed("save failed");
    }

    /**
     * 根据id更新数据
     * @param data 数据
     * @return 结果
     */
    @PutMapping
    public R<T> update(@RequestBody T data){
        boolean updated = myService.updateById(data);
        if(updated){
            return R.ok(data);
        }
        return R.failed("update failed");
    }

    /**
     * 根据id删除数据
     * @param id id
     * @return 结果
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Long id){
        boolean deleted = myService.removeById(id);
        if (deleted){
            return R.ok(true);
        }
        return R.failed("deleted failed");
    }
}
