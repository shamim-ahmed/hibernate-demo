DROP TABLE IF EXISTS Advert;

CREATE TABLE Advert(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  category VARCHAR(8) NOT NULL,
  birth_date DATE,
  sex VARCHAR(6),
  message VARCHAR(200),
  state VARCHAR(50),
  zip_code VARCHAR(10),
  description VARCHAR(200),
  CONSTRAINT advert_sex_chk CHECK (sex IN ('MALE', 'FEMALE')),
  CONSTRAINT advert_category_chk CHECK (category IN ('personal', 'property'))
);

INSERT INTO Advert(id, title, category, birth_date, sex, message) VALUES (1, 'Pet wanted', 'personal', '2001-04-11', 'FEMALE', 'I want to buy a pet');
INSERT INTO Advert(id, title, category, state, zip_code, description) VALUES (2, 'Luxurious house for sale', 'property', 'NSW', '2113', 'Luxurious house at Marsfield for sale');
