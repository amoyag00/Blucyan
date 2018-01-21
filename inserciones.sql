INSERT INTO Users (nickname, pass, isAdmin, private) 
VALUES ('Terminator', 'skynet5', 0, 0);

INSERT INTO Users (nickname, pass, isAdmin, private) 
VALUES ('Altair', 'creed1', 0, 0);

INSERT INTO Lists(typeList, nickname)
VALUES ('show', 'Terminator');

INSERT INTO Lists(typeList, nickname)
VALUES ('videogame', 'Terminator');

INSERT INTO Lists(typeList, nickname)
VALUES ('comic', 'Terminator');

INSERT INTO Lists(typeList, nickname)
VALUES ('show', 'Altair');

INSERT INTO Lists(typeList, nickname)
VALUES ( 'videogame', 'Altair');

INSERT INTO Lists(typeList, nickname)
VALUES ( 'comic', 'Altair');

INSERT INTO Elements(name,type_element,release_date, description)
VALUES ('Dark Souls', 'videogame','2011-10-04','Dark Souls is an action role-playing video game developed by FromSoftware and published by Namco Bandai Games for PlayStation 3, Xbox 360, and Microsoft Windows. A spiritual successor to FromSoftwares Demon Souls, it is the second installment in the Souls series of games. The game was self-published and released in Japan in September 2011, and worldwide by Namco Bandai Games the following month.');

INSERT INTO Videogames
VALUES(1,'From Software');

INSERT INTO Elements(name,type_element,release_date)
VALUES('Breaking Bad', 'Show','2008-01-20');

INSERT INTO Shows
VALUES (last_insert_id(),62,5,40,'completed');
INSERT INTO Reviews(nickname, element_id,review_text)
VALUES ('Altair', 1, 'Best game I have every played!');


INSERT INTO Elements(name, type_element,release_date)
VALUES('Dragon Ball', 'Comic','1984-12-03');

INSERT INTO Comics
VALUES(last_insert_id(),519,'finished');



INSERT INTO ShowEntries(showList_id, show_id, valoration, status_in_list, number_watched_episodes)
VALUES(4,2,67,'planned to watch', 30);

INSERT INTO ComicEntries(comicList_id, comic_id, valoration, status_in_list, number_read_chapters)
VALUES(6,3, 50,'on progress',300);

INSERT INTO Elements(name,type_element,release_date)
VALUES ('Super Mario Bros.', 'videogame','1985-09-13');

INSERT INTO Videogames
VALUES(last_insert_id(),'Nintendo');

INSERT INTO VideogameEntries(videogameList_id, videogame_id, valoration, status_in_list)
VALUES(5,1,100,'completed');

