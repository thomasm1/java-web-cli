

-- Union
SELECT * FROM pokemon;
SELECT * FROM archived_pokemon;

INSERT INTO archived_pokemon VALUES (61, 'Eevee', 'The cutest pokemon');
commit;

SELECT * FROM pokemon UNION SELECT * FROM archived_pokemon;
SELECT * FROM pokemon UNION ALL SELECT * FROM archived_pokemon;

SELECT * FROM pokemon INTERSECT SELECT * FROM archived_pokemon;

SELECT * FROM pokemon MINUS SELECT * FROM archived_pokemon;
SELECT * FROM archived_pokemon MINUS SELECT * FROM pokemon;


--------------------------------------------

DROP TABLE pokemon_type;
DROP TABLE stats;
DROP TABLE ptype;
DROP TABLE pokemon;

CREATE TABLE pokemon (
    p_id NUMBER(10) PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    bio VARCHAR2(200));
    
CREATE TABLE ptype (
    t_id NUMBER(10) PRIMARY KEY,
    type VARCHAR(20));
    
CREATE TABLE stats (
    p_id NUMBER(10),
    lvl NUMBER(10) DEFAULT 1,
    hp NUMBER(10),
    attack NUMBER(10),
    defense NUMBER(10),
    shiny NUMBER(1) DEFAULT 0,
    CONSTRAINT fk_stats_pokemon FOREIGN KEY (p_id) 
    REFERENCES pokemon(p_id) ON DELETE CASCADE);
    
CREATE TABLE pokemon_type (
    p_id NUMBER(10),
    t_id NUMBER(10),
    CONSTRAINT fk_pt_pokemon FOREIGN KEY (p_id)
    REFERENCES pokemon(p_id) ON DELETE CASCADE,
    CONSTRAINT fk_pt_type FOREIGN KEY (t_id)
    REFERENCES ptype(t_id) ON DELETE CASCADE);
    


------------------------
-- dual table

CREATE TABLE dual (
    dummy VARCHAR2(1));
    
INSERT INTO dual VALUES ('X');

SELECT * FROM dual;
    
SELECT 1 FROM dual;

SELECT 1+1 FROM dual;

SELECT SYSDATE FROM archived_pokemon WHERE ROWNUM = 1;

SELECT SYSDATE FROM dual;

SELECT USER FROM dual;

SELECT USER FROM archived_pokemon WHERE ROWNUM = 1;


------------------------------------

-- Procedures OUT parameters

CREATE OR REPLACE PROCEDURE convertTypesToIds(type1 IN VARCHAR2, type2 IN VARCHAR2, t_id1 OUT NUMBER, t_id2 OUT NUMBER)
IS
BEGIN
SELECT t_id INTO t_id1 FROM ptype WHERE type = type1 AND ROWNUM = 1;
IF type2 IS NOT NULL
THEN
SELECT t_id INTO t_id2 FROM ptype WHERE type = type2 AND ROWNUM = 1;
ELSE
SELECT -1 INTO t_id2 FROM dual;
END IF;
END;


CREATE OR REPLACE PROCEDURE add_pokemon2(name IN VARCHAR2, bio IN VARCHAR2, type1 IN VARCHAR2, type2 IN VARCHAR2)
IS
t_id1 NUMBER(10);
t_id2 NUMBER(10);
BEGIN
convertTypesToIds(type1, type2, t_id1, t_id2);
add_pokemon(name, bio, t_id1, t_id2);

commit;
END;

CALL add_pokemon2('Venasaur','The third pokemon','Grass','Poison');
CALL add_pokemon2('Seaking','The bigger goldfish pokemon','Water',null);

SET serveroutput on;
DECLARE
t_id1 NUMBER(10);
t_id2 NUMBER(10);
BEGIN
convertTypesToIds('Water', null, t_id1, t_id2);
dbms_output.put_line(t_id2);
END;


SELECT * FROM pokemon;
SELECT * FROM stats;
SELECT * FROM pokemon_type;
SELECT * FROM ptype;

CREATE OR REPLACE PROCEDURE add_new_pokemon(name VARCHAR2, bio VARCHAR2)
IS
BEGIN
    INSERT INTO pokemon VALUES (id_maker.nextval, name, bio);
END;

CALL add_new_pokemon('Ditto','The copy pokemon');
commit;

SELECT * FROM pokemon;


CREATE TABLE person (
    username VARCHAR2(100),
    password VARCHAR2(100));
    
INSERT INTO person VALUES ('Ryan', 'password');
INSERT INTO person VALUES ('Adam', 'password');
INSERT INTO person VALUES ('Shelby', 'password');
commit;


