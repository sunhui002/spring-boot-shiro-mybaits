package com.example.wj.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class Category {
    int catid;
    String name;

    public int getId() {
        return catid;
    }
    public void setId(int id) {
        this.catid = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
