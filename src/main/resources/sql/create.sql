CREATE DATABASE vibezone;
\c vibezone;
CREATE TABLE musicians(
 id serial PRIMARY KEY,
 name VARCHAR,
 instrument VARCHAR,
 artistType VARCHAR,
 recordLabelId int
);

CREATE TABLE song(
 id serial PRIMARY KEY,
title VARCHAR,
genre VARCHAR,
musicianId int
);

CREATE TABLE recordLabel(
id serial PRIMARY KEY,
name VARCHAR,
location VARCHAR,
manager VARCHAR
);