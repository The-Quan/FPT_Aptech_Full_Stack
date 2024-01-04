use slot12;
CREATE TABLE DonDatHang (
    MaDonHang INT PRIMARY KEY,
    NguoiDatHang NVARCHAR(50),
    DiaChi NVARCHAR(100),
    DienThoai NVARCHAR(20),
    NgayDatHang DATE
);

CREATE TABLE MatHang (
    STT INT PRIMARY KEY,
    TenHang NVARCHAR(50),
    MoTaHang NVARCHAR(100),
    DonVi NVARCHAR(20),
    Gia INT,
    SoLuong INT,
    ThanhTien INT,
    MaDonHang INT FOREIGN KEY REFERENCES DonDatHang(MaDonHang)
);
INSERT INTO DonDatHang VALUES (123, N'Nguyễn Văn An', N'111 Nguyễn Trãi, Thanh Xuân, Hà Nội', '987654321', '2009-09-18');
INSERT INTO MatHang VALUES (1, N'Máy Tính T450', N'Máy nhập mới', N'Chiếc', 1000, 1, 1000, 123);
INSERT INTO MatHang VALUES (2, N'Điện Thoại Nokia5670', N'Điện thoại đang hot', N'Chiếc', 200, 2, 400, 123);
INSERT INTO MatHang VALUES (3, N'Máy In Samsung 450', N'Máy in đang ế', N'Chiếc', 100, 1, 100, 123);
SELECT DISTINCT NguoiDatHang FROM DonDatHang;
SELECT DISTINCT TenHang FROM MatHang;

SELECT * FROM DonDatHang;

SELECT NguoiDatHang FROM DonDatHang ORDER BY NguoiDatHang;
SELECT TenHang FROM MatHang ORDER BY Gia DESC;

SELECT MatHang.* FROM MatHang

JOIN DonDatHang ON MatHang.MaDonHang = DonDatHang.MaDonHang
WHERE DonDatHang.NguoiDatHang = 'Nguyễn Văn An';
SELECT COUNT(DISTINCT NguoiDatHang) AS SoKhachHang FROM DonDatHang;
SELECT COUNT(*) AS SoMatHang FROM MatHang;
SELECT MaDonHang, SUM(ThanhTien) AS TongTien FROM MatHang GROUP BY MaDonHang;
UPDATE MatHang SET Gia = ABS(Gia) WHERE Gia < 0;
UPDATE DonDatHang SET NgayDatHang = GETDATE() WHERE NgayDatHang > GETDATE();
ALTER TABLE MatHang ADD NgayXuatHien DATE;
CREATE INDEX IX_TenHang ON MatHang(TenHang);
CREATE INDEX IX_NguoiDatHang ON DonDatHang(NguoiDatHang);
CREATE VIEW View_KhachHang AS
SELECT NguoiDatHang, DiaChi, DienThoai FROM DonDatHang;

CREATE VIEW View_SanPham AS
SELECT TenHang, Gia FROM MatHang;

CREATE VIEW View_KhachHang_SanPham AS
SELECT DonDatHang.NguoiDatHang, DonDatHang.DienThoai, MatHang.TenHang, MatHang.SoLuong, DonDatHang.NgayDatHang
FROM DonDatHang
JOIN MatHang ON DonDatHang.MaDonHang = MatHang.MaDonHang;

CREATE PROCEDURE SP_TimKH_MaKH
    @MaKH INT
AS
BEGIN
    SELECT * FROM DonDatHang WHERE MaDonHang = @MaKH;
END;
CREATE PROCEDURE SP_TimKH_MaHD
    @MaHD INT
AS
BEGIN
    SELECT * FROM MatHang WHERE MaDonHang = @MaHD;
END;
CREATE PROCEDURE SP_SanPham_MaKH
    @MaKH INT
AS
BEGIN
    SELECT * FROM MatHang WHERE MaDonHang IN (SELECT MaDonHang FROM DonDatHang WHERE MaDonHang = @MaKH);
END;

