package net.kozyrev.onlinelibrary.service;

import net.kozyrev.onlinelibrary.model.IssuedBook;

import java.util.List;


public interface IssuedBookService {

    IssuedBook findById(Long id);

    void addIssuedBook(IssuedBook book);

    List<IssuedBook> listIssuedBook();

    List<IssuedBook> listIssuedBookByUserId(Long id);

    void removeIssuedBook(Long id);

    void removeIssuedBookByIdBook(Long id,Long idi);


}
