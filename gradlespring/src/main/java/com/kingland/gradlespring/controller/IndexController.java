

/*

 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.

 */

package com.kingland.gradlespring.controller;
import com.kingland.gradlespring.bean.Userinfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
/**

 * @author KSC

 */

public interface IndexController {

@RequestMapping
    public ResponseEntity register(Userinfo userInfo, HttpServletRequest request);

}