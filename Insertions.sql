#INSERT INTO Users (nickname, pass, isAdmin, private) 
#VALUES ('Terminator', 'skynet5', 0, 0);
#INSERT INTO Users (nickname, pass, isAdmin, private) 
#VALUES ('Altair', 'creed1', 0, 0);

#INSERT INTO Lists
#VALUES (24, 'show', 'Terminator');
#INSERT INTO Lists
#VALUES (25, 'videogame', 'Terminator');
#INSERT INTO Lists
#VALUES (26, 'comic', 'Terminator');

#INSERT INTO Lists
#VALUES (34, 'show', 'Altair');
#INSERT INTO Lists
#VALUES (35, 'videogame', 'Altair');
#INSERT INTO Lists
#VALUES (36, 'comic', 'Altair');

INSERT INTO Comics
VALUES (77, 12, 'in pogress');
INSERT INTO Shows
VALUES (77, 12, 'in pogress');
INSERT INTO Videogames
VALUES (77, 12, 'in pogress');

INSERT INTO ComicLists
VALUES (26, 77, 50, 'in progress', 9);
INSERT INTO ShowLists
VALUES (24, 123, 25, 'finished', 13);
INSERT INTO VideogameLists
VALUES (25, 345, 34, 'played');

#SELECT count(nickname) FROM Users WHERE nickname='Altair';
#SELECT nickname FROM Users  WHERE nickname LIKE '%ta%'; 