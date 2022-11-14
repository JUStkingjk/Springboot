package com.official.project001.listener;

import com.official.project001.entity.User;
import com.official.project001.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        UserService userService = applicationContext.getBean(UserService.class);
        User user = userService.getByUsername("jason");
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("user",user);
    }
}
