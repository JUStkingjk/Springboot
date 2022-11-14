package com.official.project001.service;

import com.official.project001.entity.User;
import com.official.project001.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;
    
    public List<User> getAllTheUsers(){
       return userMapper.AllUsers();
    }

    public String insertUser(User user){
        return "error";
    }



    @Override
    public Set<String> getPermissions(String username) {
        return userMapper.getPermissions(username);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getUser(username);
    }

    @Override
    public Set<String> getRole(String username) {
        return userMapper.getRoles(username);
    }


}
