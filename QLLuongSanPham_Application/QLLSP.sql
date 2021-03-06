USE [master]
GO
/****** Object:  Database [QuanLyLuongSP]    Script Date: 13/11/2021 3:26:47 CH ******/
CREATE DATABASE [QuanLyLuongSP]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyLuongSP', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\QuanLyLuongSP.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QuanLyLuongSP_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\QuanLyLuongSP_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QuanLyLuongSP] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyLuongSP].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyLuongSP] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyLuongSP] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyLuongSP] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyLuongSP] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyLuongSP] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyLuongSP] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyLuongSP] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyLuongSP] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyLuongSP] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyLuongSP] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [QuanLyLuongSP]
GO
/****** Object:  Table [dbo].[BangLuongCongTy]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangLuongCongTy](
	[maBangLuong] [nvarchar](10) NOT NULL,
	[thangLuong] [nvarchar](10) NULL,
	[tongLuongCongTy] [money] NULL,
	[tongLuongNhanVien] [money] NULL,
	[tongLuongCongNhan] [money] NULL,
	[tongSanPham] [int] NULL,
	[tongSoGioTangCa] [int] NULL,
	[maNguoiTao] [nvarchar](10) NOT NULL,
	[ngayTao] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maBangLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BaoCao]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BaoCao](
	[maBaoCao] [nvarchar](10) NOT NULL,
	[noiDungBaoCao] [nvarchar](50) NOT NULL,
	[maNguoiTao] [nvarchar](10) NOT NULL,
	[ngayTao] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maBaoCao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CaLam]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CaLam](
	[maCaLam] [nvarchar](10) NOT NULL,
	[maCongNhan] [nvarchar](10) NOT NULL,
	[maSanPham] [nvarchar](10) NOT NULL,
	[soLuongSanPham] [int] NOT NULL,
	[loaiCaLam] [nvarchar](10) NOT NULL,
	[ngayChuNhat] [bit] NOT NULL,
	[ngayLam] [date] NULL,
	[maNguoiTao] [nvarchar](10) NOT NULL,
	[ngayTao] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maCaLam] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CongNhan]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongNhan](
	[maCongNhan] [nvarchar](10) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[gioiTinh] [nvarchar](10) NOT NULL,
	[SDT] [nvarchar](20) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maCongNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHopDong]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHopDong](
	[maHopDong] [nvarchar](10) NOT NULL,
	[tenHopDong] [nvarchar](50) NOT NULL,
	[soLuongSanPham] [int] NOT NULL,
	[giaTriHopDong] [money] NOT NULL,
	[ThanhToan] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHopDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HopDong]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HopDong](
	[maHopDong] [nvarchar](10) NOT NULL,
	[ngayTaoHopDong] [date] NOT NULL,
	[ngayHetHanHopDong] [date] NOT NULL,
	[maSanPham] [nvarchar](10) NOT NULL,
	[maKhachHang] [nvarchar](10) NOT NULL,
	[maNhanVien] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHopDong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nvarchar](10) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[gioiTinh] [nvarchar](10) NOT NULL,
	[SDT] [nvarchar](20) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[maLoaiSanPham] [nvarchar](10) NOT NULL,
	[tenSanPham] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoaiSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NgayNghi]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NgayNghi](
	[maNgayNghi] [nvarchar](20) NOT NULL,
	[maNhanVien] [nvarchar](10) NOT NULL,
	[ngayNghi] [date] NOT NULL,
	[ngayHetNghi] [date] NOT NULL,
	[troCap] [bit] NULL,
	[lyDo] [nvarchar](100) NULL,
	[maNguoiTao] [nvarchar](10) NOT NULL,
	[ngayTao] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maNgayNghi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiQuanLyNhanVien]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiQuanLyNhanVien](
	[maNguoiQL] [nvarchar](10) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[gioiTinh] [nvarchar](10) NOT NULL,
	[SDT] [nvarchar](20) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNguoiQL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nvarchar](10) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[gioiTinh] [nvarchar](10) NOT NULL,
	[SDT] [nvarchar](20) NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
	[ngayBatDau] [date] NOT NULL,
	[heSoluong] [money] NOT NULL,
	[donViCongTac] [nvarchar](30) NOT NULL,
	[chucVu] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuLuongCongNhan]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuLuongCongNhan](
	[maPhieuLuong] [nvarchar](10) NOT NULL,
	[thangLuong] [nvarchar](10) NOT NULL,
	[maNguoiHuong] [nvarchar](10) NOT NULL,
	[hoTen] [nvarchar](50) NULL,
	[gioiTinh] [nvarchar](10) NULL,
	[soSanPham] [int] NULL,
	[soSanPhamCa3] [int] NULL,
	[soSanPhamNgayCN] [int] NULL,
	[donGia] [money] NULL,
	[thanhTien] [money] NOT NULL,
	[maNguoiTao] [nvarchar](10) NOT NULL,
	[ngayTao] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuLuongNhanVien]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuLuongNhanVien](
	[maPhieuLuong] [nvarchar](10) NOT NULL,
	[thangLuong] [nvarchar](10) NOT NULL,
	[maNguoiHuong] [nvarchar](10) NOT NULL,
	[hoTen] [nvarchar](50) NULL,
	[gioiTinh] [nvarchar](10) NULL,
	[chucVu] [nvarchar](20) NOT NULL,
	[donViCongTac] [nvarchar](30) NOT NULL,
	[heSoluong] [money] NOT NULL,
	[ngayNghi] [int] NULL,
	[ngayNghiCoPhep] [int] NULL,
	[soGioTangCa] [int] NULL,
	[thanhTien] [money] NOT NULL,
	[maNguoiTao] [nvarchar](10) NOT NULL,
	[ngayTao] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhieuLuong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [nvarchar](10) NOT NULL,
	[tenSanPham] [nvarchar](50) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [money] NOT NULL,
	[maLoaiSanPham] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenTaiKhoan] [nvarchar](10) NOT NULL,
	[matKhau] [nvarchar](50) NOT NULL,
	[maNhanVien] [nvarchar](10) NULL,
	[maQuanLy] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[tenTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TangCa]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TangCa](
	[maTangCa] [nvarchar](20) NOT NULL,
	[maNhanVien] [nvarchar](10) NOT NULL,
	[ngayTangCa] [date] NOT NULL,
	[soGio] [int] NULL,
	[maNguoiTao] [nvarchar](10) NOT NULL,
	[ngayTao] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maTangCa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TatCaHopDong]    Script Date: 13/11/2021 3:26:47 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TatCaHopDong](
	[maHopDong] [nvarchar](10) NOT NULL,
	[tenHopDong] [nvarchar](50) NOT NULL,
	[soLuongSanPham] [int] NOT NULL,
	[giaTrihopDong] [money] NOT NULL,
	[ThanhToan] [bit] NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[BangLuongCongTy]  WITH CHECK ADD  CONSTRAINT [fk_maNguoiTaoBL] FOREIGN KEY([maNguoiTao])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[BangLuongCongTy] CHECK CONSTRAINT [fk_maNguoiTaoBL]
GO
ALTER TABLE [dbo].[BaoCao]  WITH CHECK ADD  CONSTRAINT [fk_maNVBaoCao] FOREIGN KEY([maNguoiTao])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[BaoCao] CHECK CONSTRAINT [fk_maNVBaoCao]
GO
ALTER TABLE [dbo].[CaLam]  WITH CHECK ADD  CONSTRAINT [fk_maCongNhan] FOREIGN KEY([maCongNhan])
REFERENCES [dbo].[CongNhan] ([maCongNhan])
GO
ALTER TABLE [dbo].[CaLam] CHECK CONSTRAINT [fk_maCongNhan]
GO
ALTER TABLE [dbo].[ChiTietHopDong]  WITH CHECK ADD  CONSTRAINT [fk_maHopDong] FOREIGN KEY([maHopDong])
REFERENCES [dbo].[HopDong] ([maHopDong])
GO
ALTER TABLE [dbo].[ChiTietHopDong] CHECK CONSTRAINT [fk_maHopDong]
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD  CONSTRAINT [fk_maKhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HopDong] CHECK CONSTRAINT [fk_maKhachHang]
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD  CONSTRAINT [fk_maNhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HopDong] CHECK CONSTRAINT [fk_maNhanVien]
GO
ALTER TABLE [dbo].[HopDong]  WITH CHECK ADD  CONSTRAINT [fk_maSanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[HopDong] CHECK CONSTRAINT [fk_maSanPham]
GO
ALTER TABLE [dbo].[NgayNghi]  WITH CHECK ADD  CONSTRAINT [fk_maNgayNghi] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[NgayNghi] CHECK CONSTRAINT [fk_maNgayNghi]
GO
ALTER TABLE [dbo].[PhieuLuongCongNhan]  WITH CHECK ADD  CONSTRAINT [fk_maNguoiHuongCN] FOREIGN KEY([maNguoiHuong])
REFERENCES [dbo].[CongNhan] ([maCongNhan])
GO
ALTER TABLE [dbo].[PhieuLuongCongNhan] CHECK CONSTRAINT [fk_maNguoiHuongCN]
GO
ALTER TABLE [dbo].[PhieuLuongCongNhan]  WITH CHECK ADD  CONSTRAINT [fk_maNguoiTaoCN] FOREIGN KEY([maNguoiTao])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhieuLuongCongNhan] CHECK CONSTRAINT [fk_maNguoiTaoCN]
GO
ALTER TABLE [dbo].[PhieuLuongNhanVien]  WITH CHECK ADD  CONSTRAINT [fk_maNguoiHuongNV] FOREIGN KEY([maNguoiHuong])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhieuLuongNhanVien] CHECK CONSTRAINT [fk_maNguoiHuongNV]
GO
ALTER TABLE [dbo].[PhieuLuongNhanVien]  WITH CHECK ADD  CONSTRAINT [fk_maNguoiTaoNV] FOREIGN KEY([maNguoiTao])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhieuLuongNhanVien] CHECK CONSTRAINT [fk_maNguoiTaoNV]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [fk_maLoaiSanPham] FOREIGN KEY([maLoaiSanPham])
REFERENCES [dbo].[LoaiSanPham] ([maLoaiSanPham])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [fk_maLoaiSanPham]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [fk_maNguoiDungNV] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [fk_maNguoiDungNV]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [fk_maNguoiDungQL] FOREIGN KEY([maQuanLy])
REFERENCES [dbo].[NguoiQuanLyNhanVien] ([maNguoiQL])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [fk_maNguoiDungQL]
GO
ALTER TABLE [dbo].[TangCa]  WITH CHECK ADD  CONSTRAINT [fk_NVTangCa] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[TangCa] CHECK CONSTRAINT [fk_NVTangCa]
GO
USE [master]
GO
ALTER DATABASE [QuanLyLuongSP] SET  READ_WRITE 
GO
