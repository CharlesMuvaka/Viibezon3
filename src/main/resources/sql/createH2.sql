SET MODE PostgreSQL;

CREATE TABLE musicians(
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 instrument VARCHAR,
 artistType VARCHAR,
 recordLabelId int,
 genre VARCHAR
);

CREATE TABLE song(
 id int  PRIMARY KEY auto_increment,
title VARCHAR,
genre VARCHAR,
musicianId int
);

CREATE TABLE recordLabel(
id int PRIMARY KEY auto_increment,
name VARCHAR,
location VARCHAR,
manager VARCHAR
);