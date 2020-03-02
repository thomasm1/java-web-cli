
--This is a comment. Uses the double dash '--'
-- SQL is NOT case sensitive. Note though, a lot of SQL keywords
-- are commonly written in UPPERCASE.
-- SELECT == select = SeLeCt
-- SQL is a scripting language. We do not have to compile it.
-- SQL is a query language. Which means I can run independent chunks
-- of code.

-- DDL statement
DROP TABLE pokemon;

-- DDL statements autocommit.
CREATE TABLE pokemon ( 
    p_id NUMBER(10),
    name VARCHAR2(20),
    type VARCHAR2(50),
    bio VARCHAR2(500),
    lvl NUMBER(10),
    shiny NUMBER(1));
    
SELECT * FROM pokemon;

-- DML which does not autocommit.
INSERT INTO pokemon VALUES (1, 'Bulbasaur', 'Grass/Poison', 'The first Pokemon', 5, 0);
INSERT INTO pokemon VALUES (111, 'Mudkip', 'Water', 'He cute pokemanz', 5, 1);
INSERT INTO pokemon VALUES (151, 'Mew', 'Psychic', 'The first legendary', 35, 0);
INSERT INTO pokemon VALUES (69, 'Exeggcute', 'Grass/Psychic', 'This Pokémon consists of six eggs that form a closely knit cluster. The six eggs attract each other and spin around. When cracks increasingly appear on the eggs, Exeggcute is close to evolution.', 5, 0);
INSERT INTO pokemon VALUES (150, 'Mewtwo', 'Psychic', 'Genetic Pokemon', 9, 1);
INSERT INTO pokemon VALUES (7, 'Aipom', 'Normal', 'Three handed monkey', 100, 0);
INSERT INTO pokemon VALUES (2, 'Charmander', 'Fire', 'It breathes fire.', 6, 0);
INSERT INTO pokemon VALUES (11, 'Zubat', 'Flying/Poison', 'bat thing', 5, 1);
INSERT INTO pokemon VALUES (8, 'Raichu', 'Electric', 'The Originals', 1, 1);
INSERT INTO pokemon VALUES (25,'Hitmonchan','Fighting','Steroids are strong with this one',100,1);
INSERT INTO pokemon VALUES (106, 'Hitmonleee', 'Fighting', 'The kicking fiend', 23, 0);
INSERT INTO pokemon VALUES (99,'Charizard', 'Fire', 'https://bulbapedia.bulbagarden.net/wiki/File:006Charizard.png', 10,0);

commit;
rollback;

-- To remove records from a table you have options
-- DELETE removes data from a table. Does not remove the table.

-- DML, manipulating the data in the table
DELETE pokemon;
commit;

DELETE pokemon WHERE lvl > 10;
DELETE pokemon WHERE p_id NOT BETWEEN 50 AND 125;

-- Truncate Table performs the same action as DELETE

-- This is DDL, why?
TRUNCATE TABLE pokemon;

SELECT name,lvl FROM pokemon;

SELECT p_id,name,lvl FROM pokemon WHERE lvl >= 10;
SELECT p_id,name,lvl FROM pokemon WHERE name = 'Aipom';
--For fun
SELECT p_id,name,lvl FROM pokemon WHERE REGEXP_LIKE (name, '^[A-C]+');

--Aliases
SELECT p.name,p.lvl FROM pokemon p WHERE p.name = 'Aipom';

-- DML, not autocommited.
UPDATE pokemon SET lvl = 100 WHERE p_id > 50;
commit;


-- Aggregate function is going to calculate some value using multiple
-- records
-- AVG, MAX, MIN, SUM, COUNT

SELECT MAX(lvl), MIN(p_id) FROM pokemon;

SELECT COUNT(shiny) FROM pokemon WHERE shiny = 1;

-- GROUP BY is used with aggregate functions to break records into
-- groups/buckets

SELECT type,COUNT(type),ROUND(AVG(lvl), 0) FROM pokemon GROUP BY type;
SELECT lvl,COUNT(lvl) FROM pokemon GROUP BY lvl;
SELECT MOD(p_id,5),AVG(lvl),COUNT(p_id) FROM pokemon GROUP BY MOD(p_id,5);


-- HAVING is an extra clause we use with GROUP BY becuase Oracle wont
-- let you use WHERE. WHERE filters out records to return, but GROUP BY
-- doesn't return records.

SELECT type,COUNT(type),AVG(lvl) FROM pokemon GROUP BY type HAVING type LIKE 'F%';
SELECT type,COUNT(type),AVG(lvl) FROM pokemon GROUP BY type HAVING type LIKE '%c';


-- ORDER BY only changes the way in which the table is displayed.
-- Not what records you return;

SELECT p_id,name,lvl FROM pokemon ORDER BY name;
SELECT p_id,name,lvl FROM pokemon ORDER BY lvl desc;

SELECT type,COUNT(type),AVG(lvl) FROM pokemon GROUP BY type ORDER BY AVG(p_id);

--Subqueries
SELECT * FROM pokemon WHERE lvl = (SELECT MIN(lvl) FROM pokemon);
UPDATE pokemon SET lvl = 50 WHERE lvl = (SELECT MIN(lvl) FROM pokemon);


SELECT * FROM (SELECT p_id,name,lvl FROM pokemon ORDER BY lvl desc) WHERE ROWNUM <= 6;

-- Not the same
SELECT p_id,name,lvl FROM pokemon WHERE ROWNUM <=6 ORDER BY lvl desc;