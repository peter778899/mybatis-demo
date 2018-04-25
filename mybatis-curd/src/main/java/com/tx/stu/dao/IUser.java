package com.tx.stu.dao;

import com.tx.stu.models.User;

import java.util.List;

/**
 * Created by peter.
 */
public interface IUser {
    public List<User> getUserList();

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(int userId);

    public User getUser(int id);
}
