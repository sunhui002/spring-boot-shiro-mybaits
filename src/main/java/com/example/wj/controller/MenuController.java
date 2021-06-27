package com.example.wj.controller;

import com.example.wj.pojo.AdminMenu;
import com.example.wj.result.Result;
import com.example.wj.result.ResultFactory;
import com.example.wj.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    AdminMenuService adminMenuService;

    @CrossOrigin
    @GetMapping("/api/menu")
    @ResponseBody
    public Result menu(Model model) {
        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByCurrentUser());
    }
}
