DROP TABLE IF EXISTS Booking;

CREATE TABLE Booking(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  seat VARCHAR(5) NOT NULL
);

INSERT INTO Booking(id, name, seat) VALUES (1, 'Shamim Ahmed', '1A');
INSERT INTO Booking(id, name, seat) VALUES (2, 'Tariq Anam', '2A');
INSERT INTO Booking(id, name, seat) VALUES (3, 'Frank Moisiadis', '3B');