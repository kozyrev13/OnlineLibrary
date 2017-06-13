package net.kozyrev.onlinelibrary.controller;

import net.kozyrev.onlinelibrary.model.Book;
import net.kozyrev.onlinelibrary.model.User;
import net.kozyrev.onlinelibrary.service.BookService;
import net.kozyrev.onlinelibrary.service.SecurityService;
import net.kozyrev.onlinelibrary.service.UserService;
import net.kozyrev.onlinelibrary.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

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

        map.put("contact", new Book());
        map.put("contactList", bookService.listBook());

        return "welcome";
    }

    @RequestMapping("/take/{contactId}")
    public String deleteContact(@PathVariable("contactId") Long contactId) {

        bookService.decrementQuantity(contactId);

        return "redirect:/welcome";
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }




}
