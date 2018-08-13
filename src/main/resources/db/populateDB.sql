DELETE FROM users;
ALTER SEQUENCE global_seq
RESTART WITH 1000;

INSERT INTO users (name, email, password) VALUES
  ('Admin', 'admin@gmail.com', 'admin'),
  ('Herbert', 'herbert@gmail.com', 'herbert'),
  ('Dominik', 'dominik@gmail.com', '12345678');

INSERT INTO restaurants (title, location) VALUES
  ('Local', '33 Dark Spurt, Lviv'),
  ('Panorama', '44 Zankoveckoj street, Lviv'),
  ('Kruivka', '11 Mykolaja street, Ternopil'),
  ('Varenuku', '101 Filbert street, Lviv'),
  ('Frontos', '2 Chapel street, Lviv'),
  ('Shekspire', '17 Kosmonavtov street, Lviv'),
  ('Fransua', '44 Lenina street, Lviv');

INSERT INTO dishes (name, price) VALUES
  ('Calamari', 33),
  ('Meat balls + Deruny', 112),
  ('Cabbage rolls', 52),
  ('Black tea', 10),
  ('Grape juice', 11),
  ('Cocoa', 15),
  ('Omelette', 27),
  ('Casserole', 72),
  ('Coffe', 12),
  ('Fish and chips', 108),
  ('Mint tea', 25),
  ('Champagne', 50),
  ('Pizza', 45),
  ('French fries', 30),
  ('Cutlet + spaghetti', 62);

