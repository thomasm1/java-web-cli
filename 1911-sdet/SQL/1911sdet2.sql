
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
    cp NUMBER(10),
    shiny NUMBER(1) DEFAULT 0);
    
--Junction Table
--These are used for tables that have a Many-to-Many relationship

CREATE TABLE pokemon_type (
    p_id NUMBER(10),
    t_id NUMBER(10));
    
ALTER TABLE stats DROP CONSTRAINT fk_stats_pokemon;
ALTER TABLE stats ADD CONSTRAINT fk_stats_pokemon FOREIGN KEY
(p_id) REFERENCES pokemon(p_id) ON DELETE CASCADE;


INSERT INTO pokemon VALUES (1, 'Bulbasaur', 'The first Pokemon');
INSERT INTO stats VALUES (1, 5, 5, 5, 5, 15, 0);

INSERT INTO stats VALUES (2, 5, 5, 5, 5, 15, 0);

DELETE stats;
DELETE pokemon;
SELECT * FROM pokemon;
SELECT * FROM stats;


ALTER TABLE pokemon_type ADD CONSTRAINT fk_pt_pokemon FOREIGN KEY
(p_id) REFERENCES pokemon(p_id) ON DELETE CASCADE;

ALTER TABLE pokemon_type ADD CONSTRAINT fk_pt_type FOREIGN KEY
(t_id) REFERENCES ptype(t_id) ON DELETE CASCADE;

INSERT INTO ptype VALUES (1, 'Grass');
INSERT INTO ptype VALUES (2, 'Poison');

SELECT * FROM ptype;

SELECT * FROM pokemon_type;

INSERT INTO pokemon_type VALUES(1,1);
INSERT INTO pokemon_type VALUES(1,2);
    
    
    