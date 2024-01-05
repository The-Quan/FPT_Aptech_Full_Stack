--PHAN 1--
IF EXISTS (SELECT * FROM sys.databases WHERE Name='Example5')
           DROP DATABASE Example5 
GO 
CREATE DATABASE Example5
GO 
USE Example5 
GO 
-- tạo bảng lớp học ---
CREATE TABLE LopHoc (
               MaLopHoc INT PRIMARY KEY IDENTITY,
			   TenLopHoc VARCHAR (10)
			   )
GO 
--tạo bảng sinh viên có khóa ngoại là cột MaLopHoc, nối với bảng LopHoc 
CREATE TABLE SinhVien (
MaSV int PRIMARY KEY,
TenSV varchar (40),
MaLopHoc int,
CONSTRAINT fk FOREIGN KEY (MaLopHoc) REFERENCES LopHoc (MaLopHoc)
)
GO
--Tạo bảng sanpham với một cột NULL, Một cột NOT NUll 
CREATE TABLE SanPham (
    MaSP int NOT NULL,
	TenSP varchar(40) NULL
	)
GO 
--tạo bảng với thuôvj tính default cho cột Price 
CREATE TABLE StoreProduct (
ProductID int NOT NULL,
Name varchar(40) NOT NULL,
Price money NOT NULL DEFAULT (100)
)
--thử kiểm tra xem giá trị default có được sử dụng hay ko--
INSERT INTO StoreProduct (ProductID, Name) VALUES (111, Rivets)
GO 
--Tạo bảng ContactPhone với thuộc tính IDENTITY---
CREATE TABLE ContactPhone (
Person_ID int IDENTITY(500,1) NOT NULL,
MobileNumber bigint NOT NULL
)
GO 
--Tạo cột nhận dạng duy nhất tổng thể--
CREATE TABLE CellularPhone (
Person_ID uniqueidentifier DEFAULT NEWID() NOT NULL,
PersonName varchar(60) NOT NULL )
--Chèn một record vào--
INSERT INTO CellularPhone(PersonName) VALUES ('WIlliam Smith')
GO
--kiểm tra giá trị của cột Person_ID tu dong sinh--
INSERT INTO CellularPhone(PersonName) VALUES('Wiliam Smith')
GO 
--tao bang Contactphone voi cot MobileNumber co thuoc tinh UNIQUE 
CREATE TABLE ContactPhone (
Person_ID int PRIMARY KEY,
MobileNumber bigint UNIQUE,
ServiceProvider varchar (30),
LandlineNumber bigint UNIQUE 
)
--Chèn 2 bản ghi có giá trị giống nhau ở cột MobileNumber và LanliNumber để quan sát lỗi --
INSERT INTO ContactPhone values (101, 98334574, 'Hutch', NULL)
INSERT INTO ContactPhone values (102, 983345674, 'Alex', NULL)
GO
--Tạo bảng PhoneExpenses có một CHECT ở một Amount--
 CREATE TABLE PhoneExpenses (
 Expense_ID int PRIMARY KEY, 
 MobileNumber bigint FOREiGN KEY REFERENCES   ContactPhone 
 (MobileNumber),
 Amount bigint CHECK (Amount >0)
 )
 GO
 --Chỉnh sửa cột trong bảng 
 ALTER TABLE ContactPhone
 ALTER COLUMN ServiceProvider varchar(45)
 GO
 --Xóa cột trong bảng--
 ALTER TABLE ContactPhone
 DROP COLUMN ServiceProvider 
 GO
 --thêm một ràng buộc vào bảng --
 ALTER TABLE ContactPhone ADD CONSTRAINT CHK_RC CHECK(RentalCharger > 0)
 GO
 --xóa một ràng buộc --
 ALTER TABLE Person.ContactPhone
 DROP CONSTRAINT CHK_RC

 --PHAN 2--
 USE BookLibrary;
GO

INSERT INTO IssueDetails(BookCode, MemberCode, IssueDate, ReturnDate)
VALUES (1,1,30/4/1975, 1/5/2023)