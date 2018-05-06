package com.tx.stu.mapper;

import com.tx.stu.models.Group;

/**
 * Created by peter.
 */
public interface GroupMaper {
    void insertGroup(Group group);

    Group getGroup(int i);
}
