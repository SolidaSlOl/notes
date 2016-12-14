package com.notes.service;

import com.notes.model.Note;
import com.notes.model.User;
import java.util.List;

/**
 * Note Service.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface NoteService {

    /**
     * Save note for current logged in user.
     * @param note Note
     * @param currentUser Current user
     */
    void save(Note note, User currentUser);

    /**
     * Find all notes.
     * @return Found notes
     */
    List<Note> findAll();

    /**
     * Find note by id.
     * @param id Id
     * @return Note
     */
    Note findById(Integer id);
}
