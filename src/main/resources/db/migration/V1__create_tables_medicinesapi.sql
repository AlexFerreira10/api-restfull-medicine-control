create table tb_medicine(
                        id bigint not null auto_increment,
                        name varchar(100) not null,
                        way varchar(100) not null,
                        batch varchar (100) not null,
                        quantify bigint not null,
                        validaty date not null,
                        laboratory varchar(100) not null,
                        active tinyint,

                        primary key(id)
);

create table tb_user(
                        id bigint auto_increment,
                        login varchar(255) not null unique,
                        password varchar(255) not null,

                        primary key(id)
);