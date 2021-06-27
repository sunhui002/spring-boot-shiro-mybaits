package com.example.wj.controller;

import com.example.wj.result.Result;
import com.example.wj.result.ResultFactory;
import com.example.wj.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    AdminRoleService adminRoleService;
    @GetMapping("/api/admin/role")
    public Result listRoles() {

        return ResultFactory.buildSuccessResult(adminRoleService.listWithPermsAndMenus());
    }

}
