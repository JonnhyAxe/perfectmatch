INSERT INTO MODEL (ID, VAL) VALUES (1, 'TEST');


INSERT INTO MUSIC (ARTIST, NAME, STYLE) VALUES ('Latmun', 'Please Stop (Original Mix)', 'TECH_HOUSE');
INSERT INTO MUSIC (ARTIST, NAME, STYLE) VALUES ('Latmun', 'Def (Original Mix)', 'TECH_HOUSE');

INSERT INTO SAMPLE (ID, STYLE) VALUES ('Latmun - Please Stop (Original Mix)', 'TECH_HOUSE');
INSERT INTO SAMPLE (ID, STYLE) VALUES ('Latmun - Def (Original Mix)', 'TECH_HOUSE');

INSERT INTO SAMPLE_MATCH (SAMPLE1, SAMPLE2, RULE) VALUES ('Latmun - Please Stop (Original Mix)', 'Latmun - Def (Original Mix)', 'BY_ARTIST');
