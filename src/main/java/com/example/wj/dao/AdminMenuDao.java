package com.example.wj.dao;

import com.example.wj.pojo.AdminMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMenuDao {

    List<AdminMenu> findAllById(List<Integer> menuIds);
}
