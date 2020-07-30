/*

 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.

 */
package com.kingland.gradlespring.bean;




/**
 * @describe WebMvcConfig  :web security configuration
 * @author KSC
 */

public class Userinfo {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    private String password;

}
