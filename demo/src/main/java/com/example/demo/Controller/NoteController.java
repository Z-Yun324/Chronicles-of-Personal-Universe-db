package com.example.demo.Controller;

import com.example.demo.Service.GroupMemberService;
import com.example.demo.Service.NoteService;
import com.example.demo.mapper.NoteMapper;
import com.example.demo.pojo.GroupMembers;
import com.example.demo.pojo.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/insertNote")
    public String insert(@RequestBody Notes notes){
        boolean success = noteService.insertNote(notes);
        if (success) {
            return "新增成功";
        } else {
            return "新增失敗";
        }
    }

    @GetMapping("/selectNote/{userid}")
    public List<Notes> select(@PathVariable("userid")int userid){
        return noteService.getNoteByUserId(userid);
    }
    @DeleteMapping("/deleteNote/{id}")
    public String delete(@PathVariable("id")int id){
        noteService.deleteNoteById(id);
        return "刪除成功";
    }

    @PostMapping("/updateNote")
    public String update(@RequestBody Notes notes){
        boolean success = noteService.updateNoteById(notes);
        if (success) {
            return "新增成功";
        } else {
            return "新增失敗";
        }
    }
}
