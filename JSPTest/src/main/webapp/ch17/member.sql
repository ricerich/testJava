drop table member2;

CREATE TABLE  member2(
   id VARCHAR(20) NOT NULL,
   passwd  VARCHAR(20),
   name VARCHAR(30),    
   PRIMARY KEY (id)
);
INSERT INTO member2 VALUES('1', '1234', '홍길순');
INSERT INTO member2 VALUES('2', '1235', '홍길동');


select * from member2;
