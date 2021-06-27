package com.example.wj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Mapper
@Repository
public interface AdminRoleDao {
    List<Role> findAll();
}
