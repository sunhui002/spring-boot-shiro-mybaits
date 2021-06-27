package com.example.wj.service;

import com.example.wj.dao.CategoryDao;
import com.example.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> list() {

        return categoryDao.findAll();
    }

    public Category get(int id) {

        Category c=id>=1&&id<=5?categoryDao.findById(id):null;
        return c;
    }
}
