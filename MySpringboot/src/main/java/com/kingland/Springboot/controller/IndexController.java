

/*

 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.

 */

package com.kingland.Springboot.controller;
import com.kingland.Springboot.bean.Userinfo;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
/**

 * @author KSC

 */

public interface IndexController {


    public ResponseEntity register(Userinfo userInfo, HttpServletRequest request);

}