CREATE DATABASE vibezone;
\c vibezone;
CREATE TABLE musicians(
 id serial PRIMARY KEY,
 name VARCHAR,
 instrument VARCHAR,
 artistType VARCHAR,
 recordLabelId int
);

CREATE TABLE songs(
 id serial PRIMARY KEY,
title VARCHAR,
genre VARCHAR,
musicianid int
);

CREATE TABLE record_labels(
id serial PRIMARY KEY,
name VARCHAR,
location VARCHAR,
manager VARCHAR
);