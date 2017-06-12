package net.kozyrev.onlinelibrary.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "issued_books")
public class IssuedBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "id_library_user")
    private Long id_LibraryUser;


    @Column(name = "id_book")
    private Long id_Book;

    @Column(name = "time")
    private Date time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_LibraryUser() {
        return id_LibraryUser;
    }

    public void setId_LibraryUser(Long id_LibraryUser) {
        this.id_LibraryUser = id_LibraryUser;
    }

    public Long getId_Book() {
        return id_Book;
    }

    public void setId_Book(Long id_Book) {
        this.id_Book = id_Book;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
