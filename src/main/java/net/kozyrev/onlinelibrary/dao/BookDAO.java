package net.kozyrev.onlinelibrary.dao;


import net.kozyrev.onlinelibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BookDAO extends JpaRepository<Book,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.quantity=b.quantity-1 where b.id=?1")
    void decrementQuantity(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.quantity=b.quantity+1 where b.id=?1")
    void incrementQuantity(Long id);

}
