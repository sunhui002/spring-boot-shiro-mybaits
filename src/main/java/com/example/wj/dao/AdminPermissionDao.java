package com.example.wj.dao;

import com.example.wj.pojo.AdminPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminPermissionDao {

    List<AdminPermission> findAllById(List<Integer> pids);

    List<AdminPermission> findAll();
}
