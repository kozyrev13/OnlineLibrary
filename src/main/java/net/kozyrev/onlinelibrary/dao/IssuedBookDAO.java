package net.kozyrev.onlinelibrary.dao;

import net.kozyrev.onlinelibrary.model.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IssuedBookDAO extends JpaRepository<IssuedBook,Long> {
}
