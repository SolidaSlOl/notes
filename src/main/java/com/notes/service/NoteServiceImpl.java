package com.notes.service;

import com.notes.model.Note;
import com.notes.model.User;
import com.notes.repository.NoteRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    @Transactional
    public void save(final Note note, final User currentUser) {
        note.setUser(currentUser);
        this.noteRepository.save(note);
    }

    @Override
    @Transactional
    public List<Note> findAll() {
        return this.noteRepository.findAll();
    }

    @Override
    public Note findById(final Integer id) {
        return this.noteRepository.findOne(id);
    }
}
