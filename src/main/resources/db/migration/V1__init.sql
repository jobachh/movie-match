CREATE TABLE recommendation
(
    rec_id BIGINT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT
);
CREATE TABLE viewer
(
    rec_id BIGINT(11) NOT NULL,
    viewer_number INT(11) NOT NULL,
    name VARCHAR(75),
    CONSTRAINT `PRIMARY` PRIMARY KEY (rec_id, viewer_number)
);
CREATE TABLE genre
(
    genre_id BIGINT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(75)
);
CREATE TABLE viewers_genres
(
    rec_id BIGINT(11) NOT NULL,
    viewer_number INT(11) NOT NULL,
    genre_id BIGINT(11) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (rec_id, viewer_number, genre_id)
);
CREATE TABLE movie
(
    movie_id BIGINT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    year INT(11),
    description TEXT,
    image_url VARCHAR(512),
    trailer_url VARCHAR(512),
    rating FLOAT
);
CREATE TABLE movies_genres
(
    movie_id BIGINT(11) NOT NULL,
    genre_id BIGINT(11) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (movie_id, genre_id)
);
CREATE TABLE viewers_movies
(
    rec_id BIGINT(11) NOT NULL,
    viewer_number INT(11) NOT NULL,
    movie_id BIGINT(11) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (rec_id, viewer_number, movie_id)
);