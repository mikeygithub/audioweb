package com.config;

import com.audioweb.interceptor.ShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ProjectName audioweb
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 12/29/19 7:45 PM
 * @Version 1.0
 * @Description:配置类
 **/
@Configuration
public class ShiroConfig {
    /**
     * security管理器
     * @return
     */
    @Bean("securityManager")
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(new ShiroRealm());
        return defaultWebSecurityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/");
        shiroFilterFactoryBean.setSuccessUrl("/main/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/login_toLogin");


        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/static/login/**", "anon");
        filterMap.put("/static/js/myjs/**", "authc");
        filterMap.put("/static/js/**", "anon");
        filterMap.put("/uploadFiles/uploadImgs/**", "anon");
        filterMap.put("/code.do", "anon");
        filterMap.put("/front_index ", "anon");
        filterMap.put("/login_login", "anon");
        filterMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }
}
