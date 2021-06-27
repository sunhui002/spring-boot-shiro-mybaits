package com.example.wj.service;

import com.example.wj.dao.AdminRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import javax.xml.ws.Action;
import java.util.List;

@Service
public class AdminRoleService {

    @Autowired
    AdminRoleDao adminRoleDao;
    public List<Role> listWithPermsAndMenus() {
       return adminRoleDao.findAll();
    }
}
