package com.tx.stu.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peter.
 */
public class Group implements Serializable{
    private int groupId;
    private String groupName;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
