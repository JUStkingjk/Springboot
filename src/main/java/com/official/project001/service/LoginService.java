package com.official.project001.service;


import com.official.project001.entity.Login;

public interface LoginService {
    boolean checkUserName(String username);

    boolean checkPassword(String username,String password);

    boolean setNewUserCount(String username,String password);

    Login getByUsername(String username);
}
