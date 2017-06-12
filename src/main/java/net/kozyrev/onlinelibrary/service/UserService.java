package net.kozyrev.onlinelibrary.service;


import net.kozyrev.onlinelibrary.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
