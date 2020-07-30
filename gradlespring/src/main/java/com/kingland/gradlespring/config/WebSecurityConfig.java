/*

 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.

 */
package com.kingland.gradlespring.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** @describe: page security configuration
 * @version 1.3
 * @author KSC
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private  UserDetailsService userService;

    /**
     * Injection by constructor
     *
     * @param userService
     */
    public WebSecurityConfig(UserDetailsService userService) {
        this.userService = userService;
    }

    /**
     * Override configuration
     * Filter static resources
     *
     * @param webSecurity
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        // Allows access to all files in/CSS directory
        webSecurity.ignoring()
                .antMatchers("/favicon.ico", "/resources/**", "/error")
                .antMatchers("/css/**")
                .antMatchers("/public/**");
    }

    /**
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                // Some resources of the website need to be authorized
                .antMatchers("/register.html").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/*.html").permitAll()
                .antMatchers("/").permitAll()
                // All requests except the above require authentication
                .anyRequest().authenticated().and()
                // define the loginPage to go to when a user needs to login ("/login")
                .formLogin().loginPage("/login.html").defaultSuccessUrl("/index.html").permitAll().and()
                // Define the logout operation
                .logout().logoutSuccessUrl("/welcome").permitAll().and()
                .csrf().disable()
        ;

        httpSecurity.headers().cacheControl();
    }



    /**
     *
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * Use the database user information service password authentication
         * using BCrypt encryption
         */
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
