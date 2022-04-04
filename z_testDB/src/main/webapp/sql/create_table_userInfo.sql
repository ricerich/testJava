DROP TABLE user_info_sample;
create table user_info_sample(
    U_ID VARCHAR(20)PRIMARY KEY,
    U_NAME VARCHAR(20),
    U_PHONE VARCHAR(20),
    U_GRADE NUMBER,
    WRITE_TIME DATE
);

INSERT INTO USER_INFO_SAMPLE VALUES ('GD','권지용','010-1234-1111',4,SYSDATE);
INSERT INTO USER_INFO_SAMPLE VALUES ('TOP','최승현','010-1222-1111',1,SYSDATE);
INSERT INTO USER_INFO_SAMPLE VALUES ('IU','이지은','010-333-3331',2,SYSDATE);
INSERT INTO USER_INFO_SAMPLE VALUES ('SUJI','배수지','010-4444-444',3,SYSDATE);
INSERT INTO USER_INFO_SAMPLE VALUES ('BRAD','브래드','010-5050-5551',4,SYSDATE);

INSERT INTO USER_INFO_SAMPLE VALUES ('YOONBAR','윤바','010-1234-7777',6, TO_DATE('2022-03-05 17:23:32', 'YYYY-MM-DD HH24:MI:SS'));

COMMIT;