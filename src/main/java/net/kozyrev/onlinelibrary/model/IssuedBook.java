package net.kozyrev.onlinelibrary.model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
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

    @Column(name = "issue_time")
    private Timestamp time;

    @Column(name = "return_time")
    private Timestamp returnTime;

    public IssuedBook() {
    }

    public IssuedBook(Long id_LibraryUser, Long id_Book) {
        this.id_LibraryUser = id_LibraryUser;
        this.id_Book = id_Book;
        this.time = new Timestamp(new Date().getTime());
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

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

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
