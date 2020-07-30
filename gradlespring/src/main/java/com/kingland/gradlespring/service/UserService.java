
package com.kingland.gradlespring.service;
import com.kingland.gradlespring.bean.Userinfo;
import com.kingland.gradlespring.mapper.UserMapper;
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

public class UserService implements UserDetailsService {
    /**string constant，space
     */

    public static final String SPACE = " ";
    /** user Mapper
     */

    final UserMapper userMapper;

    public static String getSPACE() {
        return SPACE;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

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