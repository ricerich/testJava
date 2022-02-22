INSERT INTO MEMBER (id, passwd, name) VALUES ('admin', '1234', '관리자');
INSERT INTO MEMBER (id, passwd, name) VALUES ('honggd', 'hong1234', '홍길동');

INSERT INTO MEMBER (id, passwd, name) VALUES (ID_SEQ.nextval, '1234', '관리자');
INSERT INTO MEMBER (id, passwd, name) VALUES (ID_SEQ.nextval, 'hong1234', '홍길동');


INSERT INTO MEMBER (passwd, name) VALUES ('1234', '관리자');
INSERT INTO MEMBER (passwd, name) VALUES ('hong1234', '홍길동');