CREATE DATABASE [Linh_Kien]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Linh_Kien', FILENAME = N'D:\Linh_Kien.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Linh_Kien_log', FILENAME = N'D:\Linh_Kien_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
USE Linh_Kien
GO
CREATE TABLE HoaDon(
	maHoaDon NVARCHAR(50) PRIMARY KEY NOT NULL,
	maKhachHang NVARCHAR(50) NOT NULL,
	maNhanVien NVARCHAR(50) NOT NULL,
	ngayTao DATE NOT NULL,
	noiNhan NVARCHAR(100) NOT NULL,
	tongtien MONEY NOT NULL
)

CREATE TABLE ChiTietHoaDon(
	maHoaDon NVARCHAR(50) NOT NULL,
	maLinhKien NVARCHAR(50) NOT NULL,
	soLuong INT NOT NULL,
	giaBan FLOAT NOT NULL,
	thanhtien MONEY NOT NULL
)
CREATE TABLE Linhkien(
	maLinhKien NVARCHAR(50) PRIMARY KEY NOT NULL,
	tenLinhKien NVARCHAR(50) NOT NULL,
	maLoaiLK NVARCHAR(50) NOT NULL,
	donGia FLOAT NOT NULL,
	soLuong INT NOT NULL,
	maNCC NVARCHAR(50) NOT NULL
)
CREATE TABLE NhanVien(
	maNhanVien NVARCHAR(50) PRIMARY KEY NOT NULL,
	tenNhanVien NVARCHAR(50) NOT NULL,
	SDT NVARCHAR(50) NOT NULL,
	diaChi NVARCHAR(100) NOT NULL
)
CREATE TABLE KhachHang(
	maKhachHang NVARCHAR(50) PRIMARY KEY NOT NULL,
	tenKH NVARCHAR(50) NOT NULL,
	SDT NVARCHAR(50) NOT NULL,
	diaChi NVARCHAR(100) NOT NULL
)
create table LoaiLinhKien
(
	maLoaiLK nvarchar(50) primary key not null,
	tenLoaiLK nvarchar(50) not null
)
create table NhaCungCap
(
	maNCC nvarchar(50) primary key not null,
	tenNCC nvarchar(50) not null,
	SDT NVARCHAR(50) NOT NULL,
	diaChi nvarchar(100) not null
)
CREATE TABLE TaiKhoan
(
	maTK NVARCHAR(50) PRIMARY KEY NOT NULL,
	matKhau	NVARCHAR(50) NOT NULL,
	maNguoiDung NVARCHAR(50) NOT NULL
)
GO
--tạo ràng buộc
ALTER TABLE dbo.HoaDon
ADD CONSTRAINT fk_maKhachHang FOREIGN KEY(maKhachHang) REFERENCES dbo.khachHang(maKhachHang),
	CONSTRAINT fk_maNhanVien FOREIGN KEY(maNhanVien) REFERENCES dbo.nhanVien(maNhanVien)

ALTER TABLE dbo.ChiTietHoaDon
ADD CONSTRAINT pk_maHoaDon_maHang PRIMARY KEY(maHoaDon,maLinhKien),
	CONSTRAINT fk_maHoaDon FOREIGN KEY(maHoaDon) REFERENCES dbo.HoaDon(maHoaDon),
	CONSTRAINT fk_maLinhKien FOREIGN KEY(maLinhKien) REFERENCES dbo.Linhkien(maLinhKien)

alter table [dbo].[Linhkien]
add constraint fk_maLoaiLK foreign key(maLoaiLK) references [dbo].[LoaiLinhKien](maLoaiLK),
	constraint fk_maNCC foreign key(maNCC) references [dbo].[NhaCungCap](maNCC)

ALTER TABLE [dbo].[KhachHang]
ADD CONSTRAINT fk_taiKhoanKhachHang FOREIGN KEY([maKhachHang]) REFERENCES [dbo].[TaiKhoan]([maTK])
ALTER TABLE [dbo].[NhanVien]
ADD CONSTRAINT fk_taiKhoanNhanVien FOREIGN KEY([maNhanVien]) REFERENCES [dbo].[TaiKhoan]([maTK])

--tạo dữ liệu
insert into [dbo].[NhaCungCap]
values	(N'NCC-0001',N'DELL',N'0123456789',N'Q.1'),
		(N'NCC-0002',N'ASUS',N'0124356879',N'Q.1'),
		(N'NCC-0003',N'SONY',N'0152463879',N'Q.1'),
		(N'NCC-0004',N'VERNICAL',N'01254378698',N'Q.1'),
		(N'NCC-0005',N'ZODIA',N'01523648257',N'Q.1')
insert into [dbo].[LoaiLinhKien]
values	(N'LLK-0001',N'CPU'),
		(N'LLK-0002',N'Ổ cứng'),
		(N'LLK-0003',N'Đĩa mềm'),
		(N'LLK-0004',N'Card đồ họa'),
		(N'LLK-0005',N'RAM'),
		(N'LLK-0006',N'Quạt tản nhiệt'),
		(N'LLK-0007',N'USB')
