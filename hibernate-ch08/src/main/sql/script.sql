DROP TABLE IF EXISTS Software;
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS Supplier;

CREATE TABLE Supplier(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE Product(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(500),
  price DECIMAL(8, 2) NOT NULL,
  sup_id INTEGER NOT NULL,
  CONSTRAINT product_fk FOREIGN KEY(sup_id) REFERENCES Supplier(id)
);

CREATE TABLE Software(
  id INTEGER NOT NULL PRIMARY KEY,
  version VARCHAR(20) NOT NULL,
  CONSTRAINT software_fk FOREIGN KEY(id) REFERENCES Product(id)
);

INSERT INTO Supplier(id, name) VALUES (1, 'Woolworths');
INSERT INTO Supplier(id, name) VALUES (2, 'Microsoft');
INSERT INTO Supplier(id, name) VALUES (3, 'Samsung');
INSERT INTO Supplier(id, name) VALUES (4, 'Oracle');
INSERT INTO Supplier(id, name) VALUES (5, 'Hewlett-Packard');

INSERT INTO Product(id, name, description, price, sup_id) VALUES (1, 'MS Office', 'Office software', 120.00, 2);
INSERT INTO Product(id, name, description, price, sup_id) VALUES (2, 'Chocolates', null, 4.25, 1);
INSERT INTO Product(id, name, description, price, sup_id) VALUES (3, 'Galaxy', 'Mobile set', 459.57, 3);
INSERT INTO Product(id, name, description, price, sup_id) VALUES (4, 'Bread', 'Cheap bread', 1.10, 1);
INSERT INTO Product(id, name, description, price, sup_id) VALUES (5, 'MS SQL Server', null, 450.00, 2);
INSERT INTO Product(id, name, description, price, sup_id) VALUES (6, 'Laptop', 'Laptop from Samsung', 559.59, 3);
INSERT INTO Product(id, name, description, price, sup_id) VALUES (7, 'Oracle Database', 'Database software', 725.00, 4);
INSERT INTO Product(id, name, description, price, sup_id) VALUES (8, 'Mouse', 'Optical mouse from HP', 50.00, 5);
INSERT INTO Product(id, name, description, price, sup_id) VALUES (9, 'Tissue', 'Toilet tissue large pack', 30.00, 1);

INSERT INTO Software (id, version) VALUES (1, 'office-2013');
INSERT INTO Software (id, version) VALUES (5, '5.1.23');
INSERT INTO Software (id, version) VALUES (7, '11.1.21');


