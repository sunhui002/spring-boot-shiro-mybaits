package com.example.wj.service;

import com.example.wj.dao.AdminRoleMenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleMenuService {
    @Autowired
    AdminRoleMenuDao adminRoleMenuDao;
    public  List<Integer> findAllByRid(List<Integer> rids){
        return adminRoleMenuDao.findmidByrid(rids);
    }
}
