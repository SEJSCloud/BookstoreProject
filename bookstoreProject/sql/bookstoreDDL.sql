-- 재능 기부자
DROP TABLE book cascade constraint;

---- 재능 수혜자
--DROP TABLE recipient cascade constraint;
--
---- 재능기부 정보
--DROP TABLE probono cascade constraint;
--
---- 재능기부 프로젝트
--DROP TABLE probono_project cascade constraint;

DROP SEQUENCE book_id_seq;


CREATE TABLE book (
       book_id          	NUMBER ,
       title               	VARCHAR2(200) ,
       publishmonth         	VARCHAR2(200) ,
       price                	VARCHAR2(200) ,
       discountrate                	NUMBER ,
       publisherid                	NUMBER 
);

--CREATE TABLE recipient (
--       recipient_id     		VARCHAR2(20) PRIMARY KEY,
--       name                		VARCHAR2(20) NOT NULL,
--       password          		VARCHAR2(20) NOT NULL,
--       receiveContent   		VARCHAR2(50) NOT NULL
--);
--
--
--CREATE TABLE probono (
--       probono_id          	VARCHAR2(50) PRIMARY KEY,
--       probono_name      VARCHAR2(50) NOT NULL,
--       probono_purpose  	VARCHAR2(200) NOT NULL
--);
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

--ALTER TABLE probono_project  ADD FOREIGN KEY (receive_id) REFERENCES recipient  (recipient_id);
--ALTER TABLE probono_project ADD FOREIGN KEY (activist_id)  REFERENCES activist  (activist_id);
--ALTER TABLE probono_project ADD FOREIGN KEY (probono_id) REFERENCES probono  (probono_id);
