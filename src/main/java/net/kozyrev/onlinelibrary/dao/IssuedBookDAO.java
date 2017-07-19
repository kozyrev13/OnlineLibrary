package net.kozyrev.onlinelibrary.dao;

import net.kozyrev.onlinelibrary.model.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IssuedBookDAO extends JpaRepository<IssuedBook,Long> {

    @Query("SELECT ib from IssuedBook ib where ib.id_LibraryUser=?1")
    List<IssuedBook> findAllByUserID(Long id);

    @Query(value = "select * from issued_books where id_book=?1 and id_library_user=?2 limit 1", nativeQuery = true)
    IssuedBook findFirstById_BookAndId_LibraryUser(Long idbook,Long iduser);


}
