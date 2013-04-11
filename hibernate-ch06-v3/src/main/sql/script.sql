DROP TABLE IF EXISTS Personal_Ad;
DROP TABLE IF EXISTS Property_Ad;

CREATE TABLE Personal_Ad(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  birth_date DATE NOT NULL,
  sex VARCHAR(6) NOT NULL,
  message VARCHAR(200),
  CONSTRAINT personal_ad_sex_chk CHECK (sex in ('MALE', 'FEMALE'))
); 

CREATE TABLE Property_Ad(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(50) NOT NULL,
  state VARCHAR(50) NOT NULL,
  zip_code VARCHAR(10) NOT NULL,
  description VARCHAR(200)
);

INSERT INTO Personal_Ad(id, title, birth_date, sex, message) VALUES (1, 'Pet wanted', '2001-04-11', 'FEMALE', 'I want to buy a pet');
INSERT INTO Property_Ad(id, title, state, zip_code, description) VALUES (1, 'Luxurious house for sale', 'NSW', '2113', 'Luxurious house at Marsfield for sale');