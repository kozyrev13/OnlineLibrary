
CREATE TABLE library_users (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(255),
  lastname VARCHAR(255),
  phone_number VARCHAR(255),
  email VARCHAR(255),
  FOREIGN KEY (id) REFERENCES users(id)
) ENGINE InnoDB;

CREATE TABLE books (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  author VARCHAR(255),
  pages INT,
  year INT,
  quantity INT
) ENGINE InnoDB;

CREATE TABLE issued_books (
  id_book INT NOT NULL,
  id_library_user INT NOT NULL,
  time DATETIME DEFAULT now(),

  FOREIGN KEY (id_book) REFERENCES books(id),
  FOREIGN KEY (id_library_user) REFERENCES library_users(id),

  UNIQUE (id_book,id_library_user)
) ENGINE InnoDB;