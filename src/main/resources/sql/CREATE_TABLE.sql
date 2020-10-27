DROP DATABASE HEROES IF EXISTS;

CREATE DATABASE HEROES;

USE HEROES;

CREATE TABLE HERO 
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(100) NOT NULL,
	CREATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP,
  	UPDATED_AT DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)
);


CREATE TABLE POWER 
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(100) NOT NULL,
	CREATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP,
  	UPDATED_AT DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)
);



CREATE TABLE HERO_POWER 
(
	HERO_ID INTEGER NOT NULL,
	POWER_ID INTEGER NOT NULL,
    PRIMARY KEY (HERO_ID,POWER_ID),
   	FOREIGN KEY (HERO_ID) REFERENCES HERO(ID),
   	FOREIGN KEY (POWER_ID) REFERENCES POWER(ID)
);