
create table list_tb(
	id int auto_increment primary key, 
    title varchar(50) not null,
	contents varchar(1000) not null, 
    username varchar(50) not null unique
); 





