
package com.kingland.Springboot.service;
import com.kingland.Springboot.bean.Userinfo;
import com.kingland.Springboot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**@author KSC
 *
 * @describe: This class is for logic code of the project
 * The function used to pass the Mapper
 */
@Service
@Slf4j
public class UserService implements UserDetailsService {
    /**string constant，space
     */
    public static final String SPACE = " ";
    /** user Mapper
     */

    final UserMapper userMapper;

    /**@param userMapper user Mapper

     */

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }



    /**@override loadUserByUsername method
     *@param username user name
     * @return user info
     * @throws UsernameNotFoundException user name not found exception
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // log
        log.info("****** service, username : " + username);
        if (username == null || "".equals(username)) {
            throw new UsernameNotFoundException("Please enter user name!");
        }
        // list is used to save permissions
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        // insert user info by username
        Userinfo userInfo = userMapper.queryUserByName(username);
        if (null == userInfo) {
            throw new UsernameNotFoundException("User name does not exist!");
        }
        // add permission

        return new org.springframework.security.core.userdetails.User(userInfo.getUsername(), userInfo.getPassword(), list);
    }
}