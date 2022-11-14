package com.official.project001.config;

import com.official.project001.shiro.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    //自定义realm
    @Bean
    public MyRealm myAuthRealm(){
        MyRealm myRealm = new MyRealm();
        logger.info("===myRealm注册完成===");
        return myRealm;
    }

    //配置安全管理器
    @Bean
    public SecurityManager securityManager(){
        return new DefaultWebSecurityManager(myAuthRealm());
    }

    //配置过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/userpage");
        shiroFilterFactoryBean.setUnauthorizedUrl("/hello");
        Map<String, String> filterChainMap = new LinkedHashMap<>();
        filterChainMap.put("/CSS/**","anon");
        filterChainMap.put("/img/**","anon");
        filterChainMap.put("/js/**","anon");
        filterChainMap.put("/swagger-*/**","anon");
        filterChainMap.put("/swagger-ui,html/**","anon");
        filterChainMap.put("/login","anon");
        filterChainMap.put("/hello","anon");
        filterChainMap.put("/userpage","roles[admin]");

        filterChainMap.put("/logout","logout");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        logger.info("===shiroFilterFactoryBean注册完成===");
        return shiroFilterFactoryBean;
    }
}
