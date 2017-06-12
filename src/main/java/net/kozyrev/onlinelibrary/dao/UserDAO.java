package net.kozyrev.onlinelibrary.dao;


import net.kozyrev.onlinelibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
