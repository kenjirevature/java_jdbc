Oracel - 12.1.0.2.v4
create table dept(
  deptno number(2,0),
  dname  varchar2(14),
  loc    varchar2(13),
  constraint pk_dept primary key (deptno)
);


DECLARE

BEGIN

insert into dept
values(10, 'ACCOUNTING', 'NEW YORK');
insert into dept
values(20, 'RESEARCH', 'DALLAS');
insert into dept
values(30, 'SALES', 'CHICAGO');
insert into dept
values(40, 'OPERATIONS', 'BOSTON');
 
 
 
 create or replace procedure "INSERTROWS"  
(id IN NUMBER,  
name IN VARCHAR,
loc IN VARCHAR)  
is  
begin  
insert into dept values(id,name,loc);  
end;  
/ 