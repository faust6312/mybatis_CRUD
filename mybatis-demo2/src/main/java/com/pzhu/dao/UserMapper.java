package com.pzhu.dao;

import com.pzhu.domain.User;

import java.util.List;

public interface UserMapper {
    //查询所有用户
    List<User> selectUser();
    //根据id查询
    User getUserByid(int id);
    //插入一个用户
   int addUser(User user);
   //修改用户
   int updateUser(User user);
   //删除用户
    int deleteUser(int id);
    //模糊查询
    List<User> selectUserLike(String value);
}


