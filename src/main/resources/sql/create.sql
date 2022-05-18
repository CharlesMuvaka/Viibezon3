CREATE DATABASE vibezone;
\c vibezone;
CREATE TABLE musicians(
 id serial PRIMARY KEY,
 name VARCHAR,
 instrument VARCHAR,
 artistType VARCHAR,
 recordLabelId int,
 avatarUrl VARCHAR,
 genre VARCHAR
);

INSERT INTO musicians(name, instrument, artistType, recordLabelId, avatarUrl, genre) VALUES('Levi Dunk','Violin','Vocalist', 1, '/images/lack.webp','GengeTone');
INSERT INTO musicians(name, instrument, artistType, recordLabelId, avatarUrl, genre) VALUES('KoKoKolinko','Drums','Dancer' ,  4 ,'/images/darmian2.jpeg','Jazz');
INSERT INTO musicians(name, instrument, artistType, recordLabelId, avatarUrl, genre) VALUES('Knives Katana','Guitar','Guitarist', 2,'/images/shans.jpg','Country Music' );
INSERT INTO musicians(name, instrument, artistType, recordLabelId, avatarUrl, genre) VALUES('Muvkin Kid', 'Trumpets', 'Vocalist', 3, '/images/jj.jpeg', 'Electronic Dance Music');

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
manager VARCHAR,
avatarUrl VARCHAR
);

INSERT INTO record_labels(name, location, manager, avatarUrl ) VALUES('Black Market Record', 'Nepal', 'Levi Opunga', '/images/label3.png');
INSERT INTO record_labels(name, location, manager, avatarUrl ) VALUES('Sony Entertainment', 'Umoja ', 'Collins Odinga', '/images/img5.webp');
INSERT INTO record_labels(name, location, manager, avatarUrl ) VALUES('Blue Inc Corp', 'Lagos', 'Joan Ndeng', '/images/label6.jpeg');
INSERT INTO record_labels(name, location, manager, avatarUrl ) VALUES('After-Math', 'Berlin', 'Muvkin', '/images/stud1.jpeg');