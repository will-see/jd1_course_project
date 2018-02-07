SHOW DATABASES;
# DROP DATABASE course_project;

CREATE DATABASE course_project;
USE course_project;

CREATE TABLE authors (
  id_author   INT(10) AUTO_INCREMENT,
  author_name VARCHAR(20) NOT NULL,
  date_birth  INT(20)     NOT NULL,
  country     VARCHAR(20) NOT NULL,
  PRIMARY KEY (id_author)
);

CREATE TABLE books (
  bookId     INT(10) AUTO_INCREMENT,
  name       VARCHAR(20) NOT NULL,
  ganr       VARCHAR(20) NOT NULL,
  pages      INT(4)      NOT NULL,
  authorId   INT(10)     NOT NULL,
  book_count INT(4)      NOT NULL,
  PRIMARY KEY (bookId),
  FOREIGN KEY (authorId) REFERENCES authors (id_author)
);

CREATE TABLE roles (
  id_role ENUM ('0', '1')          NOT NULL,
  role    ENUM ('reader', 'admin') NOT NULL,
  PRIMARY KEY (id_role)
);


CREATE TABLE users (
  userId   INT(5)                  NOT NULL AUTO_INCREMENT,
  name     VARCHAR(20)             NOT NULL,
  LOGIN    VARCHAR(20)             NOT NULL,
  PASSWORD VARCHAR(25)             NOT NULL,
  age      INT(3)                  NOT NULL,
  sex      ENUM ('male', 'female') NOT NULL,
  id_role  ENUM ('0', '1')         NOT NULL,
  PRIMARY KEY (userId),
  FOREIGN KEY (id_role) REFERENCES roles (id_role)
);
CREATE UNIQUE INDEX USER_LOGIN_uindex
  ON USERS (LOGIN);

CREATE TABLE formular (
  formularId INT(5)  NOT NULL AUTO_INCREMENT,
  userId  INT(5)  NOT NULL,
  bookId  INT(10) NOT NULL,
  PRIMARY KEY (formularId),
  FOREIGN KEY (userId) REFERENCES users (userId)
  #   FOREIGN KEY (bookId) REFERENCES books (bookId)
);

# DROP TABLE ITEM;
CREATE TABLE ITEM (
  ID      INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  formularId INT(5)          NOT NULL,
  bookId INT(5)          NOT NULL,
  CONSTRAINT Book_fk FOREIGN KEY (bookId) REFERENCES books (bookId),
  CONSTRAINT Order_fk FOREIGN KEY (formularId) REFERENCES formular (formularId)
    ON DELETE CASCADE
);


INSERT INTO authors (author_name, date_birth, country) VALUES ('pushkin', '1900', 'russia');
INSERT INTO authors (author_name, date_birth, country) VALUES ('lermontov', '1800', 'russia');
INSERT INTO authors (author_name, date_birth, country) VALUES ('bykov', '1850', 'belarus');
INSERT INTO authors (author_name, date_birth, country) VALUES ('kolos', '1950', 'belarus');
INSERT INTO authors (author_name, date_birth, country) VALUES ('esenin', '1900', 'russia');


INSERT INTO books (name, ganr, pages, authorId, book_count) VALUES ('book1', 'ganr1', '100', '1', '10');
INSERT INTO books (name, ganr, pages, authorId, book_count) VALUES ('book2', 'ganr2', '200', '2', '20');
INSERT INTO books (name, ganr, pages, authorId, book_count) VALUES ('book3', 'ganr3', '300', '3', '30');
INSERT INTO books (name, ganr, pages, authorId, book_count) VALUES ('book4', 'ganr4', '400', '4', '40');
INSERT INTO books (name, ganr, pages, authorId, book_count) VALUES ('book5', 'ganr5', '500', '5', '50');
INSERT INTO books (name, ganr, pages, authorId, book_count) VALUES ('book6', 'ganr6', '600', '1', '60');
INSERT INTO books (name, ganr, pages, authorId, book_count) VALUES ('book7', 'ganr7', '700', '2', '70');
INSERT INTO books (name, ganr, pages, authorId, book_count) VALUES ('book8', 'ganr8', '800', '3', '80');
INSERT INTO books (name, ganr, pages, authorId, book_count) VALUES ('book9', 'ganr9', '900', '4', '90');
INSERT INTO books (name, ganr, pages, authorId, book_count) VALUES ('book10', 'ganr10', '1000', '5', '100');

INSERT INTO roles (id_role, role) VALUES ('0', 'reader');
INSERT INTO roles (id_role, role) VALUES ('1', 'admin');

# SELECT *FROM roles;

INSERT INTO users (name, LOGIN, PASSWORD, age, sex, id_role) VALUES ('valera', 'admin', 'admin', '20', 'male', '1');
INSERT INTO users (name, LOGIN, PASSWORD, age, sex, id_role) VALUES ('petia', 'user1', 'user', '22', 'male', '0');
INSERT INTO users (name, LOGIN, PASSWORD, age, sex, id_role) VALUES ('vasia', 'user2', 'user', '25', 'male', '0');

INSERT INTO formular (userId, bookId) VALUES ('2', '1');
INSERT INTO formular (userId, bookId) VALUES ('2', '2');

SELECT *FROM formular;