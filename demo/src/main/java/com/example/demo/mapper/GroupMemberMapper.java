package com.example.demo.mapper;

import com.example.demo.pojo.GroupMembers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupMemberMapper {
    int insertGroup(GroupMembers groupMembers);

    List<GroupMembers> getGroupByUserId(int user_id);

    void deleteGroupById(int g_id);

    int updateGroupById(GroupMembers groupMembers);
}
