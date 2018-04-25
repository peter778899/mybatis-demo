package com.tx.stu.dao;

import com.tx.stu.models.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.List;

/**
 * Created by peter.
 */
public class IUserTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static InputStream inputStream;

    @BeforeClass
    public static void setUp() throws Exception {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        sqlSessionFactory = null;
        inputStream = null;
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    @Test
    public void testGetUserList() throws Exception {
        try(SqlSession session = sqlSessionFactory.openSession();) {
            IUser iuser = session.getMapper(IUser.class);
            // 显示User信息
            System.out.println("Test Get start...");
            printUsers(iuser.getUserList());
            System.out.println("Test Get finished...");
        }
    }

    @Test
    public void testInsertUser() {
        try(SqlSession session = sqlSessionFactory.openSession();) {
            IUser iuser = session.getMapper(IUser.class);
            System.out.println("Test insert start...");
            // 执行插入
            User user = new User();
            user.setId(0);
            user.setName("Google");
            user.setDept("Tech");
            user.setWebsite("http://www.google.com");
            user.setPhone("120");
            iuser.insertUser(user);
            // 提交事务
            session.commit();

            // 显示插入之后User信息
            System.out.println("After insert");
            printUsers(iuser.getUserList());
            System.out.println("Test insert finished...");
        }
    }

    @Test
    public void testUpdate() {
        try(SqlSession session = sqlSessionFactory.openSession();) {
            IUser iuser = session.getMapper(IUser.class);
            System.out.println("Test update start...");
            printUsers(iuser.getUserList());
            // 执行更新
            User user = iuser.getUser(1);
            user.setName("New name");
            iuser.updateUser(user);
            // 提交事务
            session.commit();
            // 显示更新之后User信息
            System.out.println("After update");
            printUsers(iuser.getUserList());
            System.out.println("Test update finished...");
        }
    }

    @Test
    public void testDelete()
    {
        try(SqlSession session = sqlSessionFactory.openSession();) {
            IUser iuser = session.getMapper(IUser.class);
            System.out.println("Test delete start...");
            // 显示删除之前User信息
            System.out.println("Before delete");
            printUsers(iuser.getUserList());
            // 执行删除
            iuser.deleteUser(2);
            // 提交事务
            session.commit();
            // 显示删除之后User信息
            System.out.println("After delete");
            printUsers(iuser.getUserList());
            System.out.println("Test delete finished...");
        }
    }

    private void printUsers(List<User> users) {
        int count = 0;

        for (User user : users) {
            System.out.println(MessageFormat.format(
                    "============= User[{0}]=================", ++count));
            System.out.println("User Id: " + user.getId());
            System.out.println("User Name: " + user.getName());
            System.out.println("User Dept: " + user.getDept());
            System.out.println("User Website: " + user.getWebsite());
        }
    }

}