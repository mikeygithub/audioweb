package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ProjectName audioweb
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 12/30/19 10:09 AM
 * @Version 1.0
 * @Description:
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.jsp");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //静态资源放行
        registry.addResourceHandler("/static/**","/plugins/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/plugins/");

    }
}