insert into [dbo].[Linhkien]
values	(N'LK-00001',N'Ổ cứng HHD 8gb',N'LLK-0002',500000,250,N'NCC-0001'),
		(N'LK-00002',N'Ổ cứng HHD 50gb',N'LLK-0002',1000000,250,N'NCC-0002'),
		(N'LK-00003',N'Ổ cứng HHD 100gb',N'LLK-0002',1500000,250,N'NCC-0003'),
		(N'LK-00004',N'Ổ cứng HHD 250gb',N'LLK-0002',2500000,250,N'NCC-0001'),
		(N'LK-00005',N'Ổ cứng HHD 1T',N'LLK-0002',3200000,250,N'NCC-0004'),
		(N'LK-00006',N'Ổ cứng HHD 10T',N'LLK-0002',5000000,250,N'NCC-0005'),
		(N'LK-00007',N'Ổ cứng SSD 150gb',N'LLK-0002',750000,250,N'NCC-0005'),
		(N'LK-00008',N'Ổ cứng SSD 350gb',N'LLK-0002',1200000,250,N'NCC-0001'),
		(N'LK-00009',N'Ổ cứng SSD 750gb',N'LLK-0002',2000000,250,N'NCC-0001'),
		(N'LK-00010',N'Ổ cứng SSD 1T',N'LLK-0002',4000000,250,N'NCC-0003'),
		(N'LK-00011',N'Ổ cứng SSD 2T',N'LLK-0002',5000000,250,N'NCC-0004'),
		(N'LK-00012',N'Ram 2gb',N'LLK-0005',500000,250,N'NCC-0002'),
		(N'LK-00013',N'Ram 4gb',N'LLK-0005',600000,250,N'NCC-0004'),
		(N'LK-00014',N'Ram 6gb',N'LLK-0005',700000,250,N'NCC-0005'),
		(N'LK-00015',N'Ram 8gb',N'LLK-0005',800000,250,N'NCC-0001'),
		(N'LK-00016',N'USB 150mb',N'LLK-0007',100000,250,N'NCC-0001'),
		(N'LK-00017',N'USB 500mb',N'LLK-0007',200000,250,N'NCC-0002'),
		(N'LK-00018',N'USB 1gb',N'LLK-0007',300000,250,N'NCC-0002'),
		(N'LK-00019',N'USB 2gb',N'LLK-0007',400000,250,N'NCC-0003'),
		(N'LK-00020',N'USB 10gb',N'LLK-0007',500000,250,N'NCC-0004')
insert into [dbo].[TaiKhoan]
values	(N'NV-00001',N'1',N'01'),
		(N'NV-00002',N'1',N'02'),
		(N'NV-00003',N'1',N'03'),
		(N'KH-00001',N'1',N'04'),
		(N'KH-00002',N'1',N'05'),
		(N'KH-00003',N'1',N'06'),
		(N'KH-00004',N'1',N'07'),
		(N'KH-00005',N'1',N'08'),
		(N'KH-00006',N'1',N'09'),
		(N'KH-00007',N'1',N'10'),
		(N'KH-00008',N'1',N'11'),
		(N'KH-00009',N'1',N'12'),
		(N'KH-00010',N'1',N'13')
insert into [dbo].[KhachHang]
values	(N'KH-00001',N'Nguyễn Lê Nam Anh',N'0123546852',N'12 Trần Não Q.2 TP.HCM'),
		(N'KH-00002',N'Lâm Hồng Huy',N'0125364789',N'111 Hai Bà Trưng Q.1 TP.HCM'),
		(N'KH-00003',N'Nguyễn Tuấn Kiệt',N'0152478654',N'321 Quang Trung Q.Gò vấp TP.HCM'),
		(N'KH-00004',N'Phan Tuấn Tài',N'0124536852',N'213 Nguyễn Thị Minh Khai Q.3 TP.HCM'),
		(N'KH-00005',N'Lưu Quang Vinh',N'0524368547',N'10 Ngô Quyền Q.5 TP.HCM'),
		(N'KH-00006',N'Lê Hoàng',N'0623154789',N'01 Nguyễn Tất Thành Q.4 TP.HCM'),
		(N'KH-00007',N'Trần Đăng Khoa',N'0652348521',N'16 Cao Thắng Q.1 TP.HCM'),
		(N'KH-00008',N'Trần Thị Giàu',N'0192468523',N'232/5 Lê Lợi Q.1 TP.HCM'),
		(N'KH-00009',N'Trần Minh Nghĩa',N'0163235368',N'128 Vườn Lài Q.12 TP.HCM'),
		(N'KH-00010',N'Thái Minh Hào',N'0128989685',N'216 Tôn Đản Q.5 TP.HCM')
insert into [dbo].[NhanVien]
values	(N'NV-00001',N'Nguyễn Văn Thái',N'025142592',N'17/350 Đ.Lê Đức Thọ F.15 Q.Gò Vấp TP.HCM'),
		(N'NV-00002',N'Nguyễn Đình Tùng',N'045878758',N'123 Bạch Đằng Q.BT TP.HCM'),
		(N'NV-00003',N'Cao Quốc HƯng',N'025643636',N'345/67 Cộng Hòa Q.TB TP.HCM')
insert into [dbo].[HoaDon]
values (N'HD-01',N'KH-00001',N'NV-00001',CAST(N'2021-05-02' AS Date), N'12 Trần Não Q.2 TP.HCM', 4280000.0000),
		(N'HD-02',N'KH-00002',N'NV-00001',CAST(N'2021-03-01' AS Date), N'111 Hai Bà Trưng Q.1 TP.HCM', 780000.0000),
		(N'HD-03',N'KH-00003',N'NV-00002',CAST(N'2021-01-02' AS Date), N'321 Quang Trung Q.Gò vấp TP.HCM', 710000.0000),
		(N'HD-04',N'KH-00004',N'NV-00003',CAST(N'2021-27-08' AS Date), N'213 Nguyễn Thị Minh Khai Q.3 TP.HCM', 470000.0000)
insert into [dbo].[ChiTietHoaDon]
values (N'HD-01',N'LK-00005',  90000.0000, 2, 180000.0000 ),
		(N'HD-01',N'LK-00001',  800000.0000, 1, 800000.0000 ),
		(N'HD-03',N'LK-00006',  2500000.0000, 1, 2500000.0000 ),
		(N'HD-04',N'LK-00002',  500000.0000, 2, 1000000.0000 )
