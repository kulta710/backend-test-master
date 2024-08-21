CREATE TABLE "USER" (
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
    NAME VARCHAR(255),
    PRIMARY KEY(ID)
);

INSERT INTO "USER"(NAME) VALUES ('TEST');

CREATE TABLE LOTTO (
    ID BIGINT,
    NUMBER_1 INT,
    NUMBER_2 INT,
    NUMBER_3 INT,
    NUMBER_4 INT,
    NUMBER_5 INT,
    NUMBER_6 INT,
    PRIMARY KEY(ID)
);

INSERT INTO LOTTO VALUES(1, 7, 28, 33, 2, 45, 19);
INSERT INTO LOTTO VALUES(2, 26, 14, 41, 3, 22, 35);
INSERT INTO LOTTO VALUES(3, 15, 29, 38, 6, 44, 21);
INSERT INTO LOTTO VALUES(4, 31, 16, 42, 9, 23, 36);
INSERT INTO LOTTO VALUES(5, 17, 30, 39, 10, 45, 24);

CREATE TABLE WINNER (
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
    LOTTO_ID INT,
    RANK INT,
    PRIMARY KEY(ID),
    FOREIGN KEY(LOTTO_ID) REFERENCES LOTTO(ID)
);