DROP TABLE IF EXISTS Book;
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

INSERT INTO Publisher(id, name) VALUES (1, 'McGraw Hill');
INSERT INTO Publisher(id, name) VALUES (2, 'Oreilly');
INSERT INTO Publisher(id, name) VALUES (3, 'Sybex');

INSERT INTO Book(id, title, pages, publisher_id) VALUES (1, 'A Short Introduction to Philosophy', 1024, 1);
INSERT INTO Book(id, title, pages, publisher_id) VALUES (2, 'Modern Physics', 512, 3);
INSERT INTO Book(id, title, pages, publisher_id) VALUES (3, 'Head First Servlets and JSP', 424, 2);
INSERT INTO Book(id, title, pages, publisher_id) VALUES (4, 'A Brief History of the Internet', 300, 1);
