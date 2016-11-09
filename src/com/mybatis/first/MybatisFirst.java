package com.mybatis.first;

import com.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by luoyong on 16/11/9.
 * 测试mybatis
 * mybatis的入门级别程序
 */
public class MybatisFirst {

    /**
     * 定义一个会话工厂 在读取mybatis的配置文件的时候进行初始化
     */
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 读取mybatis的全局的配置文件 同过配置文件创建会话工厂
     * @throws IOException
     */
    @Before
    public void init() throws IOException {

        // 配置文件（SqlMapConfig.xml）
        String resource = "SqlMapConfig.xml";

        // 加载配置文件到输入 流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    /**
     * 测试根据id查询用户(得到单条记录)
     */
    @Test
    public void testFindUserById() {

        // 通过sqlSessionFactory创建sqlSession

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过sqlSession操作数据库
        // 第一个参数：statement的位置，等于namespace+statement的id
        // 第二个参数：传入的参数
        User user = null;
        try {
            user = sqlSession.selectOne("test.findUserById", 10);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }

        System.out.println(user);

    }

    /**
     * 根据用户的姓名进行查询 返回的是list（多条数据）
     */
    @Test
    public void testFindUserByName() {

        // 通过sqlSessionFactory创建sqlSession

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过sqlSession操作数据库
        // 第一个参数：statement的位置，等于namespace+statement的id
        // 第二个参数：传入的参数
        List<User> list = null;
        try {
            list = sqlSession.selectList("test.findUserByName", "小明");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
        System.out.println(list.get(0).getUsername());
    }



    // 测试根据id查询用户(得到单条记录)
    @Test
    public void testInsertUser() {

        // 通过sqlSessionFactory创建sqlSession

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过sqlSession操作数据库
        // 创建插入数据对象
        User user = new User();
        user.setUsername("luoyong");
        user.setAddress("河南郑州");
        user.setBirthday(new Date());
        user.setSex("1");

        try {
            sqlSession.insert("test.insertUser", user);
            // 需要提交事务
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }

        System.out.println("用户的id=" + user.getId());

    }

    // 测试根据id删除用户(得到单条记录)
    @Test
    public void testDeleteUser() {

        // 通过sqlSessionFactory创建sqlSession

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过sqlSession操作数据库
        try {
            sqlSession.delete("test.deleteUser", 30);
            // 需要提交事务
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }


    }

    // 测试根据id更新用户(得到单条记录)
    @Test
    public void testUpdateUser() {

        // 通过sqlSessionFactory创建sqlSession

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过sqlSession操作数据库
        // 创建更新数据对象，要求必须包括 id
        User user = new User();
        user.setId(29);
        user.setUsername("南风知我意");
        user.setAddress("河南郑州");
//		user.setBirthday(new Date());
        user.setSex("1");

        try {
            sqlSession.update("test.updateUser", user);
            // 需要提交事务
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }

        System.out.println("用户的id=" + user.getId());

    }

}

