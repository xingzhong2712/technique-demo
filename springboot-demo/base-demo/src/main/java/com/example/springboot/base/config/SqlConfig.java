package com.example.springboot.base.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 类职责：@ConditionalOnBean(DataSource.class) DataSource bean存在时创建一个Bean<br/>
 *
 * <p>Title: SqlConfig.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月07日 下午下午 1:25
 * <p></p>
 * <p> </p>
 */

@Configuration
@ConditionalOnBean(DataSource.class)
public class SqlConfig {

}
