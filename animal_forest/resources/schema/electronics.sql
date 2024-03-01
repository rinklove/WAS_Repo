drop table Electronics;

create table Electronics(
	model_num varchar2(15) primary key,
	model_name varchar2(20) not null,
	price int,
	description varchar2(100), 
	password varchar2(20) not null,
	writeday date  not null, 
	readnum int, 
	 fname varchar2(50), 
     fsize int 
);

select * from Electronics;

 commit
 -----------------------------------------------------------
 
 select * from Electronics order by writeday desc
 
 


 -
 
 
 
 delete from replies; 
 delete from users; 

 delete from Electronics; 
 
 
 
 
 
 
 
 
 

