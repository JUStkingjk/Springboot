package com.official.project001.controller;

import com.alibaba.fastjson.JSONArray;
import com.official.project001.entity.User;
import com.official.project001.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@Api(value = "controller - user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/userpage")
    @ApiOperation(value = "打开用户界面")
    public String userpage(){
        return "userpage";
    }

    @PostMapping("/test")
    @ApiOperation(value = "ajax测试类")
    public void test(){
        System.out.println("test ok");
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<User> getAllUsers(){
        return userService.getAllTheUsers();
    }

    @PostMapping("list")
    @ResponseBody
    public void doGet(HttpServletResponse response,HttpServletRequest request){
        try{
            List<User> UD = userService.getAllTheUsers();//数据获取
            String data = JSONArray.toJSONString(UD);//对象转换为jsonstring类型,前端一定要记得转回对象，焯
            System.out.println(data);
            response.setCharacterEncoding("utf-8");//解决json数据中文乱码
            response.setContentType("text/html;charset=utf-8");//解决Chrome控制台中文乱码
            PrintWriter responseWriter = response.getWriter();
            responseWriter.append(data);//返回到前端
            System.out.println("成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("失败");
        }
    }

    @GetMapping("premise")
    public void premise(HttpServletRequest request,HttpServletResponse response){
        System.out.println("SOS "+response);
    }


}
