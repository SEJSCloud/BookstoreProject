
DROP TABLE book cascade constraint;


DROP SEQUENCE book_id_seq;


CREATE TABLE book (
       book_id          	NUMBER ,
       title               	VARCHAR2(200) ,
       publishmonth         	VARCHAR2(200) ,
       price                	VARCHAR2(200) ,
       discountrate                	NUMBER ,
       publisherid                	NUMBER 
);

CREATE SEQUENCE book_id_seq;
CREATE SEQUENCE publisher_id_seq;

--ALTER TABLE probono_project  ADD FOREIGN KEY (receive_id) REFERENCES recipient  (recipient_id);
--ALTER TABLE probono_project ADD FOREIGN KEY (activist_id)  REFERENCES activist  (activist_id);
--ALTER TABLE probono_project ADD FOREIGN KEY (probono_id) REFERENCES probono  (probono_id);
