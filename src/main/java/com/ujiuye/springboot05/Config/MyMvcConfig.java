package com.ujiuye.springboot05.Config;

import com.ujiuye.springboot05.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.HashMap;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
     @Bean
     public  WebMvcConfigurer  WebMvcConfigurer(){
          WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
              @Override
                   //实现视图解析器的方法
              public void addViewControllers(ViewControllerRegistry registry) {
                     //访问当前页面 / 去  index 页面
                      registry.addViewController("/").setViewName("login");
                      registry.addViewController("/index.html").setViewName("login");
                      registry.addViewController("/main.html").setViewName("dashboard");
              }
              public void addInterceptors(InterceptorRegistry registry) {
                  //super.addInterceptors(registry);
                  //静态资源；  *.css , *.js
                  //SpringBoot已经做好了静态资源映射
               registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                       .excludePathPatterns("/index.html","/","/user/login");
              }

          };
         return  webMvcConfigurer;

     }





}
