package com.mybatis.dao;

import com.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by luoyong on 16/11/12.
 */
public class UserDaoImplTest {

    /**
     *创建一个会话工厂
     * @throws Exception
     */
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 初始化会话工厂
     * @throws Exception
     */
    @Before
    public void init() throws IOException{
        // 配置文件（SqlMapConfig.xml）
        String resource = "SqlMapConfig.xml";

        // 加载配置文件到输入 流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void findUserById() throws Exception {
        UserDao userDao=new UserDaoImpl(sqlSessionFactory);
        User user=userDao.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void findUserByUsername() throws Exception {

    }

    @Test
    public void insertUser() throws Exception {

    }
}