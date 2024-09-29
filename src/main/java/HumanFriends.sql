CREATE DATABASE IF NOT EXISTS HumanFriends;
USE HumanFriends;

CREATE TABLE clases(
Id INT PRIMARY KEY AUTO_INCREMENT,
name_class VARCHAR(30)
);

CREATE TABLE pets(
Id INT PRIMARY KEY AUTO_INCREMENT,
type_of_pet VARCHAR(30),
clases_id INT,
FOREIGN KEY (clases_id) REFERENCES clases (Id)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE pack_animals(
	Id INT PRIMARY KEY AUTO_INCREMENT,
	type_of_pack_animals VARCHAR(30),
	clases_id INT,
	FOREIGN KEY (clases_id) REFERENCES clases (Id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE dogs(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(30),
    commands VARCHAR(40),
    birthday DATE,
    family_id INT,
    FOREIGN KEY (family_id) REFERENCES pets (Id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE cats(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(30),
    commands VARCHAR(40),
    birthday DATE,
    family_id INT,
    FOREIGN KEY (family_id) REFERENCES pets (Id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE hamsters(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(30),
    commands VARCHAR(40),
    birthday DATE,
    family_id INT,
    FOREIGN KEY (family_id) REFERENCES pets (Id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE horses(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(30),
    commands VARCHAR(40),
    birthday DATE,
    family_id INT,
    FOREIGN KEY (family_id) REFERENCES pack_animals (Id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE camels(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(30),
    commands VARCHAR(40),
    birthday DATE,
    family_id INT,
    FOREIGN KEY (family_id) REFERENCES pack_animals (Id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE donkeys(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(30),
    commands VARCHAR(40),
    birthday DATE,
    family_id INT,
    FOREIGN KEY (family_id) REFERENCES pack_animals (Id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO clases (name_class)
VALUES ("домашние"),
("вьючные");

INSERT INTO pets (type_of_pet, clases_id)
VALUES ("собаки", 1),
("кошки", 1),
("хомяки", 1);

INSERT INTO pack_animals (type_of_pack_animals, clases_id)
VALUES ("лошади", 2),
("верблюды", 2),
("ослы", 2);

INSERT INTO dogs (nickname, commands, birthday, family_id)
VALUES ("Шарик", "сидеть лежать", "2020-10-16", 1),
("Барбос", "голос фу", "2015-03-12", 1),
("Лекс", "не обучен", "2024-01-24", 1);

INSERT INTO cats (nickname, commands, birthday, family_id)
VALUES ("Кузя", "играть", "2022-09-23", 2),
("Маркиз", "нельзя", "2018-02-05", 2),
("Рыжик", "прыжок", "2021-10-30", 2);

INSERT INTO hamsters (nickname, commands, birthday, family_id)
VALUES ("Пушок", NULL, "2023-10-23", 3),
("Чип", NULL, "2024-03-15", 3),
("Рокфор", NULL, "2024-06-22", 3);

INSERT INTO horses (nickname, commands, birthday, family_id)
VALUES ("Стелла", "вперед стой", "2021-09-13", 1),
("Гнедой", "вперед стой хоп", "2017-12-25", 1),
("Черныш", "вперед стой рысь", "2020-11-28", 1);

INSERT INTO camels (nickname, commands, birthday, family_id)
VALUES ("Кинг", "гит дурр каш", "2018-07-13", 2),
("Сахара", "кхх гит дур каш", "2016-04-08", 2),
("Бархан", "хап цок гит дурр", "2015-07-19", 2);

INSERT INTO donkeys (nickname, commands, birthday, family_id)
VALUES ("Иа-Иа", NULL, "2015-09-23", 3),
("Буритто", NULL, "2019-03-02", 3),
("Пончо", NULL, "2017-06-11", 3);

TRUNCATE TABLE camels;

CREATE TABLE horses_donkeys(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(30),
    commands VARCHAR(40),
    birthday DATE,
    family_id INT,
	FOREIGN KEY (family_id) REFERENCES pack_animals (Id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO horses_donkeys (nickname, commands, birthday, family_id)
SELECT nickname, commands, birthday, family_id
FROM horses
UNION ALL SELECT nickname, commands, birthday, family_id
FROM donkeys
ORDER BY family_id;

CREATE TEMPORARY TABLE all_animals AS
SELECT nickname, birthday,'собака' AS family FROM dogs
UNION SELECT nickname, birthday, 'кошка' AS family FROM cats
UNION SELECT nickname, birthday, 'хомяк' AS family FROM hamsters
UNION SELECT nickname, birthday, 'лошадь' AS family FROM horses
UNION SELECT nickname, birthday, 'осёл' AS family FROM donkeys;

CREATE TABLE young_animals AS
SELECT nickname, birthday, family, TIMESTAMPDIFF(MONTH, birthday, CURDATE()) AS score_months
FROM all_animals WHERE birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);

CREATE TABLE animals (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY) AS
SELECT nickname, commands, birthday,'dogs' AS _table FROM dogs
UNION SELECT nickname, commands, birthday, 'cats' AS _table FROM cats
UNION SELECT nickname, commands, birthday, 'hamsters' AS _table FROM hamsters
UNION SELECT nickname, commands, birthday, 'horses' AS _table FROM horses
UNION SELECT nickname, commands, birthday, 'donkeys' AS _table FROM donkeys;

SELECT * FROM animals;