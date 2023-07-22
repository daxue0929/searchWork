package com.daxue.pojo;

/**
 * @author daxue0929
 * @date 2023/7/23
 */


public class User {

    public Integer id;
    public String username;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }
}
