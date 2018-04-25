package com.tx.stu.dao;

import com.tx.stu.models.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by peter.
 */
public interface IUser {
    @Select("select * from user where id= #{id}")
    public User getUserByID(int id);
}
