package com.notes.service;

import com.notes.model.Note;
import com.notes.model.User;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface NoteService {

    void save(Note note, User currentUser);

    List<Note> findAll();
}
