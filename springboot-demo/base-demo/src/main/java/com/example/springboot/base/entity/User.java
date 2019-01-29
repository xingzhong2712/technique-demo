package com.example.springboot.base.entity;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 类职责：<br/>
 *
 * <p>Title: User.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月07日 下午上午 11:12
 * <p></p>
 * <p> </p>
 */
@Data
public class User {

    @NotBlank
    private String id;

    @Email
    private String email;
}
