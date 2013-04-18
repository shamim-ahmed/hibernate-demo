DROP TABLE IF EXISTS User;

CREATE TABLE User(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  activated BOOLEAN NOT NULL
);

INSERT INTO User(id, username, activated) VALUES (1, 'shamim', true);
INSERT INTO User(id, username, activated) VALUES (2, 'tariq', false);
INSERT INTO User(id, username, activated) VALUES (3, 'salehein', true);
INSERT INTO User(id, username, activated) VALUES (4, 'musa', false);