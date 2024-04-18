package com.example.demo.Service;

import com.example.demo.mapper.GroupMemberMapper;
import com.example.demo.pojo.GroupMembers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMemberService {

    @Autowired
    private GroupMemberMapper groupMemberMapper;

    public boolean insertMember(GroupMembers groupMembers) {
            int rowsAffected = groupMemberMapper.insertGroup(groupMembers);
            return rowsAffected > 0;

    }

    public List<GroupMembers>getGroupByUserId(int userid){
        return groupMemberMapper.getGroupByUserId(userid);
    }
    public void deleteGroupById(int g_id){
        groupMemberMapper.deleteGroupById(g_id);
    }
    public boolean updateGroupById(GroupMembers groupMembers){
        int rowsAffected = groupMemberMapper.updateGroupById(groupMembers);
        return rowsAffected > 0;
    }
}
