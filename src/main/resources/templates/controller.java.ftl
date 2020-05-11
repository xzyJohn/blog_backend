package ${package.Controller};

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.modules.${package.ModuleName}.entity.${entity};
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.annotation.Resource;
import com.blog.modules.${package.ModuleName}.service.${entity}Service;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 *
 * @Description:
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass}<${entity}> {
<#else>
public class ${table.controllerName} {
</#if>

    @Resource
    private ${entity}Service ${table.entityPath}Service;

    @Override
    @GetMapping
    public R<List<${entity}>> queryAll() {
        return super.queryAll();
    }

    @Override
    @GetMapping("/page")
    public R<Page<${entity}>> queryPage(@RequestParam(defaultValue = "0") Long current,
                                    @RequestParam(defaultValue = "10") Long size,
                                    @RequestParam(required = false) String q) {
        return super.queryPage(current, size, q);
    }

    @Override
    @GetMapping("/{id}")
    public R<${entity}> queryById(@PathVariable Long id) {
        return super.queryById(id);
    }

    @Override
    @PostMapping
    public R<${entity}> create(@RequestBody ${entity} data) {
        return super.create(data);
    }

    @Override
    @PutMapping
    public R<${entity}> update(@RequestBody ${entity} data) {
        return super.update(data);
    }

    @Override
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}
</#if>
