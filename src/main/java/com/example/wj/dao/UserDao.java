package com.example.wj.dao;

import com.example.wj.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserDao {

    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);

    void save(User user);

    List<User> findAll();
}
