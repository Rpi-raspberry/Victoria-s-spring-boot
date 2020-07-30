/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */

package com.kingland.gradlespring.mapper;


import com.kingland.gradlespring.bean.Userinfo;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @describe: the mapper of mybatis
 * @author KSC
 */
@RequestMapping
public interface UserMapper {

    /**
     * select user info by user name
     *
     * @param username user name
     * @return user object
     */

    Userinfo queryUserByName(String username);



    /**
     * add user
     *
     * @param user user
     * @return number of affected rows
     */

    int addUser(Userinfo user);





}