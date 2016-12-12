package com.notes.web;

import com.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * @author Mikita Herasiutsin (mikita.herasiutsin@gmail.com)
 * @version 1.0
 * @since 1.0
 */
@Controller
public class HomeController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public final ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("notes", this.noteService.findAll());
        return mav;
    }
}
