package com.example.demo.mapper;

import com.example.demo.pojo.GroupMembers;
import com.example.demo.pojo.Notes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoteMapper {
    int insertNote(Notes notes);

    List<Notes> getNoteByUserId(int user_id);

    void deleteNoteById(int n_id);

    int updateNoteById(Notes notes);
}
