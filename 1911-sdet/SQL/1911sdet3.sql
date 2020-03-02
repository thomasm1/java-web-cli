
INSERT INTO pokemon VALUES (id_maker.nextval, 'Bulbasaur', 'The first Pokemon');
INSERT INTO pokemon VALUES (id_maker.nextval, 'Mudkip', 'He cute pokemanz');
INSERT INTO pokemon VALUES (id_maker.nextval, 'Mew', 'The first legendary');
INSERT INTO pokemon VALUES (id_maker.nextval, 'Exeggcute', 'This Pokémon consists of six eggs that form a closely knit cluster. The six eggs attract each other and spin around. When cracks increasingly appear on the eggs, Exeggcute is close to evolution.');
INSERT INTO pokemon VALUES (id_maker.nextval, 'Mewtwo', 'Genetic Pokemon');
INSERT INTO pokemon VALUES (id_maker.nextval, 'Aipom', 'Three handed monkey');
INSERT INTO pokemon VALUES (id_maker.nextval, 'Charmander', 'It breathes fire.');
INSERT INTO pokemon VALUES (id_maker.nextval, 'Zubat', 'bat thing');
INSERT INTO pokemon VALUES (id_maker.nextval, 'Raichu', 'The Originals');
INSERT INTO pokemon VALUES (id_maker.nextval,'Hitmonchan','Steroids are strong with this one');
INSERT INTO pokemon VALUES (id_maker.nextval, 'Hitmonleee', 'The kicking fiend');
INSERT INTO pokemon VALUES (id_maker.nextval,'Charizard', 'https://bulbapedia.bulbagarden.net/wiki/File:006Charizard.png');
commit;

SELECT * FROM pokemon;

-- Sequence is an SQL Object which will generate a unique number.
-- We will use sequences in place of AUTO_INCREMENT
DROP SEQUENCE id_maker;
CREATE SEQUENCE id_maker
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;



INSERT INTO ptype VALUES(id_maker.nextval, 'Grass');
INSERT INTO ptype VALUES(id_maker.nextval, 'Water');
INSERT INTO ptype VALUES(id_maker.nextval, 'Fire');
INSERT INTO ptype VALUES(id_maker.nextval, 'Electric');
INSERT INTO ptype VALUES(id_maker.nextval, 'Dragon');
INSERT INTO ptype VALUES(id_maker.nextval, 'Ice');
INSERT INTO ptype VALUES(id_maker.nextval, 'Dark');
INSERT INTO ptype VALUES(id_maker.nextval, 'Normal');
INSERT INTO ptype VALUES(id_maker.nextval, 'Psychic');
INSERT INTO ptype VALUES(id_maker.nextval, 'Fairy');
INSERT INTO ptype VALUES(id_maker.nextval, 'Bug');
INSERT INTO ptype VALUES(id_maker.nextval, 'Steel');
INSERT INTO ptype VALUES(id_maker.nextval, 'Rock');
INSERT INTO ptype VALUES(id_maker.nextval, 'Ground');
INSERT INTO ptype VALUES(id_maker.nextval, 'Fighting');
INSERT INTO ptype VALUES(id_maker.nextval, 'Flying');
INSERT INTO ptype VALUES(id_maker.nextval, 'Poison');
INSERT INTO ptype VALUES(id_maker.nextval, 'Ghost');
commit;

SELECT * FROM pokemon;
SELECT * FROM ptype;


-- Procedure is just a set of SQL commands
-- essentially a script
-- Have 0 to Many inputs
-- Have 0 to Many outputs
-- Can manipulate data in the database.
CREATE OR REPLACE PROCEDURE add_pokemon(name VARCHAR2, bio VARCHAR2, t_id1 NUMBER, t_id2 NUMBER)
IS
BEGIN
INSERT INTO pokemon VALUES (id_maker.nextval, name, bio);
INSERT INTO stats VALUES (id_maker.currval,1,5,5,5,0);
INSERT INTO pokemon_type VALUES (id_maker.currval, t_id1);
IF t_id2 != -1
THEN
    INSERT INTO pokemon_type VALUES (id_maker.currval, t_id2);
END IF;
END;


CREATE OR REPLACE PROCEDURE add_pokemon2(name VARCHAR2, bio VARCHAR2, type1 VARCHAR2, type2 VARCHAR2)
IS
BEGIN
INSERT INTO pokemon VALUES (id_maker.nextval, name, bio);
INSERT INTO stats VALUES (id_maker.currval,1,5,5,5,0);
INSERT INTO pokemon_type VALUES (id_maker.currval, (SELECT t_id FROM ptype WHERE type = type1 AND ROWNUM = 1));
IF type2 IS NOT NULL
THEN
    INSERT INTO pokemon_type VALUES (id_maker.currval, (SELECT t_id FROM ptype WHERE type = type2 AND ROWNUM = 1));
