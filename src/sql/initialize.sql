CREATE DATABASE clicker;

USE clicker;

DROP TABLE IF EXISTS credentials;
CREATE TABLE credentials (
    id          INT AUTO_INCREMENT UNIQUE ,
    username    VARCHAR(30) UNIQUE,
    password    VARCHAR(30),
    is_admin    BOOLEAN,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS questions;
CREATE TABLE IF NOT EXISTS questions (
    id          INT AUTO_INCREMENT UNIQUE ,
    question    VARCHAR(150),
    choiceA     VARCHAR(150),
    choiceB     VARCHAR(150),
    choiceC     VARCHAR(150),
    choiceD     VARCHAR(150),
    answer      VARCHAR(1),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS choices;
CREATE TABLE choices (
    id              INT AUTO_INCREMENT,
    user_id         INT,
    choice          VARCHAR(1),
    q_no            INT,
    PRIMARY KEY (id)
);

