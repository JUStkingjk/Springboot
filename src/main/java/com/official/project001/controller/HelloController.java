package com.official.project001.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api(value = "controller - hello")
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation(value = "打开欢迎界面")
    public String hey(){
        return "index";
    }

    @GetMapping("/register")
    @ApiOperation(value = "打开注册界面")
    public String register(){
        return "register";
    }

    @GetMapping("/my")
    @ApiOperation(value = "CSS学习")
    public String my(){
        return "my";
    }

}
