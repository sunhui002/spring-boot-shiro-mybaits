package com.example.wj.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class AdminRoleMenu {
    int id;
    int mid;
    int rid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
