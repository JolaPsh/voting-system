DROP TABLE votes IF EXISTS; 
DROP TABLE dishes IF EXISTS;
DROP TABLE restaurants IF EXISTS;
DROP TABLE user_roles IF EXISTS;
DROP TABLE users IF EXISTS;

DROP SEQUENCE GLOBAL_SEQ IF EXISTS;

CREATE SEQUENCE GLOBAL_SEQ AS INTEGER START WITH 1000;

CREATE TABLE users(
  id         INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name       VARCHAR(255)           NOT NULL,
  email      VARCHAR(255)           NOT NULL,
  password   VARCHAR(255)           NOT NULL,
  enabled    BOOLEAN DEFAULT TRUE   NOT NULL,
  registered DATE DEFAULT now()     NOT NULL
);

CREATE UNIQUE INDEX users_unique_email_idx
  ON USERS (email);

CREATE TABLE user_roles(
  user_id INTEGER NOT NULL,
  role    VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE restaurants (
  id       INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  title    VARCHAR(255) NOT NULL,
  location VARCHAR(255) NOT NULL,
  CONSTRAINT restaurant_title_idx UNIQUE (title)
);

CREATE TABLE dishes (
  id            INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name          VARCHAR(255)       NOT NULL,
  date          TIMESTAMP DEFAULT now() NOT NULL,
  price         INTEGER            NOT NULL,
  restaurant_id INTEGER            NOT NULL,
  CONSTRAINT dish_name_idx UNIQUE (name),
  FOREIGN KEY (restaurant_id) REFERENCES RESTAURANTS (id) ON DELETE CASCADE
  );

CREATE TABLE votes (
  id            INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  user_id       INTEGER            NOT NULL,
  restaurant_id INTEGER            NOT NULL,
  date          DATE DEFAULT now() NOT NULL,
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE,
  FOREIGN KEY (restaurant_id) REFERENCES RESTAURANTS (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX user_unique_vote_idx ON VOTES (user_id, date);

