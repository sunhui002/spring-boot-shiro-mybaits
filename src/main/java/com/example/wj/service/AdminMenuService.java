package com.example.wj.service;

import com.example.wj.dao.AdminMenuDao;
import com.example.wj.pojo.AdminMenu;
import com.example.wj.pojo.AdminRoleMenu;
import com.example.wj.pojo.AdminUserRole;
import com.example.wj.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdminMenuService {
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminMenuService adminMenuService;
    @Autowired
    AdminRoleMenuService adminRoleMenuService;
    @Autowired
    AdminMenuDao adminMenuDao;
    @Autowired
    AdminRoleMenu adminRoleMenu;


    public List<AdminMenu> getMenusByCurrentUser() {
        // 从数据库中获取当前用户
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getByName(username);

        // 获得当前用户对应的所有角色的 id 列表
        List<Integer> rids = new ArrayList<>(adminUserRoleService.listAllByUid(user.getId()));

        // 查询出这些角色对应的所有菜单项
        List<Integer> menuIds = new ArrayList<>(adminRoleMenuService.findAllByRid(rids));
        List<AdminMenu> menus = adminMenuDao.findAllById(menuIds).stream().distinct().collect(Collectors.toList());

        // 处理菜单项的结构
        handleMenus(menus);
        return menus;
    }

    private void handleMenus(List<AdminMenu> menus) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(AdminMenu menu : menus){
            map.put(menu.getId(),new ArrayList<>());
        }
        for (AdminMenu menu : menus) {

             int   l=menu.getParentId();
             if(l!=0&&map.containsKey(l)) {
                 map.get(l).add(menu.getId());
             }

        }
        for (AdminMenu menu : menus) {
            if(map.get(menu.getId()).size()!=0) {
                List<AdminMenu> children = adminMenuDao.findAllById(map.get(menu.getId()));
                menu.setChildren(children);
            }
        }
        Iterator<AdminMenu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            AdminMenu menu = iterator.next();
            if (menu.getParentId() != 0) {
                iterator.remove();
            }
        }
    }
}
