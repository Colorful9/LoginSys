package com.example.demo;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {


    @Select("SELECT * FROM user WHERE username = #{name}")
    User getUserByUserName(String name);

    @Insert("INSERT INTO user(username,password) VALUES(#{userName},#{passWord})")
    Integer addUser(User user);

    @Update("UPDATE  user SET password = #{passWord},username = #{userName} where id = #{id}")
    Integer updateUser(User user);

    @Delete("DELETE FROM user where username = #{name}")
    Integer deleteUser(String name);

}
