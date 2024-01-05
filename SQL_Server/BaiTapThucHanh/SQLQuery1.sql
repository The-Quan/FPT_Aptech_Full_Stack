--DATA DEFINITION : thiết lập cấu trúc bảng 
--1. Create database/drop database 
--2. create schame 

create database TestHk
use TestHk
--check xem co TestHk nAY ko
select name  from master.sys.databases
--delete database
use master 
go
drop database if exists TestHk 
drop table if exists student 
drop schema if exists sale 
--Schema: phan quyen truy cap bang, quy hoach bang 
create schema customer_service;
--gan table voi shema 
create table customer_service.customer(
id int PRIMARY KEY,
cname nvarchar (255)
)
create table customer_service.order(
int int PRIMARY KEY,
odate DATETIME2 )
use testHK
--TABLE:
create table student2(
   int int primary key identity(10,10),
   firt_name nvarchar(50) not null, --ko duoc de trong ten
   last_name nvarchar(50)
   )
alter table student2 drop COLUMN int 
--alter table student1 rename COLUMN int to id
exec sp_rename 'dbo.student2.int', 'id', 'column';
select * from student2
--add colum 
alter TABLE student 
add 
email Varchar(200) not null,
  phone varchar(20); 


  create table position (
  pid int primary key identity(1,1),
  pname nvarchar (255) not null )

  create table employee (
  eid int primary key identity(1,1),
  position_id int,
  foreign key (position_id) references position(pid) )

  alter TABLE employee add name nvarchar(225)

  insert into [position] VALUES ('sale')
  insert  into employee VALUES(2,'quan')
  select * from employee
  select * from [position] where pid = 1

  






--DATA MANIPULATION : Lập trình, truy vấn 
--1. select, order by, where and or not, between, like, join
--2. group by, having, esists
--3. insert, data, delete, updata join, transaction

--DATA  TYPE: kiểu dữ liệu 
--1. char, data, decimal, int, nvarchar, time varchar 


