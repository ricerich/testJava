--JSPBOOK계정에서 실행
drop sequence ID_SEQ;
create or replace sequence ID_SEQ
start with 1
increment by 1;

select * from user_sequences;

create or replace trigger ID_SEQUENCE_TRIGGER
before insert
on MEMBER
referencing new as new
for each row
begin
	select ID_SEQ.nextval into :new.ID from dual;
end;