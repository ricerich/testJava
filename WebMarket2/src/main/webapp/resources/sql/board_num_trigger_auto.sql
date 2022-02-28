create or replace trigger NUM_SEQUENCE_TRIGGER
before insert
on BOARD
referencing new as new
for each row
begin
	select num_SEQ.nextval into :new.NUM from dual;
end;