package com.tx.stu;

import com.tx.stu.models.Post;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Created by peter.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"));

//        //一对多查询测试
//        try(SqlSession session = sqlSessionFactory.openSession()) {
//            User user = session.selectOne("com.tx.stu.userMapper.getUser", 1);
//            System.out.println("username: "+user.getUsername()+",");
//
//            List<Post> posts = user.getPosts();
//            for(Post p : posts) {
//                System.out.println("Title:" + p.getTitle());
//                System.out.println("Content:" + p.getContent());
//            }
//        }

        //多对一查询测试
        try(SqlSession session = sqlSessionFactory.openSession()) {
            Post post = session.selectOne("com.tx.stu.userMapper.getPost", 1);
            System.out.println("title: "+post.getTitle());
            System.out.println("userName: "+post.getUser().getUsername());
        }
    }
}
