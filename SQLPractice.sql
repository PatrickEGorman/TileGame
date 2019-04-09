DROP TABLE layout;
DROP TABLE tile;

CREATE TABLE layout (
    name TEXT PRIMARY KEY NOT NULL
);

CREATE TABLE tile (
    x INTEGER,
    y INTEGER,
    tile_type TEXT NOT NULL,
    layout_name TEXT NOT NULL,
    FOREIGN KEY(layout_name) REFERENCES layout(name)
);

INSERT INTO layout VALUES('Islands');

INSERT INTO tile VALUES(0, 0, 'Water', 'Islands');
INSERT INTO tile VALUES(1, 0, 'Water', 'Islands');
INSERT INTO tile VALUES(2, 0, 'Water', 'Islands');
INSERT INTO tile VALUES(3, 0, 'Water', 'Islands');
INSERT INTO tile VALUES(4, 0, 'Water', 'Islands');
INSERT INTO tile VALUES(5, 0, 'Water', 'Islands');
INSERT INTO tile VALUES(6, 0, 'Water', 'Islands');
INSERT INTO tile VALUES(7, 0, 'Water', 'Islands');
INSERT INTO tile VALUES(8, 0, 'Water', 'Islands');

INSERT INTO tile VALUES(0, 1, 'Water', 'Islands');
INSERT INTO tile VALUES(1, 1, 'Water', 'Islands');
INSERT INTO tile VALUES(2, 1, 'Rock', 'Islands');
INSERT INTO tile VALUES(3, 1, 'Rock', 'Islands');
INSERT INTO tile VALUES(4, 1, 'Water', 'Islands');
INSERT INTO tile VALUES(5, 1, 'Water', 'Islands');
INSERT INTO tile VALUES(6, 1, 'Water', 'Islands');
INSERT INTO tile VALUES(7, 1, 'Water', 'Islands');
INSERT INTO tile VALUES(8, 1, 'Water', 'Islands');

INSERT INTO tile VALUES(0, 2, 'Water', 'Islands');
INSERT INTO tile VALUES(1, 2, 'Rock', 'Islands');
INSERT INTO tile VALUES(2, 2, 'Grass', 'Islands');
INSERT INTO tile VALUES(3, 2, 'Grass', 'Islands');
INSERT INTO tile VALUES(4, 2, 'Rock', 'Islands');
INSERT INTO tile VALUES(5, 2, 'Water', 'Islands');
INSERT INTO tile VALUES(6, 2, 'Water', 'Islands');
INSERT INTO tile VALUES(7, 2, 'Water', 'Islands');
INSERT INTO tile VALUES(8, 2, 'Water', 'Islands');

INSERT INTO tile VALUES(0, 3, 'Rock', 'Islands');
INSERT INTO tile VALUES(1, 3, 'Grass', 'Islands');
INSERT INTO tile VALUES(2, 3, 'Grass', 'Islands');
INSERT INTO tile VALUES(3, 3, 'Grass', 'Islands');
INSERT INTO tile VALUES(4, 3, 'Grass', 'Islands');
INSERT INTO tile VALUES(5, 3, 'Rock', 'Islands');
INSERT INTO tile VALUES(6, 3, 'Water', 'Islands');
INSERT INTO tile VALUES(7, 3, 'Water', 'Islands');
INSERT INTO tile VALUES(8, 3, 'Water', 'Islands');

INSERT INTO tile VALUES(0, 4, 'Rock', 'Islands');
INSERT INTO tile VALUES(1, 4, 'Grass', 'Islands');
INSERT INTO tile VALUES(2, 4, 'Grass', 'Islands');
INSERT INTO tile VALUES(3, 4, 'Grass', 'Islands');
INSERT INTO tile VALUES(4, 4, 'Grass', 'Islands');
INSERT INTO tile VALUES(5, 4, 'Rock', 'Islands');
INSERT INTO tile VALUES(6, 4, 'Water', 'Islands');
INSERT INTO tile VALUES(7, 4, 'Water', 'Islands');
INSERT INTO tile VALUES(8, 4, 'Water', 'Islands');

INSERT INTO tile VALUES(0, 5, 'Water', 'Islands');
INSERT INTO tile VALUES(1, 5, 'Rock', 'Islands');
INSERT INTO tile VALUES(2, 5, 'Grass', 'Islands');
INSERT INTO tile VALUES(3, 5, 'Rock', 'Islands');
INSERT INTO tile VALUES(4, 5, 'Rock', 'Islands');
INSERT INTO tile VALUES(5, 5, 'Water', 'Islands');
INSERT INTO tile VALUES(6, 5, 'Water', 'Islands');
INSERT INTO tile VALUES(7, 5, 'Water', 'Islands');
INSERT INTO tile VALUES(8, 5, 'Water', 'Islands');

