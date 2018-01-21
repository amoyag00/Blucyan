CREATE TABLE Users(
nickname VARCHAR(10) PRIMARY KEY,
pass VARCHAR(20) NOT NULL,
isAdmin BIT NOT NULL,
private BIT NOT NULL
);

CREATE TABLE Lists(
list_id INT AUTO_INCREMENT,
typeList VARCHAR(15) NOT NULL,
nickname VARCHAR(10),
PRIMARY KEY(list_id),
FOREIGN KEY (nickname) REFERENCES Users(nickname) ON DELETE CASCADE,
UNIQUE(typeList,nickname)
);

CREATE TABLE Elements(
element_id INT AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
type_element VARCHAR(15) NOT NULL,
cover VARCHAR(50),
release_date VARCHAR(15),
PRIMARY KEY(element_id)
);

CREATE TABLE Genres(
element_id INT,
genre VARCHAR(50),
PRIMARY KEY(element_id, genre),
FOREIGN KEY(element_id) REFERENCES Elements(element_id) ON DELETE CASCADE
);

CREATE TABLE Videogames(
videogame_id INT,
developer VARCHAR(50),
PRIMARY KEY(videogame_id),
FOREIGN KEY(videogame_id) REFERENCES Elements(element_id) ON DELETE CASCADE
);

CREATE TABLE Platforms(
videogame_id INT,
platform VARCHAR(50),
PRIMARY KEY(videogame_id,platform),
FOREIGN KEY(videogame_id) REFERENCES Videogames(videogame_id) ON DELETE CASCADE
);

CREATE TABLE Comics(
comic_id INT,
number_chapters SMALLINT,
status_comic VARCHAR(20),
PRIMARY KEY(comic_id),
FOREIGN KEY(comic_id) REFERENCES Elements(element_id) ON DELETE CASCADE
);

CREATE TABLE Writers(
comic_id INT,
writer VARCHAR(50),
PRIMARY KEY(comic_id,writer),
FOREIGN KEY (comic_id) REFERENCES Comics(comic_id) ON DELETE CASCADE
);

CREATE TABLE Illustrators(
comic_id INT,
illustrator VARCHAR(50),
PRIMARY KEY(comic_id,illustrator),
FOREIGN KEY (comic_id) REFERENCES Comics(comic_id) ON DELETE CASCADE
);

CREATE TABLE Shows(
show_id INT,
number_episodes SMALLINT,
number_seasons TINYINT,
episode_duration TINYINT,
status_show VARCHAR(20),
PRIMARY KEY(show_id),
FOREIGN KEY(show_id) REFERENCES Elements(element_id) ON DELETE CASCADE
);

CREATE TABLE Producers(
show_id INT,
producer VARCHAR(50),
PRIMARY KEY(show_id, producer),
FOREIGN KEY (show_id) REFERENCES Shows(show_id) ON DELETE CASCADE
);

CREATE TABLE Director(
show_id INT,
director VARCHAR(50),
PRIMARY KEY(show_id, director),
FOREIGN KEY (show_id) REFERENCES Shows(show_id) ON DELETE CASCADE
);

CREATE TABLE Actors(
show_id INT,
actor VARCHAR(50),
PRIMARY KEY(show_id, actor),
FOREIGN KEY (show_id) REFERENCES Shows(show_id) ON DELETE CASCADE
);

CREATE TABLE VideogameEntries(
entry_id INT AUTO_INCREMENT,
videogameList_id INT,
videogame_id INT,
valoration TINYINT,
status_in_list VARCHAR(50),
PRIMARY KEY(entry_id),
UNIQUE(videogameList_id, videogame_id),
FOREIGN KEY(videogameList_id) REFERENCES Lists(list_id)ON DELETE CASCADE,
FOREIGN KEY(videogame_id) REFERENCES Videogames(videogame_id) ON DELETE CASCADE
);

CREATE TABLE ComicEntries(
entry_id INT AUTO_INCREMENT,
comicList_id INT,
comic_id INT,
valoration TINYINT,
status_in_list VARCHAR(20),
number_read_chapters SMALLINT,
PRIMARY KEY(entry_id),
UNIQUE(comicList_id, comic_id),
FOREIGN KEY(comicList_id) REFERENCES Lists(list_id) ON DELETE CASCADE,
FOREIGN KEY(comic_id) REFERENCES Comics(comic_id) ON DELETE CASCADE
);

CREATE TABLE ShowEntries(
entry_id INT AUTO_INCREMENT,
showList_id INT,
show_id INT,
valoration TINYINT,
status_in_list VARCHAR(20),
number_watched_episodes SMALLINT,
PRIMARY KEY(entry_id),
UNIQUE(showList_id, show_id),
FOREIGN KEY(showList_id) REFERENCES Lists(list_id) ON DELETE CASCADE,
FOREIGN KEY(show_id) REFERENCES Shows(show_id) ON DELETE CASCADE
);

CREATE TABLE Reviews(
review_id INT AUTO_INCREMENT,
nickname VARCHAR(10),
element_id INT,
review_text VARCHAR(500),
PRIMARY KEY(review_id),
UNIQUE(nickname, element_id),
FOREIGN KEY (nickname) REFERENCES Users(nickname) ON DELETE CASCADE,
FOREIGN KEY(element_id) REFERENCES Elements(element_id) ON DELETE CASCADE
);







