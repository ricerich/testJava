-- System계정으로 실행해야함
DROP USER webmarket CASCADE; 

CREATE USER webmarket IDENTIFIED BY webmarket;
GRANT CONNECT, RESOURCE TO webmarket;
ALTER USER webmarket ACCOUNT UNLOCK;
