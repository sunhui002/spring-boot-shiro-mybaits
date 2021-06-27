package com.example.wj.service;

import com.example.wj.dao.AdminPermissionDao;
import com.example.wj.dao.AdminRolePermissionDao;
import com.example.wj.pojo.AdminPermission;
import com.example.wj.pojo.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminPermissionService {
@Autowired
AdminUserRoleService adminUserRoleService;
@Autowired
AdminRolePermissionDao adminRolePermissionDao;
@Autowired
    AdminPermissionDao adminPermissionDao;

    public Set<String> listPermissionURLsByUser(String username) {
        List<Integer> rids = new ArrayList<>(adminUserRoleService.listRolesByUser(username));

        List<Integer> pids = new ArrayList<>(adminRolePermissionDao.findAllByRid(rids));

        List<AdminPermission> perms = adminPermissionDao.findAllById(pids);

        Set<String> URLs = perms.stream().map(AdminPermission::getUrl).collect(Collectors.toSet());

        return URLs;
    }
    public boolean needFilter(String requestAPI) {
        List<AdminPermission> ps = adminPermissionDao.findAll();
        for (AdminPermission p: ps) {
            if (p.getUrl().equals(requestAPI)) {
                return true;
            }
        }
        return false;
    }

}
