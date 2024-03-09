create table tb_medicine(
id bigint not null auto_increment,
name varchar(100) not null,
way varchar(100) not null, 
batch varchar (100) not null,
quantify varchar(100) not null,
validaty varchar(100) not null,
laboratory varchar(100) not null,

primary key(id)
);