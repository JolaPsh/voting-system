DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE GLOBAL_SEQ  START 1000;

CREATE TABLE restaurants (
  id       INTEGER PRIMARY KEY  DEFAULT nextval('global_seq'),
  title    VARCHAR(255) NOT NULL,
  location VARCHAR(255) NOT NULL,
  CONSTRAINT restaurant_title UNIQUE (title)
);

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY  DEFAULT nextval('global_seq'),
  name       VARCHAR(255)            NOT NULL,
  email      VARCHAR(255)            NOT NULL,
  password   VARCHAR(255)            NOT NULL,
  enabled    BOOL DEFAULT TRUE   NOT NULL,
  registered TIMESTAMP DEFAULT now() NOT NULL
);

CREATE UNIQUE INDEX users_unique_email_idx
  ON USERS (email);

CREATE TABLE users_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE
);

CREATE TABLE dishes (
  id            INTEGER PRIMARY KEY  DEFAULT nextval('global_seq'),
  name          VARCHAR(255)            NOT NULL,
  date     DATE DEFAULT now() NOT NULL,
  price         INTEGER                 NOT NULL,
  restaurant_id INTEGER                 NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE votes (
  id            INTEGER PRIMARY KEY  DEFAULT nextval('global_seq'),
  user_id       INTEGER                 NOT NULL,
  restaurant_id INTEGER                 NOT NULL,
  date     DATE DEFAULT now() NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id)
    ON DELETE CASCADE
);