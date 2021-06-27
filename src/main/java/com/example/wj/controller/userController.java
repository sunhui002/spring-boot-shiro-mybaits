package com.example.wj.controller;

import com.example.wj.dao.UserDao;
import com.example.wj.pojo.User;
import com.example.wj.result.Result;
import com.example.wj.result.ResultFactory;
import com.example.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userController {
    @Autowired
    UserService userService;
@GetMapping("/api/admin/user")
public Result listUsers() throws Exception {
    return ResultFactory.buildSuccessResult(userService.list());
}

}
