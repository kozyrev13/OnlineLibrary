package net.kozyrev.onlinelibrary.service;


import net.kozyrev.onlinelibrary.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book contact);

    List<Book> listBook();

    void removeBook(Long id);

    Book findBookById(Long id);

    void decrementQuantity(Long id);

    void incrementQuantity(Long id);
}
