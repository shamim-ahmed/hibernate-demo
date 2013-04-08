DROP TABLE IF EXISTS Metadata;
DROP TABLE IF EXISTS Book;

CREATE TABLE Book(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(250) NOT NULL,
  pages INTEGER NOT NULL
);

CREATE TABLE Metadata (
  id INTEGER NOT NULL PRIMARY KEY,
  isbn VARCHAR(20) NOT NULL,
  category VARCHAR(20) NOT NULL,
  CONSTRAINT metadata_fk FOREIGN KEY(id) REFERENCES Book(id) ON DELETE CASCADE,
  CONSTRAINT isbn_uniq UNIQUE(isbn),
  CONSTRAINT category_chk CHECK (category IN ('paperback', 'hardcover'))
);

INSERT INTO Book(id, title, pages) VALUES (1, 'A Short Introduction to Philosophy', 1024);
INSERT INTO Book(id, title, pages) VALUES (2, 'Modern Physics', 512);
INSERT INTO Metadata(id, isbn, category) VALUES (1, '123-456-7890', 'hardcover');
INSERT INTO Metadata(id, isbn, category) VALUES (2, '234-123-4532', 'hardcover');
