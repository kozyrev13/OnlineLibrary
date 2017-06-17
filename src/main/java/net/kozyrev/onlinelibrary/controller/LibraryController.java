package net.kozyrev.onlinelibrary.controller;


import net.kozyrev.onlinelibrary.model.IssuedBook;
import net.kozyrev.onlinelibrary.model.LibraryUser;
import net.kozyrev.onlinelibrary.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class LibraryController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private IssuedBookService issuedBookService;

    private Long getAuthorizedUserId(){
        return userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String listContacts(Map<String, Object> map) {
        map.put("libraryuser", new LibraryUser());
        map.put("bookList", bookService.listBook());
        map.put("issuedBookList",issuedBookService.listIssuedBookByUserId(getAuthorizedUserId()));
        map.put("userbooklist",bookService.getBookLIstByUserId(getAuthorizedUserId()));
        return "welcome";
    }
    @Transactional
    @RequestMapping("/take/{bookId}")
    public String takeBook(@PathVariable("bookId") Long bookId) {
        bookService.decrementQuantity(bookId);
        issuedBookService.addIssuedBook(new IssuedBook(getAuthorizedUserId(),bookId));
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
}
