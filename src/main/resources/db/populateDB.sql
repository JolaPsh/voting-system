DELETE FROM votes;
DELETE FROM user_roles;
DELETE FROM dishes;
DELETE FROM restaurants;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO restaurants (title, location) VALUES
  ('Local', '33 Dark Spurt, Lviv'),
  ('Panorama', '44 Zankoveckoj street, Lviv'),
  ('Kruivka', '11 Mykolaja street, Ternopil'),
  ('Varenuku', '101 Filbert street, Lviv'),
  ('Frontos', '2 Chapel street, Lviv'),
  ('Shekspire', '17 Kosmonavtov street, Lviv'),
  ('Fransua', '44 Lenina street, Lviv');
  
INSERT INTO dishes (name, price, restaurant_id) VALUES
  ('Calamari', 33, 1001),
  ('Meat balls + Deruny', 112, 1000),
  ('Cabbage rolls', 52, 1002),
  ('Omelette', 27, 1000),
  ('Casserole', 72, 1003),
  ('Fish and chips', 108, 1006),
  ('Mint tea', 25, 1005),
  ('Champagne', 50, 1004),
  ('Cutlet + spaghetti', 62, 1001);

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

INSERT INTO user_roles (user_id, role) VALUES
  (1018, 'ROLE_USER'),
  (1017, 'ROLE_USER'),
  (1016, 'ROLE_ADMIN');

INSERT INTO votes (user_id, restaurant_id) VALUES
  (1017, 1001);