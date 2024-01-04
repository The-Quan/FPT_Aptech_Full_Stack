use SLOT_15
go


CREATE TABLE SanPham (
  MaSanPham VARCHAR(255) NOT NULL PRIMARY KEY,
  NgaySanXuat DATE NOT NULL,
  TenLoaiSanPham VARCHAR(255),
  MaLoaiSanPham VARCHAR(255),
  NguoiChiuTrachNhiem VARCHAR(255),
  MaNguoiChiuTrachNhiem INT
);

INSERT INTO SanPham (MaSanPham, NgaySanXuat, TenLoaiSanPham, MaLoaiSanPham, NguoiChiuTrachNhiem, MaNguoiChiuTrachNhiem)
VALUES ('Z37 111111', '2009-12-12', 'May tinh sach tay Z37', 'Z37E', 'Nguyen Van An', 987688);


SELECT DISTINCT TenLoaiSanPham FROM SanPham;

SELECT MaSanPham FROM SanPham;

SELECT DISTINCT NguoiChiuTrachNhiem FROM SanPham;

SELECT TenLoaiSanPham FROM SanPham ORDER BY MaSanPham DESC;

SELECT TenLoaiSanPham, NguoiChiuTrachNhiem FROM SanPham;

SELECT * FROM SanPham WHERE MaLoaiSanPham = 'Z37E';

SELECT * FROM SanPham WHERE NguoiChiuTrachNhiem = 'Nguyen Van An';


SELECT COUNT(*) FROM SanPham;
SELECT MaSanPham, TenLoaiSanPham FROM SanPham;
SELECT TenLoaiSanPham FROM SanPham ;
SELECT * FROM SanPham;

ALTER TABLE SanPham ADD CONSTRAINT chk_NgaySanXuat_New CHECK (NgaySanXuat <= GETDATE());

ALTER TABLE SanPham DROP CONSTRAINT chk_NgaySanXuat;

ALTER TABLE SanPham
ADD PhienBan INT;

CREATE INDEX idx_NguoiChiuTrachNhiem ON SanPham(NguoiChiuTrachNhiem);

CREATE VIEW View_SanPham AS
SELECT MaSanPham, NgaySanXuat, TenLoaiSanPham
FROM SanPham;

CREATE VIEW View_SanPham_NCTN AS
SELECT MaSanPham, NgaySanXuat, NguoiChiuTrachNhiem
FROM SanPham;

CREATE VIEW View_Top_SanPham AS
SELECT TOP 5 MaSanPham, TenLoaiSanPham, NgaySanXuat
FROM SanPham
ORDER BY NgaySanXuat DESC;

