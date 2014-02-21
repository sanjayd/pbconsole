create table users (
    username varchar(256) not null,
    password varchar(256) not null
);

insert into users (username, password) values ('admin', 'admin');
