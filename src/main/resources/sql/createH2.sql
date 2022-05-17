SET MODE PostgreSQL;

CREATE TABLE  IF NOT EXISTS musicians(
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 instrument VARCHAR,
 artistType VARCHAR,
 recordLabelId int,
 genre VARCHAR
);

CREATE TABLE  IF NOT EXISTS song(
 id int  PRIMARY KEY auto_increment,
title VARCHAR,
genre VARCHAR,
musicianId int
);

CREATE TABLE  IF NOT EXISTS recordLabel(
id int PRIMARY KEY auto_increment,
name VARCHAR,
location VARCHAR,
manager VARCHAR
);