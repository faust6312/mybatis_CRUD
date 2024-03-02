package com.pzhu.dao;


import com.pzhu.domain.User;
import com.pzhu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

public class UseraDaoTest {
    @Test
  public  void selectUser(){
 SqlSession session = MybatisUtils.getSession();
 //方法一:
 //List<User> users =
        session.selectList("com.pzhu.dao.UserMapper.selectUser");
//方法二:
UserMapper mapper = session.getMapper(UserMapper.class);
List<User> users = mapper.selectUser();
for (User user: users){
System.out.println(user);
 }
 session.close();
 }
 @Test
public void getUserByid(){
     SqlSession sqlSession = MybatisUtils.getSession();
     UserMapper mapper = sqlSession.getMapper(UserMapper.class);
     User user = mapper.getUserByid(1);
     System.out.println(user);
     sqlSession.close();
}

@Test
public void addUser() {
    SqlSession sqlSession = MybatisUtils.getSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
 User user = new User(5,"chen","123","女","");
 int i = mapper.addUser(user);
System.out.println(i);
sqlSession.commit(); //提交事务,重点!不写的话不会提交到数据库
 sqlSession.close();
}
@Test
public void updateUser(){
    SqlSession sqlSession = MybatisUtils.getSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    mapper.updateUser(new User(5,"deng","123abc","女",""));
    sqlSession.commit(); //提交事务,重点!不写的话不会提交到数据库
    sqlSession.close();
}
@Test
public  void deleteUser(){
    SqlSession sqlSession = MybatisUtils.getSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    mapper.deleteUser(5);
    sqlSession.commit();
    sqlSession.close();


}
@Test
public  void selectUserLike(){
    SqlSession sqlSession = MybatisUtils.getSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    List<User> userList = mapper.selectUserLike("%li%");
    for (User user : userList) {
        System.out.println(userList);
    }
    sqlSession.close();

}

}
