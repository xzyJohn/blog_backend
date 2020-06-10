package com.blog.modules.system.service.impl;

import com.blog.core.utils.Constants;
import com.blog.modules.system.entity.Menu;
import com.blog.modules.system.mapper.MenuMapper;
import com.blog.modules.system.service.MenuService;
import com.blog.modules.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-09
 */
@Service
@Transactional
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuTree() {
        List<Menu> menuList = this.lambdaQuery().eq(Menu::getStatus, Constants.MenuStatus.AVAILABLE).orderByAsc(Menu::getSeqNum).list();
        List<Menu> parentMenu = new ArrayList<>(16);
        //将父菜单按照顺序放入list
        menuList.forEach(menu->{
            if(Constants.MenuType.PARENT.equals(menu.getType())){
                parentMenu.add(menu);
            }
        });
        //将子菜单根据父节点分组
        Map<Long,List<Menu>> childrenMap = new HashMap<>(16);
        menuList.forEach(menu -> {
            if(Constants.MenuType.CHILDREN.equals(menu.getType())){
                if(childrenMap.containsKey(menu.getParentId())){
                    childrenMap.get(menu.getParentId()).add(menu);
                }else {
                    List<Menu> menus = new ArrayList<>(16);
                    menus.add(menu);
                    childrenMap.put(menu.getParentId(),menus);
                }
            }
        });
        //将子菜单放入父菜单
        parentMenu.forEach(menu -> {
            if(childrenMap.containsKey(menu.getId())){
                menu.setChildren(childrenMap.get(menu.getId()));
            }
        });
        return parentMenu;
    }

    @Override
    public Integer getMenuSeqNum(Long parentId,Integer type) {
        Integer seqNum = menuMapper.getMenuSeqNum(parentId,type);
        if (seqNum == null){
            seqNum = 0;
        }
        return  seqNum + 1;
    }

    @Override
    public Boolean deleteById(Long id) {
        Menu menu = this.getById(id);
        if(Constants.MenuType.PARENT.equals(menu.getType())){
            menuMapper.deleteByParentId(menu.getId());
        }
        return this.deleteById(menu.getId());
    }
}
