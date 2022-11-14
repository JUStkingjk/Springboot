package com.official.project001.controller;

import com.official.project001.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/listener")
public class TestController {

    @GetMapping("/user")
    public User getUser(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        return (User) application.getAttribute("user");
    }

    @GetMapping("/total")
    public String getTotalUser(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie;
        try{
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(),"UTF-8"));
            cookie.setPath("/");
            cookie.setMaxAge(48*60*60);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线" + count;
    }
}