INSERT INTO tile VALUES(0, 6, 'Water', 'Islands');
INSERT INTO tile VALUES(1, 6, 'Water', 'Islands');
INSERT INTO tile VALUES(2, 6, 'Rock', 'Islands');
INSERT INTO tile VALUES(3, 6, 'Water', 'Islands');
INSERT INTO tile VALUES(4, 6, 'Water', 'Islands');
INSERT INTO tile VALUES(5, 6, 'Water', 'Islands');
INSERT INTO tile VALUES(6, 6, 'Water', 'Islands');
INSERT INTO tile VALUES(7, 6, 'Water', 'Islands');
INSERT INTO tile VALUES(8, 6, 'Water', 'Islands');

INSERT INTO tile VALUES(0, 7, 'Water', 'Islands');
INSERT INTO tile VALUES(1, 7, 'Water', 'Islands');
INSERT INTO tile VALUES(2, 7, 'Water', 'Islands');
INSERT INTO tile VALUES(3, 7, 'Water', 'Islands');
INSERT INTO tile VALUES(4, 7, 'Water', 'Islands');
INSERT INTO tile VALUES(5, 7, 'Water', 'Islands');
INSERT INTO tile VALUES(6, 7, 'Water', 'Islands');
INSERT INTO tile VALUES(7, 7, 'Water', 'Islands');
INSERT INTO tile VALUES(8, 7, 'Water', 'Islands');

INSERT INTO tile VALUES(0, 8, 'Water', 'Islands');
INSERT INTO tile VALUES(1, 8, 'Water', 'Islands');
INSERT INTO tile VALUES(2, 8, 'Water', 'Islands');
INSERT INTO tile VALUES(3, 8, 'Water', 'Islands');
INSERT INTO tile VALUES(4, 8, 'Rock', 'Islands');
INSERT INTO tile VALUES(5, 8, 'Rock', 'Islands');
INSERT INTO tile VALUES(6, 8, 'Water', 'Islands');
INSERT INTO tile VALUES(7, 8, 'Water', 'Islands');
INSERT INTO tile VALUES(8, 8, 'Water', 'Islands');

INSERT INTO tile VALUES(0, 9, 'Water', 'Islands');
INSERT INTO tile VALUES(1, 9, 'Water', 'Islands');
INSERT INTO tile VALUES(2, 9, 'Water', 'Islands');
INSERT INTO tile VALUES(3, 9, 'Water', 'Islands');
INSERT INTO tile VALUES(4, 9, 'Rock', 'Islands');
INSERT INTO tile VALUES(5, 9, 'Grass', 'Islands');
INSERT INTO tile VALUES(6, 9, 'Grass', 'Islands');
INSERT INTO tile VALUES(7, 9, 'Rock', 'Islands');
INSERT INTO tile VALUES(8, 9, 'Water', 'Islands');

INSERT INTO tile VALUES(0, 10, 'Water', 'Islands');
INSERT INTO tile VALUES(1, 10, 'Water', 'Islands');
INSERT INTO tile VALUES(2, 10, 'Water', 'Islands');
INSERT INTO tile VALUES(3, 10, 'Rock', 'Islands');
INSERT INTO tile VALUES(4, 10, 'Grass', 'Islands');
INSERT INTO tile VALUES(5, 10, 'Grass', 'Islands');
INSERT INTO tile VALUES(6, 10, 'Grass', 'Islands');
INSERT INTO tile VALUES(7, 10, 'Rock', 'Islands');
INSERT INTO tile VALUES(8, 10, 'Water', 'Islands');

INSERT INTO tile VALUES(0, 11, 'Water', 'Islands');
INSERT INTO tile VALUES(1, 11, 'Water', 'Islands');
INSERT INTO tile VALUES(2, 11, 'Water', 'Islands');
INSERT INTO tile VALUES(3, 11, 'Rock', 'Islands');
INSERT INTO tile VALUES(4, 11, 'Grass', 'Islands');
INSERT INTO tile VALUES(5, 11, 'Rock', 'Islands');
INSERT INTO tile VALUES(6, 11, 'Water', 'Islands');
INSERT INTO tile VALUES(7, 11, 'Water', 'Islands');
INSERT INTO tile VALUES(8, 11, 'Water', 'Islands');

INSERT INTO tile VALUES(0, 12, 'Water', 'Islands');
INSERT INTO tile VALUES(1, 12, 'Water', 'Islands');
INSERT INTO tile VALUES(2, 12, 'Water', 'Islands');
INSERT INTO tile VALUES(3, 12, 'Water', 'Islands');
INSERT INTO tile VALUES(4, 12, 'Rock', 'Islands');
INSERT INTO tile VALUES(5, 12, 'Water', 'Islands');
INSERT INTO tile VALUES(6, 12, 'Water', 'Islands');
INSERT INTO tile VALUES(7, 12, 'Water', 'Islands');
INSERT INTO tile VALUES(8, 12, 'Water', 'Islands');



SELECT * from layout ORDER BY name ASC;
SELECT * from tile ORDER BY layout_name='Islands';