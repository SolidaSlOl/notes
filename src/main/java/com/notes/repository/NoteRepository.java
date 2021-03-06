package com.notes.repository;

import com.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data Repository.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface NoteRepository extends JpaRepository<Note, Integer> {
}
