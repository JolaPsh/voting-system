/*DELETE FROM votes;
DELETE FROM dishes;*/
/*DELETE FROM users_roles;
DELETE FROM restaurants;*/
DELETE FROM users;

ALTER SEQUENCE global_seq
RESTART WITH 1000;

/*INSERT INTO restaurants (title, location) VALUES
  ('Local', '33 Dark Spurt, Lviv'),
  ('Panorama', '44 Zankoveckoj street, Lviv'),
  ('Kruivka', '11 Mykolaja street, Ternopil'),
  ('Varenuku', '101 Filbert street, Lviv'),
  ('Frontos', '2 Chapel street, Lviv'),
  ('Shekspire', '17 Kosmonavtov street, Lviv'),
  ('Fransua', '44 Lenina street, Lviv');*/
/*
 *  Encrypted passwords(bcrypt algorithm):
 *  herbert --> $2a$10$clfm6bvwKgyWFVG/tcbXh.MpIzd5GNZkJrcjfFrCv9KAxafTrRe7.
 *  admin --> $2a$10$QYqxdmqBdAwjuBMa.opkzufsr4vZCRgRkVRnpI0Pc7BKZVPesxCpS
 *  12345678 --> $2a$10$OUxYxa/tvEZqZikdR57ASuGthGKKKXcaY9O3sj8POVo2BOjTYDrLK
 */
INSERT INTO users (name, email, password) VALUES
  ('Admin', 'admin@gmail.com', '$2a$10$QYqxdmqBdAwjuBMa.opkzufsr4vZCRgRkVRnpI0Pc7BKZVPesxCpS'),
  ('Herbert', 'herbert@gmail.com', '$2a$10$clfm6bvwKgyWFVG/tcbXh.MpIzd5GNZkJrcjfFrCv9KAxafTrRe7.'),
  ('Dominik', 'dominik@gmail.com', '$2a$10$OUxYxa/tvEZqZikdR57ASuGthGKKKXcaY9O3sj8POVo2BOjTYDrLK');

/*INSERT INTO users_roles (user_id, role) VALUES
  (1009, 'ROLE_USER'),
  (1008, 'ROLE_USER'),
  (1007, 'ROLE_ADMIN');*/


/*INSERT INTO dishes (name, price, restaurant_id) VALUES
  ('Calamari', 33, 1000),
  ('Meat balls + Deruny', 112, 1004),
  ('Cabbage rolls', 52, 1002),
  ('Black tea', 10, 1002),
  ('Grape juice', 11, 1004),
  ('Cocoa', 15, 1000),
  ('Omelette', 27, 1002),
  ('Casserole', 72, 1006),
  ('Coffe', 12, 1000),
  ('Fish and chips', 108, 1002),
  ('Mint tea', 25, 1003),
  ('Champagne', 50, 1005),
  ('Pizza', 45, 1002),
  ('French fries', 30, 1001),
  ('Cutlet + spaghetti', 62, 1003);*/

/*INSERT INTO votes (user_id, restaurant_id) VALUES
  (1007, 1001),
  (1008, 1001),
--   (1009, 1002),
  (1007, 1001),
--   (1009, 1006),
  (1008, 1004),
  (1007, 1004);*/