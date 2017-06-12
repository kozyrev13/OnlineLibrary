package net.kozyrev.onlinelibrary.service;


public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
