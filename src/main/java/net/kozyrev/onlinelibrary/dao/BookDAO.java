package net.kozyrev.onlinelibrary.dao;


import net.kozyrev.onlinelibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book,Long> {

}
