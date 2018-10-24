DELETE FROM votes;
DELETE FROM users_roles;
DELETE FROM restaurants;
DELETE FROM dishes;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO dishes (name, price) VALUES
  ('Calamari', 33),
  ('Meat balls + Deruny', 112),
  ('Cabbage rolls', 52),
  ('Omelette', 27),
  ('Casserole', 72),
  ('Fish and chips', 108),
  ('Mint tea', 25),
  ('Champagne', 50),
  ('Cutlet + spaghetti', 62);

INSERT INTO restaurants (title, location, dish_id) VALUES
  ('Local', '33 Dark Spurt, Lviv', 1000),
  ('Panorama', '44 Zankoveckoj street, Lviv', 1001),
  ('Kruivka', '11 Mykolaja street, Ternopil', 1002),
  ('Varenuku', '101 Filbert street, Lviv', 1003),
  ('Frontos', '2 Chapel street, Lviv', 1004),
  ('Shekspire', '17 Kosmonavtov street, Lviv', 1005),
  ('Fransua', '44 Lenina street, Lviv', 1006);
/*
 *  Encrypted passwords(bcrypt algorithm):
 *  admin --> $2a$10$nkIkAuiTPDwI1apyvvkALuGjLzlH4z6drw.P4.kRTzWnV7c5eai9K
 *  herbert --> $2a$10$38QCKfvthp4JuEg1Rar7je4KHF9mVoaH0dZpGdP/BCMOeq/.scZx2
 *  12345678 --> $2a$10$d1nYOalJluNlt5K/BPUnlOKT5A3LZ7irNzR2..vuorxd3SXkOwsSm
 */
INSERT INTO users (name, email, password) VALUES
  ('Admin', 'admin@gmail.com', '$2a$10$nkIkAuiTPDwI1apyvvkALuGjLzlH4z6drw.P4.kRTzWnV7c5eai9K'),
  ('Herbert', 'herbert@gmail.com', '$2a$10$38QCKfvthp4JuEg1Rar7je4KHF9mVoaH0dZpGdP/BCMOeq/.scZx2'),
  ('Dominik', 'dominik@gmail.com', '$2a$10$d1nYOalJluNlt5K/BPUnlOKT5A3LZ7irNzR2..vuorxd3SXkOwsSm');

INSERT INTO users_roles (user_id, role) VALUES
  (1018, 'ROLE_USER'),
  (1017, 'ROLE_USER'),
  (1016, 'ROLE_ADMIN');

INSERT INTO votes (user_id, restaurant_id) VALUES
  (1017, 1009);
