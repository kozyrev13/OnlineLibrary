package net.kozyrev.onlinelibrary.dao;


import net.kozyrev.onlinelibrary.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryUserDAO extends JpaRepository<LibraryUser,Long> {
}
