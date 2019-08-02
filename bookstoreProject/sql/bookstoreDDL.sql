-- 책
DROP TABLE book cascade constraint;

-- 저자
DROP TABLE author cascade constraint;
--
-- 출판사
DROP TABLE publisher cascade constraint;
--
-- 번역가
DROP TABLE translator cascade constraint;

DROP SEQUENCE book_id_seq;
DROP SEQUENCE publisher_id_seq;
DROP SEQUENCE author_id_seq;
DROP SEQUENCE translator_id_seq;

CREATE TABLE book (
       book_id          	NUMBER PRIMARY KEY ,
       title               	VARCHAR2(200) ,
       publishmonth         	VARCHAR2(200) NOT NULL,
       price                	VARCHAR2(200) NOT NULL,
       discountrate                	NUMBER ,
       aname                	VARCHAR2(200) NOT NULL,
       tname                	VARCHAR2(200),
       pname                	VARCHAR2(200) 
);

CREATE TABLE author (
       author_id     		NUMBER PRIMARY KEY ,
       aname                		VARCHAR2(300) NOT NULL
);


CREATE TABLE publisher (
       publisher_id               NUMBER PRIMARY KEY,
       pname    			  VARCHAR2(200) NOT NULL
);

CREATE TABLE translator (
       translator_id               NUMBER PRIMARY KEY,
       tname     				 VARCHAR2(200) NOT NULL
);

CREATE SEQUENCE book_id_seq;
CREATE SEQUENCE publisher_id_seq;
CREATE SEQUENCE author_id_seq;
CREATE SEQUENCE translator_id_seq;

  

