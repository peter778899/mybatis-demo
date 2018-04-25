package com.tx.stu;

import com.tx.stu.dao.IUser;
import com.tx.stu.models.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sessionFactory.getConfiguration().addMapper(IUser.class);

        try(SqlSession  session = sessionFactory.openSession();){
            IUser iUser = session.getMapper(IUser.class);
            User user = iUser.getUserByID(1);
            if(user!=null){
                String userInfo = "名字："+user.getName()+", 所属部门："+user.getDept()+", 主页："+user.getWebsite();
                System.out.println(userInfo);
            }
        }
    }
}
