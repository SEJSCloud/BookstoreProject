-- translator,author,publisher insert[각 테이블 컬럼값 중복제거후 시퀀스이용 기본키 설정, 테이블 구성]

insert into translator select translator_id_seq.nextval, tname from (select distinct tname from book where tname is not null) where tname is not null;
insert into author select author_id_seq.nextval, aname from (select distinct aname from book where aname is not null) where aname is not null;
insert into publisher select publisher_id_seq.nextval, pname from (select distinct pname from book where pname is not null) where pname is not null;

commit;

DROP TABLE book_copy;
CREATE TABLE book_copy AS SELECT * FROM book;
DELETE book;

commit;

ALTER TABLE book modify (pname number);
ALTER TABLE book modify (aname number);
ALTER TABLE book modify (tname number);

commit;


INSERT INTO book select book_id, title, publishmonth, price, discountrate, 
		to_number(aname) aname, to_number(tname) tname, to_number(pname) pname
from book_copy;

ALTER TABLE book ADD FOREIGN KEY (pname) REFERENCES publisher (publisher_id);
ALTER TABLE book ADD FOREIGN KEY (aname) REFERENCES author (author_id);
ALTER TABLE book ADD FOREIGN KEY (tname) REFERENCES translator (translator_id);

commit;
