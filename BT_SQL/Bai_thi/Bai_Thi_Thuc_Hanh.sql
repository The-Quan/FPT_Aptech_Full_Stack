-- Cau 2
CREATE DATABASE Bai_Thi_Thuc_Hanh
GO 
create table PhongBans(
	MaPhongBan varchar(50) primary key,
	TenPhongBan varchar(100)
);
CREATE TABLE NhanViens (
    MaNhanVien VARCHAR(50) PRIMARY KEY,
    TenNhanVien VARCHAR(100),
    MaPhongBan VARCHAR(50) FOREIGN KEY REFERENCES PhongBans(MaPhongBan)
);
CREATE TABLE Luongs (
    MaNhanVien VARCHAR(50) PRIMARY KEY,
    NgayLamViec INT,
    NgayNghiCoLuong INT,
    NgayNghiKhongLuong INT,
    LuongCoBan DECIMAL(10, 2),
    LuongGross DECIMAL(10, 2),
    LuongNet DECIMAL(10, 2),
    FOREIGN KEY (MaNhanVien) REFERENCES NhanViens(MaNhanVien)
);
INSERT INTO PhongBans (MaPhongBan, TenPhongBan) VALUES
('IT', N'Công Nghệ Thông Tin'),
('HR', N'Nhân Sự'),
('SALE', N'Bán Hàng');
INSERT INTO NhanViens (MaNhanVien, TenNhanVien, MaPhongBan) VALUES
('A1', N'Nguyễn Văn A', 'IT'),
('A2', 'Lê Thị Bình', 'IT'),
('B1', N'Nguyễn Lan', 'HR'),
('D1', N'Mai Tuấn Anh', 'HR'),
('C1', N'Hà Thị Lan', 'HR'),
('C2', N'Lê Tú Chinh', 'SALE'),
('D2', N'Trần Văn Toàn', 'HR'),
('A3', N'Trần Văn Nam', 'IT'),
('B2', N'Huỳnh Anh', 'SALE');
INSERT INTO Luongs (MaNhanVien, NgayLamViec, NgayNghiCoLuong, NgayNghiKhongLuong, LuongCoBan, LuongGross, LuongNet) VALUES
('A1', 22, 0, 0, 1000, 22000, 20000),
('A2', 21, 1, 0, 1200, 26400, 23000),
('B1', 20, 1, 1, 600, 13200, 12000),
('D1', 20, 1, 1, 500, 11000, 10000),
('C1', 22, 0, 0, 500, 11000, 10000),
('C2', 22, 0, 0, 1200, 26400, 23000),
('D2', 22, 0, 0, 500, 11000, 10000),
('A3', 22, 0, 0, 1200, 26400, 23000),
('B2', 21, 1, 0, 1200, 26400, 23000);

Select * from PhongBans
select * from Luongs
select * from NhanViens

--Câu 3

CREATE VIEW vw_TongLuongTheoPhongBan AS
SELECT
    pb.MaPhongBan,
    pb.TenPhongBan,
    SUM(luong.LuongNet) AS TongLuong
FROM
    PhongBans pb
JOIN
    NhanViens nv ON pb.MaPhongBan = nv.MaPhongBan
JOIN
    Luongs luong ON nv.MaNhanVien = luong.MaNhanVien
GROUP BY
    pb.MaPhongBan, pb.TenPhongBan
WITH CHECK OPTION;
SELECT * FROM vw_TongLuongTheoPhongBan;