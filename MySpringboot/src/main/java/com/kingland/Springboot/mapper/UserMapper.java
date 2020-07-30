/*

 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.

 */

package com.kingland.Springboot.mapper;

import com.kingland.Springboot.bean.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @describe: the mapper of mybatis
 * @author KSC
 */
@Mapper
@Repository
public interface UserMapper {

    /**

     * select user info by user name

     *

     * @param username user name

     * @return user object

     */
    @Select("select * from user_info where username = #{username};")
    Userinfo queryUserByName(String username);



    /**

     * add user

     *

     * @param user user

     * @return number of affected rows

     */

    int addUser(Userinfo user);





}
