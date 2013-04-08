DROP TABLE IF EXISTS Book;

CREATE TABLE Book(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(250) NOT NULL,
  pages INTEGER NOT NULL
);

INSERT INTO Book(id, title, pages) VALUES (1, 'A Short Introduction to Philosophy', 1024);
INSERT INTO Book(id, title, pages) VALUES (2, 'Modern Physics', 512);