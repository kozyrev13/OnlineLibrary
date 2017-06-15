package net.kozyrev.onlinelibrary.controller;

import net.kozyrev.onlinelibrary.model.LibraryUser;
import net.kozyrev.onlinelibrary.model.User;
import net.kozyrev.onlinelibrary.service.LibraryUserService;
import net.kozyrev.onlinelibrary.service.SecurityService;
import net.kozyrev.onlinelibrary.service.UserService;
import net.kozyrev.onlinelibrary.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    @Autowired
    private LibraryUserService libraryUserService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model ) {
        model.addAttribute("userForm",new User());
        return "/registration";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        userValidator.validate(userForm,bindingResult);
        if (bindingResult.hasErrors()) {
            return "/registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(),userForm.getConfirmPassword());

        return "redirect:/registration2";
    }
    @RequestMapping(value = "/registration2", method = RequestMethod.GET)
    public String registration2(Model model ) {
        model.addAttribute("libraryUserForm",new LibraryUser());
        return "/registration2";
    }

    @RequestMapping(value = "/registration2", method = RequestMethod.POST)
    public String registration2(@ModelAttribute("libraryUserForm") LibraryUser libraryUserForm, BindingResult bindingResult, Model model){

        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        libraryUserForm.setId(userService.findByUsername(s).getId());
        libraryUserService.save(libraryUserForm);


        return "redirect:/welcome";
    }
}
