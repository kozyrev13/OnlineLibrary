package net.kozyrev.onlinelibrary.service;


import net.kozyrev.onlinelibrary.model.LibraryUser;

import java.util.List;

public interface LibraryUserService {

    void save(LibraryUser libraryUser);

    List<LibraryUser> getList();
}
