create table users(
id int primary key,
username varchar(255) not null,
password varchar(255) not null
)
insert into users values (1, "admin", "admin")

select username from users where username like "admin" and password like "admin" 

select * from user