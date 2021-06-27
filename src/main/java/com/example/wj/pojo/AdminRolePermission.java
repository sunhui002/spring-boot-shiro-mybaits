package com.example.wj.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class AdminRolePermission {
    int id;
    int pid;
    int rid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