END IF;
commit;
END;

CALL add_pokemon('Eevee','The cutest pokemon',38, -1);
CALL add_pokemon('Pidgey','The bird pokemon',38,46);

CALL add_pokemon2('Ivysaur','The second pokemon','Grass','Poison');
CALL add_pokemon2('Goldeen','The goldfish pokemon','Water',null);


SELECT * FROM pokemon ORDER BY p_id desc;
SELECT * FROM stats ORDER BY p_id desc;
SELECT * FROM pokemon_type ORDER BY p_id desc;


-- A Function does not change values in a table
-- it MUST have inputs and EXACTLY 1 output. - 1 to Many inputs

CREATE OR REPLACE FUNCTION combat_power(hp NUMBER, atk NUMBER, def NUMBER) RETURN NUMBER
IS
BEGIN

RETURN hp + atk + def;

END;

CREATE OR REPLACE PROCEDURE level_up(p_idn NUMBER, hpn NUMBER, atk NUMBER, def NUMBER)
IS
BEGIN
    UPDATE stats SET lvl = lvl + 1, hp = hp + hpn, attack = attack + atk, defense = defense + def
    --,cp = combat_power(hp + hpn, attack + atk, defense + def) 
    WHERE p_id = p_idn;
END;

SELECT * FROM pokemon;
SELECT * FROM stats;
SELECT * FROM pokemon ORDER BY p_id desc;

CALL level_up(62, 2, 1, 3);
CALL level_up(63, 1, 3, 2);
CALL level_up(64, 2, 2, 2);

SELECT * FROM stats WHERE combat_power(hp,attack,defense) = 39;


-----------------------------

--Triggers are an Object that listens
--for an event to occur and executes when it does.


CREATE TABLE archived_pokemon (
    p_id NUMBER(10) PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    bio VARCHAR2(200));
    
CREATE OR REPLACE TRIGGER archive_pokemon
BEFORE DELETE ON pokemon
FOR EACH ROW
BEGIN
    INSERT INTO archived_pokemon VALUES(:old.p_id, :old.name, :old.bio);
--    DELETE stats WHERE p_id = :old.p_id;
END;

CALL add_pokemon2('MissingNo', '???????????????', 'Normal','Flying');


SELECT * FROM pokemon ORDER BY p_id desc;
SELECT * FROM stats ORDER BY p_id desc;
SELECT * FROM pokemon_type ORDER BY p_id desc;
SELECT * FROM archived_pokemon;

DELETE pokemon WHERE name = 'MissingNo';

CREATE OR REPLACE PROCEDURE unarchive_pokemon(poke_name VARCHAR2, bio VARCHAR2, type1 VARCHAR2, type2 VARCHAR2)
IS
BEGIN
    add_pokemon2(poke_name,bio,type1,type2);
    DELETE archived_pokemon WHERE name = poke_name;
END;

CALL unarchive_pokemon('MissingNo','??????','Dragon','Fighting');

----------------------------------------

-- Joins 
-- Everything after the FROM statement is just a virtual table
-- The idea of a join is to mold together two or more virtual tables.

SELECT * FROM pokemon p LEFT JOIN stats s ON p.p_id = s.p_id;
SELECT * FROM pokemon p RIGHT JOIN stats s ON p.p_id = s.p_id;

SELECT p.p_id, name,lvl, hp FROM pokemon p RIGHT JOIN stats s ON p.p_id = s.p_id;

ALTER TABLE stats DROP CONSTRAINT fk_stats_pokemon;

SELECT * FROM pokemon;
SELECT * FROM stats;
SELECT * FROM archived_pokemon;

DELETE pokemon WHERE p_id < 61;
DELETE pokemon WHERE p_id = 62;
DELETE stats WHERE p_id = 63;
commit;

SELECT * FROM pokemon INNER JOIN stats ON pokemon.p_id = stats.p_id;

SELECT * FROM pokemon FULL OUTER JOIN stats ON pokemon.p_id = stats.p_id;

SELECT * FROM pokemon NATURAL JOIN stats;

SELECT * FROM pokemon CROSS JOIN pokemon;
-- You can join on the same table. This is called a Self Join

SELECT * FROM pokemon INNER JOIN stats 
ON pokemon.p_id = stats.p_id WHERE lvl < 3;

INSERT INTO archived_pokemon VALUES (id_maker.nextval, 'Zubat', 'A bat pokemon');

SELECT archived_pokemon.name, pokemon.name FROM archived_pokemon LEFT JOIN pokemon 
ON pokemon.name < archived_pokemon.name;

