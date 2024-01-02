CREATE DATABASE SLOT_14
GO
-- CÂU 2 
CREATE TABLE KhachHang (
    MaKhachHang INT PRIMARY KEY,
    TenKhachHang NVARCHAR(255),
    SoCMT INT,
    DiaChi NVARCHAR(255),
    CONSTRAINT Unique_CMTND UNIQUE(SoCMT)
);

CREATE TABLE ThueBao (
    SoThueBao INT PRIMARY KEY,
    LoaiThueBao NVARCHAR(50),
    NgayDangKy DATE,
    MaKhachHang INT,
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang)
);

-- CÂU 3 
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, SoCMT, DiaChi)
VALUES (1, N'Nguyễn Nguyệt Nga', 123456789, N'Hà Nội');

INSERT INTO ThueBao (SoThueBao, LoaiThueBao, NgayDangKy, MaKhachHang)
VALUES (123456789, N'Trả trước', '2002-12-12', 1);

-- CÂU 4 
-- A 
SELECT * FROM KhachHang;
-- B 
SELECT * FROM ThueBao;

-- CÂU 5 
-- A 
SELECT * FROM ThueBao WHERE SoThueBao = '123456789';
-- B
SELECT * FROM KhachHang WHERE SoCMT = '123456789';
-- C
SELECT * FROM ThueBao WHERE MaKhachHang = (SELECT MaKhachHang FROM KhachHang WHERE SoCMT = 123456789);
-- D
SELECT * FROM ThueBao WHERE NgayDangKy = '2002-12-12';
-- E
SELECT * FROM KhachHang WHERE DiaChi = N'HÀ NỘI';

-- CÂU 6 
-- A 
SELECT COUNT(*) FROM KhachHang;
-- B 
SELECT COUNT(*) FROM ThueBao;
-- C
SELECT COUNT(*) FROM ThueBao WHERE NgayDangKy = '2002-12-12';
-- D
SELECT * FROM KhachHang
JOIN ThueBao ON KhachHang.MaKhachHang = ThueBao.MaKhachHang;

-- CÂU 7 
-- A 
ALTER TABLE ThueBao ALTER COLUMN NgayDangKy DATE NOT NULL;
-- B
ALTER TABLE ThueBao ADD CONSTRAINT Check_NgayDangKy CHECK (NgayDangKy <= GETDATE());
-- C
UPDATE ThueBao SET SoThueBao = '09' + SUBSTRING(CAST(SoThueBao AS VARCHAR), 3, LEN(SoThueBao)-2);
-- D
ALTER TABLE ThueBao ADD DiemThuong INT DEFAULT 0;

-- CÂU 8 
--A 
CREATE INDEX Index_TenKhachHang ON KhachHang(TenKhachHang);
-- B
-- View_KhachHang
CREATE VIEW View_KhachHang AS
SELECT MaKhachHang, TenKhachHang, DiaChi FROM KhachHang;

-- View_KhachHang_ThueBao
CREATE VIEW View_KhachHang_ThueBao AS
SELECT KhachHang.MaKhachHang, TenKhachHang, SoThueBao
FROM KhachHang
JOIN ThueBao ON KhachHang.MaKhachHang = ThueBao.MaKhachHang;

-- C 
-- SP_TimKH_ThueBao
CREATE PROCEDURE SP_TimKH_ThueBao
    @SoThueBao INT
AS
BEGIN
    SELECT KhachHang.*, ThueBao.*
    FROM KhachHang
    JOIN ThueBao ON KhachHang.MaKhachHang = ThueBao.MaKhachHang
    WHERE ThueBao.SoThueBao = @SoThueBao;
END;

-- SP_TimTB_KhachHang
CREATE PROCEDURE SP_TimTB_KhachHang
    @TenKhachHang NVARCHAR(255)
AS
BEGIN
    SELECT ThueBao.SoThueBao
    FROM KhachHang
    JOIN ThueBao ON KhachHang.MaKhachHang = ThueBao.MaKhachHang
    WHERE KhachHang.TenKhachHang = @TenKhachHang;
END;
