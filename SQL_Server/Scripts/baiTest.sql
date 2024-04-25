create database baiTest;
use baiTest;

create table customer(
Id int primary key not null,
userName varchar (225),
Email varchar (225),
Address varchar (22)
)
insert into customer (Id, UserName, Email, Address)
values (1, 'Huy', 'huyngoc@gmail.com', '97 Bac Kan'),
       (2, 'Binh', 'binhnguyen@gmail.com', '29 Ha Noi')
select * from customer ;

//sua
update customer
set Id = 2, userName = 'Quan',  Email = 'quan@gmail.com'
where id=2;

//them
insert into customer (Id, UserName, Email, Address)
values (3, 'binh', 'binh@gmail.com', '35 ninh binh');

//xóa
delete from customer where id=2;

//thêm cột
ALTER TABLE customer ADD COLUMN year_old INT(50) not null;
INSERT INTO customer (year_old) VALUES (18), (19);

// xóa cột 

alter table customer 
drop column year_old;

