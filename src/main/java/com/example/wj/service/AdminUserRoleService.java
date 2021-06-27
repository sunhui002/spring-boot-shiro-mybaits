package com.example.wj.service;

import com.example.wj.dao.AdminUserRoleDao;
import com.example.wj.dao.UserDao;
import com.example.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AdminUserRoleService {

 @Autowired
    AdminUserRoleDao adminUserRoleDao;
 @Autowired
    UserDao userDao;
    public List<Integer> listAllByUid(int id) {
        return adminUserRoleDao.listAllByUid(id);
    }

    public List<Integer> listRolesByUser(String username) {
        User user=userDao.findByUsername(username);
        return adminUserRoleDao.listAllByUid(user.getId());
    }
}
