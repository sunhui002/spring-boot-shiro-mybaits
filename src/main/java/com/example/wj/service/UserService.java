package com.example.wj.service;

import com.example.wj.dao.UserDao;
import com.example.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userdao;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) {
        return userdao.findByUsername(username);
    }

    public User get(String username, String password){
        return userdao.getByUsernameAndPassword(username, password);
    }

    public void add(User user) {
        userdao.save(user);
    }

    public List<User> list() {
        return userdao.findAll();
    }
}
