SHOW DATABASES;
# DROP DATABASE course_project;

CREATE DATABASE course_project;
use course_project;

CREATE TABLE authors (
  id_author  INT(10) AUTO_INCREMENT,
  author_name VARCHAR(20) NOT NULL,
  date_birth INT(20)     NOT NULL,
  country    VARCHAR(20) NOT NULL,
  PRIMARY KEY (id_author)
);

CREATE TABLE books (
id_book   INT(10) AUTO_INCREMENT,
name      VARCHAR(20) NOT NULL,
ganr      VARCHAR(20) NOT NULL,
pages     INT(4)NOT NULL ,
id_author INT(10)NOT NULL ,
book_count INT (4)NOT NULL ,
PRIMARY KEY (id_book),
FOREIGN KEY (id_author) REFERENCES authors (id_author)
);

CREATE TABLE roles(
  id_role  ENUM ('0','1')NOT NULL ,
  role ENUM ('reader', 'admin')NOT NULL ,
  PRIMARY KEY (id_role)
);


CREATE TABLE users(
  id_user int (5) NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL ,
  LOGIN VARCHAR(20) NOT NULL,
  PASSWORD VARCHAR(25) NOT NULL,
  age INT (3) NOT NULL ,
  sex ENUM ('male', 'female') NOT NULL ,
  id_role  ENUM ('0','1') NOT NULL ,
  PRIMARY KEY (id_user),
  FOREIGN KEY (id_role) REFERENCES roles (id_role)
);
CREATE UNIQUE INDEX USER_LOGIN_uindex ON USERS (LOGIN);

CREATE TABLE formular(
  id_formular INT (5)NOT NULL AUTO_INCREMENT,
  id_user INT (5) NOT NULL ,
  id_book INT (10) NOT NULL ,
  book_count INT (3) NOT NULL ,
  PRIMARY KEY (id_formular),
  FOREIGN KEY (id_user) REFERENCES users (id_user),
  FOREIGN KEY (id_book) REFERENCES books (id_book)
);

CREATE TABLE ITEM
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  id_formular INT(5) NOT NULL,
  books_count int (3) NOT NULL,
  CONSTRAINT Order_fk FOREIGN KEY (id_formular) REFERENCES `formular` (id_formular) ON DELETE CASCADE
);