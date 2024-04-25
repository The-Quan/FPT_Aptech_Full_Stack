create database quanfpt
user quanfpt
create table account(
id int primary key,
username varchar(30),
password varchar(30)
)
insert into account values (1,'admin','admin123')
select * from  account

