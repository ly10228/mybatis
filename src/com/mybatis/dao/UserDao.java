package com.mybatis.dao;

import com.mybatis.po.User;

import java.util.List;

/**
 * Created by luoyong on 16/11/12.
 */
public interface UserDao {
    /**
     * 根据id查询用户的信息
     */
    public User findUserById(int id) throws  Exception;

    /**
     * 根据用户名称模糊查询用户列表
     */
    public List<User> findUserByUsername(String username) throws Exception;

    /**
     * 插入用户
     * @param user
     * @throws Exception
     */
    public void insertUser(User user) throws Exception;
}
