package com.example.demo.Service;

import com.example.demo.mapper.GroupMemberMapper;
import com.example.demo.mapper.NoteMapper;
import com.example.demo.pojo.GroupMembers;
import com.example.demo.pojo.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteMapper noteMapper;

    public boolean insertNote(Notes notes) {
        int rowsAffected = noteMapper.insertNote(notes);
        return rowsAffected > 0;

    }

    public List<Notes> getNoteByUserId(int user_id){
        return noteMapper.getNoteByUserId(user_id);
    }

    public void deleteNoteById(int n_id){
        noteMapper.deleteNoteById(n_id);
    }

    public boolean updateNoteById(Notes notes){
        int rowsAffected = noteMapper.updateNoteById(notes);
        return rowsAffected > 0;
    }
}
