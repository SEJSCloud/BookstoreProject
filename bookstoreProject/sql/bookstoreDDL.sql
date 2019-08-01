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
       book_id          	NUMBER ,
       title               	VARCHAR2(200) ,
       publishmonth         	VARCHAR2(200) ,
       price                	VARCHAR2(200) ,
       discountrate                	NUMBER ,
       publisherid                	NUMBER ,
       tname                	VARCHAR2(200)
);

CREATE TABLE author (
       author_id     		NUMBER,
       aname                		VARCHAR2(300)
);


CREATE TABLE publisher (
       publisher_id               NUMBER ,
       pname    			  VARCHAR2(200)
);

CREATE TABLE translator (
       translator_id               NUMBER ,
       tname     				 VARCHAR2(200)
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


  
--ALTER TABLE probono_project  ADD FOREIGN KEY (receive_id) REFERENCES recipient  (recipient_id);
--ALTER TABLE probono_project ADD FOREIGN KEY (activist_id)  REFERENCES activist  (activist_id);
--ALTER TABLE probono_project ADD FOREIGN KEY (probono_id) REFERENCES probono  (probono_id);
