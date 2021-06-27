package com.example.wj.dao;

import com.example.wj.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryDao {

    List<Category> findAll();

    Category findById(int id);
}
