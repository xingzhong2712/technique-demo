package com.example.springboot.base.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.context.ShutdownEndpoint;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 类职责：actuator安全查看<br/>
 *
 * <p>Title: ActuatorSecurityConfig.java</p>
 * <p>Description:
 * This spring security configuration does the following:<br/>
 *
 *         1. Restrict access to the Shutdown endpoint to the actuator_admin role.<br/>
 *         2. Allow access to all other actuator endpoints.<br/>
 *         3. Allow access to static resources.<br/>
 *         4. Allow access to the home page (/).<br/>
 *         5. All other requests need to be authenticated.<br/>
 *         5. Enable http basic authentication to make the configuration complete.<br/>
 *            You are free to use any other form of authentication.
 * </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月09日 下午上午 11:28
 * <p></p>
 * <p> </p>
 */
@Configuration
public class ActuatorSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(EndpointRequest.to(ShutdownEndpoint.class))
                .hasRole("actuator_admin")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .permitAll()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/**")
                .authenticated()
                .and()
                .httpBasic();
    }
}
