package com.official.project001.service;

import com.official.project001.entity.Login;
import com.official.project001.mapper.LoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService{

    @Resource
    private LoginMapper loginMapper;

    @Override
    public boolean checkUserName(String username){
        if(loginMapper.checkUserName(username) != null)
            return true;
        else
            return false;
    }

    @Override
    public boolean checkPassword(String username,String password){
        if(loginMapper.checkPassword(username).equals(password)){
            return true;
        }else
            return false;
    }

    @Override
    public boolean setNewUserCount(String username, String password) {
        if(loginMapper.checkUserName(username) == null){
            loginMapper.newUserCount(username, password);
            return true;
        }else{
            System.out.println("用户名已存在,请更换");
            return false;
        }

    }

    @Override
    public Login getByUsername(String username) {
        return loginMapper.getByUsername(username);
    }
}
