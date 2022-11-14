package com.official.project001.controller;

import com.official.project001.entity.Login;
import com.official.project001.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
//@RestController
@Api(value = "controller - login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/x1")
    @ResponseBody
    public Login addEntity(){
        return new Login();
    }

    @GetMapping("/login")
    @ApiOperation("打开登录界面")
    public String toLogin(){
        return "login";
    }

    @GetMapping("/logintest/{username}/{password}")
    @ResponseBody
    @ApiOperation("登录验证")
    public String loginCheck(@Param("username") String username, @Param("password") String password){
        //检查数据库中有没有对应用户名
        if(loginService.checkUserName(username)){
            if(loginService.checkPassword(username,password)){
                return "欢迎";
            }else {
                return "密码错误";
            }
        }else {
            return "用户名不存在";
        }
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    public String login(String Ucount,
                        String Upassword){
        System.out.println(Ucount);
        System.out.println(loginCheck(Ucount, Upassword));
        if(loginCheck(Ucount, Upassword).equals("密码错误") || loginCheck(Ucount, Upassword).equals("用户名不存在"))
            return "error";
        else if(loginCheck(Ucount, Upassword).equals("欢迎"))
            return "userpage";
        else
            return "login";
    }

    @PostMapping("/register")
    @ApiOperation("注册信息提交")
    public String register(String newUserName,String newPassword){
        System.out.println(newUserName);
        System.out.println(newPassword);
        if(loginService.setNewUserCount(newUserName, newPassword)){
            System.out.println("注册成功");
            return "index";
        }else
            System.out.println("注册失败");
        return "index";
    }
}
