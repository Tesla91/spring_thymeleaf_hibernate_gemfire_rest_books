package com.books.app.controllers;


import com.books.app.models.BookRecs;
import com.books.app.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class BooksController {

    @Autowired
    private BooksService booksService;

    @RequestMapping(value="/user/form", method = RequestMethod.GET)
    public ModelAndView form(Model model){
        model.addAttribute("bookRec", new BookRecs());
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.addObject("formName", "Please enter a book name to get some new recommendations");
        modelAndView.setViewName("user/form");
        return modelAndView;
    }

    @RequestMapping(value = "/user/book/recs", method = RequestMethod.POST )
    public String getId(@RequestParam(value = "title")String id) {
        return "redirect:/user/book/recs?id=" + booksService.getBookId(id);
    }

    @RequestMapping(value = "/user/book/recs", method = RequestMethod.GET)
    public String bookRecs(@RequestParam(value = "id")String id, Model model){
        ArrayList<BookRecs> bookRec = booksService.getBookRecs(id);
        model.addAttribute("bookRecArr", bookRec);

        return "user/bookRecs";
    }

}
