package com.official.project001.mapper;

import com.official.project001.entity.Login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("select username from login where username = #{username}")
    String checkUserName(String username);

    @Select("select password from login where username = #{username}")
    String checkPassword(String username);

    @Insert("insert into login(username,password) values(#{username},#{password})")
    void newUserCount(String username,String password);

    @Select("select * from login where username = #{username}")
    Login getByUsername(String username);
}
