package com.official.project001.mapper;

import com.official.project001.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> AllUsers();

    @Insert("insert into user(name,power,occupation) values (#{name},#{power},#{occupation})")
    Integer insertUser(User user);

    @Select("select rolename from t_role where id = (select role_id from t_user where username = #{username})")
    Set<String> getRoles(String username);

    @Select("select * from user where name = #{username}")
    User getUser(String username);

    @Select("select permissionname from t_permission where role_id = (select role_id from t_user where username = #{username})")
    Set<String> getPermissions(String username);
}
