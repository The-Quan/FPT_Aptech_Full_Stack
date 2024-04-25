create database project
use project
create table login(
email varchar (255),
password varchar (255)
)
insert into login(email, password)
value("quan123@gmail.com","123")

select * from login ;