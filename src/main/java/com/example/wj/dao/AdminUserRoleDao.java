package com.example.wj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminUserRoleDao {

    List<Integer> listAllByUid(@Param("uid") int uid);


}
