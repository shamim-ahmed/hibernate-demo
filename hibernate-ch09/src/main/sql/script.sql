DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS Department;

CREATE TABLE Department(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  street VARCHAR(50),
  city VARCHAR(50) NOT NULL,
  country VARCHAR(50) NOT NULL
); 

CREATE TABLE Employee(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  salary DOUBLE(8, 2) NOT NULL,
  dept_id INTEGER,
  CONSTRAINT employee_fk FOREIGN KEY (dept_id) REFERENCES Department(id) ON DELETE SET NULL
);

INSERT INTO Department(id, name, street, city, country) VALUES (1, 'Research', '14/142 Herring Road', 'Sydney', 'Australia');
INSERT INTO Department(id, name, street, city, country) VALUES (2, 'Marketing', '35/188 Balaclava Road', 'Sydney', 'Australia');

INSERT INTO Employee(id, first_name, last_name, salary, dept_id) VALUES (1, 'shamim', 'ahmed', 4000.00, 1);
INSERT INTO Employee(id, first_name, last_name, salary, dept_id) VALUES (2, 'hedieh', 'ranjbartabar', 8000.00, 1);
INSERT INTO Employee(id, first_name, last_name, salary, dept_id) VALUES (3, 'lei', 'lei', 12000.00, 2);