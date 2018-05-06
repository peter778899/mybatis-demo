package com.tx.stu;

import com.tx.stu.mapper.GroupMaper;
import com.tx.stu.mapper.UserGroupMaper;
import com.tx.stu.mapper.UserMaper;
import com.tx.stu.models.Group;
import com.tx.stu.models.User;
import com.tx.stu.models.UserGroup;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * Created by peter.
 */
public class Main {
    private static SqlSessionFactory sqlSessionFactory;
    public static void main(String[] args) throws IOException {
       sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"));
//         testAddGroup();
//         testAddUser();
//         testAddUserGroup();
        testGetGroupAndUsers();
    }

    public static void testGetGroupAndUsers() {
        UserGroup userGroup = new UserGroup();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            GroupMaper groupMaper = session.getMapper(GroupMaper.class);
            Group group = groupMaper.getGroup(1);
            System.out.println("Group => " + group.getGroupName());
            List<User> users = group.getUsers();
            for (User user : users) {
                System.out.println("\t:" + user.getId() + "\t"
                        + user.getUsername());
            }
        } finally {
            session.close();
        }
    }

    public static void testAddUserGroup() {
        UserGroup userGroup = new UserGroup();
        userGroup.setGroupId(1);
        userGroup.setUserId(2);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserGroupMaper userGroupMaper = session
                    .getMapper(UserGroupMaper.class);
            userGroupMaper.insertUserGroup(userGroup);

            session.commit();
        } finally {
            session.close();
        }

    }

    public static void testAddUser() {
        // TODO Auto-generated method stub
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User();
            user.setUsername("User-name-1");
            user.setMobile("13838009988");
            UserMaper userMaper = session.getMapper(UserMaper.class);
            userMaper.insertUser(user);
            session.commit();
            // System.out.println(user.getGroupId());
        } finally {
            session.close();
        }
    }

    public static void testAddGroup() {
        // TODO Auto-generated method stub
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Group group = new Group();
            group.setGroupName("用户组-1");
            GroupMaper groupMapper = session.getMapper(GroupMaper.class);
            groupMapper.insertGroup(group);
            session.commit();
            System.out.println(group.getGroupId());
        } finally {
            session.close();
        }
    }
}
