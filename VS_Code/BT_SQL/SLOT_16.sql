
use SLOT_16

Schema definition for contact information storage
CREATE TABLE DanhBa (
  HoVaTen NVARCHAR(255),
  DiaChi NVARCHAR(255),
  DienThoai NVARCHAR(255),
  NgaySinh DATE
);

INSERT INTO DanhBa (HoVaTen, DiaChi, DienThoai, NgaySinh)
VALUES ('Nguyễn Văn An', '111 Nguyễn Trãi, Thanh Xuân, Hà Nội', '0987654321', '1987-11-18');

SELECT HoVaTen FROM DanhBa ORDER BY HoVaTen;

SELECT DienThoai FROM DanhBa;

SELECT * FROM DanhBa ORDER BY HoVaTen;

SELECT * FROM DanhBa WHERE HoVaTen LIKE 'Nguyễn Văn An';

SELECT * FROM DanhBa WHERE NgaySinh = '2009-12-12';

SELECT HoVaTen, COUNT(DienThoai) FROM DanhBa GROUP BY HoVaTen;

SELECT COUNT(*) FROM DanhBa WHERE MONTH(NgaySinh) = 12;

SELECT * FROM DanhBa WHERE DienThoai LIKE '%123456789%';

ALTER TABLE DanhBa ADD CONSTRAINT chk_NgaySinh CHECK (NgaySinh < GETDATE());

ALTER TABLE DanhBa ADD NgayBatDauLienLac DATE DEFAULT GETDATE();

CREATE INDEX IX_HoTen ON DanhBa(HoVaTen);
CREATE INDEX IX_SoDienThoai ON DanhBa(DienThoai);

CREATE VIEW View_SoDienThoai AS SELECT HoVaTen, DienThoai FROM DanhBa;
CREATE VIEW View_SinhNhat AS
SELECT HoVaTen, NgaySinh, DienThoai FROM DanhBa
WHERE MONTH(NgaySinh) = MONTH(GETDATE()) AND DAY(NgaySinh) = DAY(GETDATE());