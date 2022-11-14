package com.official.project001.service;

import com.official.project001.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<User> getAllTheUsers();
    String insertUser(User user);



    Set<String> getPermissions(String username);

    User getByUsername(String username);

    Set<String> getRole(String username);
}
