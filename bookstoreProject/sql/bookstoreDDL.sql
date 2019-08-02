-- 재능 기부자
DROP TABLE book cascade constraint;

-- 재능 수혜자
DROP TABLE author cascade constraint;
--
-- 재능기부 정보
DROP TABLE publisher cascade constraint;
--
-- 재능기부 프로젝트
DROP TABLE translator cascade constraint;

DROP SEQUENCE book_id_seq;
DROP SEQUENCE publisher_id_seq;
DROP SEQUENCE author_id_seq;
DROP SEQUENCE translator_id_seq;

CREATE TABLE book (
       book_id          	NUMBER PRIMARY KEY ,
       title               	VARCHAR2(200) NOT NULL,
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
--
--CREATE SEQUENCE probono_project_id_seq;
--CREATE TABLE probono_project (
--	   probono_project_id     		NUMBER(5) PRIMARY KEY,
--	   probono_project_name 		VARCHAR2(50) NOT NULL,
--       probono_id           			VARCHAR2(50) NOT NULL,       
--       activist_id          				VARCHAR2(20) NOT NULL,
--       receive_id           				VARCHAR2(20) NOT NULL, 
--       project_content      			VARCHAR2(100) NOT NULL
--);

CREATE SEQUENCE book_id_seq;
CREATE SEQUENCE publisher_id_seq;
CREATE SEQUENCE author_id_seq;
CREATE SEQUENCE translator_id_seq;

  
--ALTER TABLE book  ADD FOREIGN KEY (pname) REFERENCES publisher  (publisher_id);
--ALTER TABLE book ADD FOREIGN KEY (aname)  REFERENCES author  (author_id);
--ALTER TABLE book ADD FOREIGN KEY (tname) REFERENCES translator  (translator_id);
