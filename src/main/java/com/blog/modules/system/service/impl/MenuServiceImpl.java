package com.blog.modules.system.service.impl;

import com.blog.core.utils.Constants;
import com.blog.modules.system.entity.Menu;
import com.blog.modules.system.mapper.MenuMapper;
import com.blog.modules.system.service.MenuService;
import com.blog.modules.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Description:
 * @author zeyi
 * @since 2020-06-09
 */
@Service
@Transactional
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

    @Override
    public List<Menu> getMenuTree() {
        List<Menu> menuList = this.lambdaQuery().eq(Menu::getStatus, Constants.MenuStatus.AVAILABLE).orderByAsc(Menu::getSeqNum).list();
        List<Menu> parentMenu = new ArrayList<>(16);
        menuList.forEach(menu->{
            if(Constants.MenuType.PARENT.equals(menu.getStatus())){
                parentMenu.add(menu);
            }
        });

        return null;
    }
}
