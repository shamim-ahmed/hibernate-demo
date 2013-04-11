DROP TABLE IF EXISTS Personal_Ad;
DROP TABLE IF EXISTS Property_Ad;
DROP TABLE IF EXISTS Advert;

CREATE TABLE Advert(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL
);

CREATE TABLE Personal_Ad(
  ad_id INTEGER NOT NULL PRIMARY KEY,
  birth_day DATE NOT NULL,
  sex VARCHAR(6) NOT NULL,
  message VARCHAR(200),
  CONSTRAINT personal_ad_fk FOREIGN KEY(ad_id) REFERENCES Advert(id),
  CONSTRAINT personal_ad_sex_chk CHECK (sex in ('MALE', 'FEMALE'))
); 

CREATE TABLE Property_Ad(
  ad_id INTEGER NOT NULL PRIMARY KEY,
  state VARCHAR(50) NOT NULL,
  zip_code VARCHAR(10) NOT NULL,
  description VARCHAR(200),
  CONSTRAINT property_ad_fk FOREIGN KEY(ad_id) REFERENCES Advert(id)
);

INSERT INTO Advert(id, title) VALUES (1, 'Pet wanted');
INSERT INTO Advert(id, title) VALUES (2, 'Luxurious house for sale');
INSERT INTO Personal_Ad(ad_id, birth_day, sex, message) VALUES (1, '2001-04-11', 'FEMALE', 'I want to buy a pet');
INSERT INTO Property_Ad(ad_id, state, zip_code, description) VALUES (2, 'NSW', '2113', 'Luxurious house at Marsfield for sale');