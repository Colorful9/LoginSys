package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    public UserMapper userDAO;



    public Result login(User user) {
        if(user==null){
            return new Result("用户错误！",false);
        }
        User u = userDAO.getUserByUserName(user.getUserName());

        if(u == null){
            return new Result("用户不存在！",false);
        }

        if(u.getPassWord().equals(user.getPassWord())){

            return new Result("登录成功！",true);
        }


        return new Result("密码错误！",false);
    }


    public Result register(User user) {


        if(user==null){
            return new Result("用户错误！",false);
        }

        User u = userDAO.getUserByUserName(user.getUserName());

        if(u != null){
            return new Result("用户已存在！",false);
        }

        if(user.getPassWord()==null||user.getPassWord().length()<=5){
            return new Result("密码过短！",false);
        }

        //TODO 重复密码错误

        int x = userDAO.addUser(user);

        if(x<=0) return new Result("服务器错误",false);



        return new Result("注册成功233",true);
    }


    public boolean addUser(User user) {

        return userDAO.addUser(user)>0;

    }


    public boolean updateUser(User user) {

        return userDAO.updateUser(user)>0;

    }



    public boolean deleteUser(String name) {

        return userDAO.deleteUser(name)>0;

    }


    public User getUserByUserName(String name) {

        return userDAO.getUserByUserName(name);

    }


}
