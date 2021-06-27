package com.example.wj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminRolePermissionDao {

    List<Integer> findAllByRid(List<Integer> rids);
}
