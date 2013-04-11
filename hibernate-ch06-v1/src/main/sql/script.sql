DROP TABLE IF EXISTS Advert;

CREATE TABLE Advert(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  content VARCHAR(200) NOT NULL,
  pictureCaption VARCHAR(100) NOT NULL,
  pictureFileName VARCHAR(200) NOT NULL
); 

INSERT INTO Advert (id, title, content, pictureCaption, pictureFileName) VALUES (1, 'Buy my iPhone', 'I want to sell my iPhone, which is brand new', 'iPhone image', 'iPhone.jpg');