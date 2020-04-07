package net.kozyrev.onlinelibrary.controller;

import net.kozyrev.onlinelibrary.model.Book;
import net.kozyrev.onlinelibrary.service.BookService;
import net.kozyrev.onlinelibrary.service.IssuedBookService;
import net.kozyrev.onlinelibrary.service.LibraryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdministratorController {

    @Autowired
    private BookService defaultBookService;

    @Autowired
    private IssuedBookService issuedBookService;

    @Autowired
    private LibraryUserService libraryUserService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminLists(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", defaultBookService.listBook());
        model.addAttribute("issuedBookList",issuedBookService.listIssuedBook());
        model.addAttribute("libraryUserList",libraryUserService.getList());
        return "admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        defaultBookService.addBook(book);
        return "redirect:admin";
    }

}
