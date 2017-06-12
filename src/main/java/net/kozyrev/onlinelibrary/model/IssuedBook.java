package net.kozyrev.onlinelibrary.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "issued_books")
public class IssuedBook {

    @Column
    private Long id_LibraryUser;

    @Column
    private Long id_Book;

    @Column
    private Date time;
}
