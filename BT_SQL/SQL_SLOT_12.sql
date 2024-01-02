CREATE TABLE danhSachMatHang(
STT INT PRIMARY KEY ,
TÊN_Hàng NVARCHAR (255),
Mô_tả_hàng NVARCHAR (255),
Đơn_vị NVARCHAR (255),
Giá FLOAT,
Số_lượng FLOAT,
Thành_tiền FLOAT
);

INSERT INTO danhSachMatHang (STT, TÊN_Hàng, Mô_tả_hàng, Đơn_vị, Giá, Số_lượng, Thành_tiền)
Values 
      (1,N'Máy Tính T450',N'Máy nhập mới',N'Chiếc','1000 ','1 ','1000'),
	  (2,N'Điện Thoại Nokia5670',N'Điện thoại đang hot',N'Chiếc','200 ','2 ','400 '),
	  (3,N'Máy In Samsung 450',N'Máy in đang ế ',N'Chiếc','100 ','1','100');

CREATE TABLE DonDatHang (
    MaSoDonHang INT PRIMARY KEY,
    NguoiDatHang NVARCHAR(255),
    DiaChi NVARCHAR(255),
    DienThoai VARCHAR(15),
    NgayDatHang DATE
);

INSERT INTO DonDatHang (MaSoDonHang, NguoiDatHang, DiaChi, DienThoai, NgayDatHang)
VALUES (123, N'Nguyễn Văn An', N'111 Nguyễn Trãi, Thanh Xuân, Hà Nội', '987654321', '2009-11-18');

select * from DonDatHang
select * from danhSachMatHang