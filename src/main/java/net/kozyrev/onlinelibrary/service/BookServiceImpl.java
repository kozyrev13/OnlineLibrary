package net.kozyrev.onlinelibrary.service;


import net.kozyrev.onlinelibrary.dao.BookDAO;
import net.kozyrev.onlinelibrary.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    public Long id;

    public Long getId(){
        return this.id;
    }

    @Override
    public void addBook(Book book) {
        bookDAO.save(book);

    }

    @Override
    public String getBookByIdFromJsp() {
        return "";
    }

    @Override
    public List<Book> listBook() {
        return bookDAO.findAll();
    }

    @Override
    public void removeBook(Long id) {
        bookDAO.delete(id);
    }

    @Override
    public void decrementQuantity(Long id) {
        bookDAO.decrementQuantity(id);
    }

    @Override
    public void incrementQuantity(Long id) {
        bookDAO.incrementQuantity(id);
    }

    @Override
    public Book findBookById(Long id){
        return bookDAO.findOne(id);
    }

    @Override
    public List<Book> getBookLIstByUserId(Long id) {
       return bookDAO.getBookLIstByUserId(id);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
