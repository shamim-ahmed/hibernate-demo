DROP TABLE IF EXISTS Book_Author;
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Author;
DROP TABLE IF EXISTS Publisher;

CREATE TABLE Publisher(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE Book(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(250) NOT NULL,
  pages INTEGER NOT NULL,
  publisher_id INTEGER,
  CONSTRAINT book_fk FOREIGN KEY(publisher_id) REFERENCES Publisher(id) ON DELETE SET NULL
);

CREATE TABLE Author(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL
);

CREATE TABLE Book_Author(
  book_id INTEGER NOT NULL,
  author_id INTEGER NOT NULL,
  CONSTRAINT book_author_pk PRIMARY KEY(book_id, author_id),
  CONSTRAINT book_author_fk1 FOREIGN KEY(book_id) REFERENCES Book(id),
  CONSTRAINT book_author_fk2 FOREIGN KEY(author_id) REFERENCES Author(id)
);

INSERT INTO Publisher(id, name) VALUES (1, 'McGraw Hill');
INSERT INTO Publisher(id, name) VALUES (2, 'Oreilly');
INSERT INTO Publisher(id, name) VALUES (3, 'Sybex');

INSERT INTO Book(id, title, pages, publisher_id) VALUES (1, 'A Short Introduction to Philosophy', 1024, 1);
INSERT INTO Book(id, title, pages, publisher_id) VALUES (2, 'Modern Physics', 512, 3);
INSERT INTO Book(id, title, pages, publisher_id) VALUES (3, 'Head First Servlets and JSP', 424, 2);
INSERT INTO Book(id, title, pages, publisher_id) VALUES (4, 'A Brief History of the Internet', 300, 1);

INSERT INTO Author(id, first_name, last_name) VALUES (1, 'Emmanuel', 'Kant');
INSERT INTO Author(id, first_name, last_name) VALUES (2, 'David', 'Halliday');
INSERT INTO Author(id, first_name, last_name) VALUES (3, 'Robert', 'Resnick');
INSERT INTO Author(id, first_name, last_name) VALUES (4, 'Jerryl', 'Walker');
INSERT INTO Author(id, first_name, last_name) VALUES (5, 'Brian', 'Basham');
INSERT INTO Author(id, first_name, last_name) VALUES (6, 'Kathy', 'Sierra');
INSERT INTO Author(id, first_name, last_name) VALUES (7, 'Bert', 'Bates');
INSERT INTO Author(id, first_name, last_name) VALUES (8, 'Vincent', 'Cerf');

INSERT INTO Book_Author(book_id, author_id) VALUES(1, 1);
INSERT INTO Book_Author(book_id, author_id) VALUES(2, 2);
INSERT INTO Book_Author(book_id, author_id) VALUES(2, 3);
INSERT INTO Book_Author(book_id, author_id) VALUES(2, 4);
INSERT INTO Book_Author(book_id, author_id) VALUES(3, 5);
INSERT INTO Book_Author(book_id, author_id) VALUES(3, 6);
INSERT INTO Book_Author(book_id, author_id) VALUES(3, 7);
INSERT INTO Book_Author(book_id, author_id) VALUES(4, 8);



