/*

 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.

 */
package com.kingland.Springboot.bean;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @describe WebMvcConfig  :web security configuration
 * @author KSC
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userinfo {

    private int id;
  @NotNull
    private String username;
  @NotNull
    private String password;

}

