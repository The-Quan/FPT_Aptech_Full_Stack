CREATE DATABASE DonHang;
USE DonHang;

create table customers(
Id int primary key,
Name varchar (225),
Address varchar (225)
)
insert into customers(Id, Name, Address)
values (1, 'Nguyen Van A', 'Ha Noi');

select * from custormers;

create table product(
Id int primary key,
Product_Name varchar (225),
XL int 
)
insert into product (id, Product_Name, XL)
values (1, 'May tinh', 1);

select * from product ;

CREATE TABLE oder (
    C_Id int,
    Id int PRIMARY KEY,
    Product_Name varchar(225),
    Time_Oder date
);

INSERT INTO oder (C_Id, Id, Product_Name, Time_Oder)
VALUES (1, 1, 'May Tinh', '2024-02-21');

select * from oder ;
