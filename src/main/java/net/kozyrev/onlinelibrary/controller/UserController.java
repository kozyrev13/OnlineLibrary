package net.kozyrev.onlinelibrary.controller;

import net.kozyrev.onlinelibrary.model.Book;
import net.kozyrev.onlinelibrary.model.IssuedBook;
import net.kozyrev.onlinelibrary.model.LibraryUser;
import net.kozyrev.onlinelibrary.model.User;
import net.kozyrev.onlinelibrary.service.*;
import net.kozyrev.onlinelibrary.validator.UserValidator;
import org.hibernate.annotations.Synchronize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LibraryUserService libraryUserService;

    @Autowired
    private BookService bookService;

    @Autowired
    private IssuedBookService issuedBookService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;



    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model ) {
        model.addAttribute("userForm",new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        userValidator.validate(userForm,bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(),userForm.getConfirmPassword());

        return "redirect:/newlibraryuser";
    }

    @RequestMapping(value = "/newlibraryuser", method = RequestMethod.GET)
    public String registration2(Map<String, Object> map ) {
        map.put("contact", new LibraryUser());
        return "registration2";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") LibraryUser libraryUser,
                             BindingResult result) {
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        libraryUser.setId(userService.findByUsername(s).getId());
        libraryUserService.save(libraryUser);

        return "redirect:/welcome";
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String listContacts(Map<String, Object> map) {
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        map.put("libraryuser", new LibraryUser());
        map.put("bookList", bookService.listBook());
        map.put("issuedBookList",issuedBookService.listIssuedBookByUserId(userService.findByUsername(s).getId()));
        return "welcome";
    }
    @Transactional
    @RequestMapping("/take/{bookId}")
    public String takeBook(@PathVariable("bookId") Long contactId) {
        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        bookService.decrementQuantity(contactId);
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setId_Book(contactId);
        issuedBook.setId_LibraryUser(userService.findByUsername(s).getId());
        Date date = new Date();
        issuedBook.setTime(new Timestamp(date.getTime()));
        issuedBookService.addIssuedBook(issuedBook);
        return "redirect:/welcome";
    }

    @Transactional
    @RequestMapping("/return/{issuedBookId}")
    public String deleteIssuedBook(@PathVariable("issuedBookId") Long contactId) {
        Long idBook = issuedBookService.findById(contactId).getId_Book();
        issuedBookService.removeIssuedBook(contactId);
        bookService.incrementQuantity(idBook);
        return "redirect:/welcome";
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }




}
