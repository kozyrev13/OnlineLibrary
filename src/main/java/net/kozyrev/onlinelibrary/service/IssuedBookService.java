package net.kozyrev.onlinelibrary.service;

import net.kozyrev.onlinelibrary.model.IssuedBook;

import java.util.List;


public interface IssuedBookService {

    void addIssuedBook(IssuedBook book);

    List<IssuedBook> listIssuedBook();

    void removeIssuedBook(Long id);
}
