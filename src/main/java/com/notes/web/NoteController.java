package com.notes.web;

import com.notes.model.Email;
import com.notes.model.Note;
import com.notes.service.NoteService;
import com.notes.service.UserService;
import javax.mail.MessagingException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping("notes/")
public class NoteController {
    @Autowired
    UserService userService;
    @Autowired
    NoteService noteService;

    @GetMapping(value = "/new")
    public final String initNoteCreateForm(final Model model) {
        final Note note = new Note();
        model.addAttribute("note", note);
        return "notes/createOrUpdateNoteForm";
    }

    @PostMapping(value = "/new")
    public final String processNoteCreateForm(
        @Valid final Note note,
        final BindingResult result
    ) {
        if (result.hasErrors()) {
            return "notes/createOrUpdateNoteForm";
        }
        this.noteService.save(note, this.userService.findCurrentUser());
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public final String initNoteUpdateForm(
        @PathVariable("id") final Integer id, final Model model
    ) {
        final Note note = this.noteService.findById(id);
        model.addAttribute("note", note);
        return "notes/createOrUpdateNoteForm";
    }

    @PostMapping(value = "{id}/edit")
    public final String processNoteUpdateForm(
        @Valid final Note note,
        final BindingResult result,
        @PathVariable("id") final Integer id
    ) {
        if (result.hasErrors()) {
            return "notes/createOrUpdateNoteForm";
        }
        this.noteService.save(note, this.userService.findCurrentUser());
        return "redirect:/";
    }

    @GetMapping(value = "{id}/send")
    public final String processEmailSendForm(@PathVariable Integer id) {
        String receiver = this.noteService.findById(id).getEmail();
        try {
            new Email().send(receiver);
            return "redirect:/success";
        } catch (MessagingException me) {
            return "redirect:/fail";
        }
    }
}
