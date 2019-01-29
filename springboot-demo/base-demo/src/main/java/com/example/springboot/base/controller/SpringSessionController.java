package com.example.springboot.base.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 类职责：<br/>
 *
 * <p>Title: SpringSessionController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月08日 下午上午 10:28
 * <p></p>
 * <p> </p>
 */
@Slf4j
@Controller
@RequestMapping("/session")
public class SpringSessionController {

    @RequestMapping("/put.html")
    public @ResponseBody
    String putSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("session class is {}", session.getClass().toGenericString());
        log.info("session id is {}", session.getId());

        String name = "seeeeeen";
        session.setAttribute("seeen", name);
        return "hey, " + name;
    }

}
