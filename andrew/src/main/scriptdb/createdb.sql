-- Create db andrewdb
DROP SCHEMA IF EXISTS `andrewdb` ;
CREATE SCHEMA IF NOT EXISTS `andrewdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `andrewdb` ;

-- Create BOOK table
DROP TABLE IF EXISTS 'andrewdb.book';

CREATE TABLE IF NOT EXISTS BOOK(
   id serial,
   name             TEXT    NOT NULL,
   ISBN             CHAR(50),
   Issue_Date       CHAR(50),
   Category_Name    CHAR(50),
   price            REAL,
   PRIMARY KEY(id)
);

-- Init record into BOOK table
INSERT into BOOK(name, ISBN, Issue_Date, Category_Name, price)
VALUES('Mathematics', '0-306-40615-2', '12/12/2012', 'MTHS1', 39.9);
INSERT into BOOK(name, ISBN, Issue_Date, Category_Name, price)
VALUES('Mathematics 2', '0-306-40615-5', '12/12/2014', 'MTHS2', 39.9);
INSERT into BOOK(name, ISBN, Issue_Date, Category_Name, price)
VALUES('Mathematics 3', '0-306-40615-9', '12/12/2015', 'MTHS3', 39.9);

-- Create AUTHOR table
CREATE TABLE IF NOT EXISTS AUTHOR (
  id serial,
  name VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
);

-- Init record into AUTHOR table
INSERT into AUTHOR(name)
VALUES('Andrew');
INSERT into AUTHOR(name)
VALUES('Taylor');

/*
 many to many
*/

CREATE TABLE IF NOT EXISTS AUTHORS_BOOKS (
  author_id int NOT NULL,
  book_id int NOT NULL,
  FOREIGN KEY (author_id) REFERENCES AUTHOR(id) ON UPDATE CASCADE,
  FOREIGN KEY (book_id) REFERENCES BOOK(id) ON UPDATE CASCADE
);

INSERT into AUTHORS_BOOKS
VALUES(1,1);
INSERT into AUTHORS_BOOKS
VALUES(1,2);
INSERT into AUTHORS_BOOKS
VALUES(2,3);
INSERT into AUTHORS_BOOKS
VALUES(1,3);


