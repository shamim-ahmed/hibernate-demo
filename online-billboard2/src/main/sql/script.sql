DROP TABLE Advert_Category;
DROP TABLE Category;
DROP TABLE Advert;
DROP TABLE Phone;
DROP TABLE User;

CREATE TABLE User (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(20) NOT NULL 
);

CREATE TABLE Phone (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  number VARCHAR(20) NOT NULL UNIQUE,
  comment VARCHAR(50),
  user_id INTEGER NOT NULL,
  CONSTRAINT phone_fk FOREIGN KEY(user_id) REFERENCES User(id) 
);

CREATE TABLE Advert (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  message VARCHAR(200),
  user_id INTEGER NOT NULL,
  CONSTRAINT advert_fk FOREIGN KEY(user_id) REFERENCES User(id) 
);

CREATE TABLE Category (
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL
);

CREATE TABLE Advert_Category (
  advert_id INTEGER NOT NULL,
  category_id INTEGER NOT NULL,
  CONSTRAINT advert_category_pk PRIMARY KEY(advert_id, category_id),
  CONSTRAINT advert_category_fk1 FOREIGN KEY(advert_id) REFERENCES Advert(id),
  CONSTRAINT advert_category_fk2 FOREIGN KEY(category_id) REFERENCES Category(id)
);

INSERT INTO User(id, name, password) VALUES (1, 'shamim', 'secret');
INSERT INTO User(id, name, password) VALUES (2, 'linus', 'topsecret');

INSERT INTO Phone(id, number, comment, user_id) VALUES (1, '2441139', 'home number', 1);
INSERT INTO Phone(id, number, comment, user_id) VALUES (2, '0450289581', 'office number', 2);

INSERT INTO Advert(id, title, message, user_id) VALUES (1, 'Buy my iPhone', 'iPhone 5 in brand new condition', 1);
INSERT INTO Advert(id, title, message, user_id) VALUES (2, 'Buy my Mac', 'Mac Leopard in brand new condition', 1);

INSERT INTO Category (id, title) VALUES (1, 'electronics');
INSERT INTO Category (id, title) VALUES (2, 'books');

INSERT INTO Advert_Category (advert_id, category_id) VALUES (1, 1);
INSERT INTO Advert_Category (advert_id, category_id) VALUES (2, 1);