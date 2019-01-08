package com.example.springboot.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 类职责：<br/>
 *
 * <p>Title: TestController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月07日 下午上午 10:55
 * <p></p>
 * <p> </p>
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        System.out.println(request.getParameterMap());

        return "test";
    }

    @RequestMapping("/sth/{id}")
    public @ResponseBody
    String getSth(@PathVariable Long id) {

        return id.toString();
    }
}
