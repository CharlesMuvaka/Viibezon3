SET MODE PostgreSQL;

CREATE TABLE  IF NOT EXISTS musicians(
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 instrument VARCHAR,
 artistType VARCHAR,
 recordLabelId int,
 genre VARCHAR,
 avatarUrl VARCHAR
);

CREATE TABLE  IF NOT EXISTS songs(
 id int  PRIMARY KEY auto_increment,
title VARCHAR,
genre VARCHAR,
 musicianid int
);

CREATE TABLE  IF NOT EXISTS record_labels(
id int PRIMARY KEY auto_increment,
name VARCHAR,
location VARCHAR,
manager VARCHAR,
avatarUrl VARCHAR
);