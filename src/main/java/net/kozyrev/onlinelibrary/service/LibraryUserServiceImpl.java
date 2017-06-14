package net.kozyrev.onlinelibrary.service;


import net.kozyrev.onlinelibrary.dao.LibraryUserDAO;
import net.kozyrev.onlinelibrary.model.LibraryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryUserServiceImpl implements LibraryUserService {

    @Autowired
    private LibraryUserDAO libraryUserDAO;

    @Override
    public void save(LibraryUser libraryUser) {
        libraryUserDAO.save(libraryUser);
    }
}
