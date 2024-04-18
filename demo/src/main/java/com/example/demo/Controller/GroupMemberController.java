package com.example.demo.Controller;

import com.example.demo.Service.GroupMemberService;
import com.example.demo.pojo.GroupMembers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupMemberController {

    @Autowired
    private GroupMemberService groupMemberService;

    @PostMapping("/insertGroup")
    public String insert(@RequestBody GroupMembers groupMembers){
        boolean success = groupMemberService.insertMember(groupMembers);
        if (success) {
            return "新增成功";
        } else {
            return "新增失敗";
        }
    }

    @GetMapping("/selectGroup/{userid}")
    public List<GroupMembers> select(@PathVariable("userid")int userid){
        return groupMemberService.getGroupByUserId(userid);
    }
    @DeleteMapping("/deleteGroup/{id}")
    public String delete(@PathVariable("id")int id){
        groupMemberService.deleteGroupById(id);
        return "刪除成功";
    }

    @PostMapping("/updateGroup")
    public String update(@RequestBody GroupMembers groupMembers){
        boolean success = groupMemberService.updateGroupById(groupMembers);
        if (success) {
            return "新增成功";
        } else {
            return "新增失敗";
        }
    }

}
