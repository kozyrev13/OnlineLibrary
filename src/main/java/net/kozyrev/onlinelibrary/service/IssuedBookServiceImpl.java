package net.kozyrev.onlinelibrary.service;


import net.kozyrev.onlinelibrary.dao.IssuedBookDAO;
import net.kozyrev.onlinelibrary.model.IssuedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuedBookServiceImpl implements IssuedBookService {



    @Autowired
    private IssuedBookDAO issuedBookDAO;

    @Override
    public IssuedBook findById(Long id) {
        return issuedBookDAO.findOne(id);
    }

    @Override
    public void addIssuedBook(IssuedBook book) {
        issuedBookDAO.save(book);
    }

    @Override
    public List<IssuedBook> listIssuedBook() {
        return issuedBookDAO.findAll();
    }

    @Override
    public void removeIssuedBook(Long id) {
        issuedBookDAO.delete(id);
    }

    @Override
    public List<IssuedBook> listIssuedBookByUserId(Long id) {
        return issuedBookDAO.findAllByUserID(id);
    }
}
