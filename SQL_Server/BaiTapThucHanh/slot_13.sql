﻿use slot_13
go
CREATE TABLE HangSanXuat (
    MaSoHang INT PRIMARY KEY,
    TenHang VARCHAR(255),
    DiaChi VARCHAR(255),
    DienThoai VARCHAR(255)
);

CREATE TABLE SanPham (
    STT INT PRIMARY KEY,
    TenHang VARCHAR(255),
    MaSoHang INT,
    DonVi VARCHAR(255),
    Gia DECIMAL(10,2),
    SoLuongHienCo INT,
    FOREIGN KEY (MaSoHang) REFERENCES HangSanXuat(MaSoHang)
);
INSERT INTO HangSanXuat (MaSoHang, TenHang, DiaChi, DienThoai)
VALUES (123, 'Asus', 'USA', '983232');

INSERT INTO SanPham (STT, TenHang, MaSoHang, DonVi, Gia, SoLuongHienCo)
VALUES (1, N'Máy Tính T450', 123, N'Chiếc', 1000, 10),
       (2, N'Điện Thoại Nokia5670', 123, N'Chiếc', 200, 200),
       (3, N'Máy In Samsung 450', 123, N'Chiếc', 100, 10);

SELECT * FROM HangSanXuat;

SELECT * FROM SanPham;

SELECT * FROM SanPham ORDER BY TenHang DESC;

SELECT * FROM SanPham WHERE Gia < 500;

SELECT * FROM HangSanXuat WHERE TenHang = 'Asus';

SELECT * FROM SanPham WHERE SoLuongHienCo < 11;

SELECT SanPham.* FROM SanPham
JOIN HangSanXuat ON SanPham.MaSoHang = HangSanXuat.MaSoHang
WHERE HangSanXuat.TenHang = 'Asus';