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



    @Override
    public void addBook(Book book) {
        bookDAO.save(book);

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

    public String abc() {
        return "abc";
    }
}
