USE [master]
GO
/****** Object:  Database [QuanLyBanVe]    Script Date: 28/04/2024 8:29:20 PM ******/
CREATE DATABASE [QuanLyBanVe]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyBanVe', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QuanLyBanVe.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyBanVe_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\QuanLyBanVe_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyBanVe].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyBanVe] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QuanLyBanVe] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyBanVe] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyBanVe] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyBanVe] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyBanVe] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyBanVe] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyBanVe] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyBanVe] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyBanVe] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyBanVe] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyBanVe] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyBanVe] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyBanVe] SET QUERY_STORE = ON
GO
ALTER DATABASE [QuanLyBanVe] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QuanLyBanVe]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 28/04/2024 8:29:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[soLuong] [int] NOT NULL,
	[maHoaDon] [nchar](10) NOT NULL,
	[maVe] [nchar](10) NOT NULL,
 CONSTRAINT [ChiTietHoaDon_PK] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC,
	[maVe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhim]    Script Date: 28/04/2024 8:29:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhim](
	[lichChieu] [date] NULL,
	[maPhim] [nchar](10) NOT NULL,
	[maPhong] [nchar](10) NOT NULL,
 CONSTRAINT [ChiTietPhim_PK] PRIMARY KEY CLUSTERED 
(
	[maPhim] ASC,
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ghe]    Script Date: 28/04/2024 8:29:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ghe](
	[maGhe] [nchar](10) NOT NULL,
	[trangThai] [int] NULL,
	[tenGhe] [nchar](10) NULL,
	[maPhong] [nchar](10) NOT NULL,
 CONSTRAINT [Ghe_PK] PRIMARY KEY CLUSTERED 
(
	[maGhe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 28/04/2024 8:29:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nchar](10) NOT NULL,
	[tongTien] [money] NULL,
	[ngayLapHD] [date] NULL,
	[maNhanVien] [nchar](10) NOT NULL,
	[maKhachHang] [nchar](10) NOT NULL,
 CONSTRAINT [HoaDon_PK] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 28/04/2024 8:29:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nchar](10) NOT NULL,
	[hasTheThanhVien] [int] NULL,
	[tenKhachHang] [nvarchar](50) NULL,
	[tuoi] [int] NULL,
	[soDienThoai] [nchar](10) NULL,
 CONSTRAINT [KhachHang_PK] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiPhim]    Script Date: 28/04/2024 8:29:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhim](
	[maLoaiPhim] [nchar](10) NOT NULL,
	[tenLoaiPhim] [nvarchar](50) NULL,
	[moTa] [nvarchar](50) NULL,
 CONSTRAINT [LoaiPhim_PK] PRIMARY KEY CLUSTERED 
(
	[maLoaiPhim] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 28/04/2024 8:29:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nchar](10) NOT NULL,
	[ngayVaoLam] [date] NULL,
	[luong] [money] NULL,
	[tenNhanVien] [nvarchar](50) NULL,
	[tuoi] [int] NULL,
	[soDienThoai] [nchar](10) NULL,
 CONSTRAINT [NhanVien_PK] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phim]    Script Date: 28/04/2024 8:29:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phim](
	[maPhim] [nchar](10) NOT NULL,
	[tenPhim] [nvarchar](50) NULL,
	[ngayKhoiChieu] [date] NULL,
	[thoiLuong] [float] NULL,
	[ngonNgu] [nchar](20) NULL,
	[gioiHanDoTuoi] [int] NULL,
	[trangThai] [int] NULL,
	[giaTien] [money] NULL,
	[maLoaiPhim] [nchar](10) NOT NULL,
	[poster] [nvarchar](100) NULL,
 CONSTRAINT [Phim_PK] PRIMARY KEY CLUSTERED 
(
	[maPhim] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 28/04/2024 8:29:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [nchar](10) NOT NULL,
	[soLuongGhe] [int] NULL,
	[tenPhong] [nchar](10) NULL,
 CONSTRAINT [Phong_PK] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 28/04/2024 8:29:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[id] [int] IDENTITY(1,1000) NOT NULL,
	[taiKhoan] [nchar](10) NULL,
	[matKhau] [nchar](10) NULL,
	[ngayTao] [date] NULL,
	[isNhanVien] [int] NULL,
 CONSTRAINT [TaiKhoan_PK] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TheThanhVien]    Script Date: 28/04/2024 8:29:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TheThanhVien](
	[maTTV] [nchar](10) NOT NULL,
	[ngayDangky] [date] NULL,
	[loai] [nchar](20) NULL,
	[diemTichLuy] [float] NULL,
	[maKhachHang] [nchar](10) NOT NULL,
 CONSTRAINT [TheThanhVien_PK] PRIMARY KEY CLUSTERED 
(
	[maTTV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ve]    Script Date: 28/04/2024 8:29:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ve](
	[maVe] [nchar](10) NOT NULL,
	[moTa] [nvarchar](50) NULL,
	[giaTien] [money] NULL,
	[maPhim] [nchar](10) NOT NULL,
	[maGhe] [nchar](10) NOT NULL,
 CONSTRAINT [Ve_PK] PRIMARY KEY CLUSTERED 
(
	[maVe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietHoaDon] ([soLuong], [maHoaDon], [maVe]) VALUES (2, N'HD001     ', N'VE001     ')
INSERT [dbo].[ChiTietHoaDon] ([soLuong], [maHoaDon], [maVe]) VALUES (3, N'HD002     ', N'VE002     ')
GO
INSERT [dbo].[ChiTietPhim] ([lichChieu], [maPhim], [maPhong]) VALUES (CAST(N'2023-01-01' AS Date), N'PH001     ', N'P001      ')
INSERT [dbo].[ChiTietPhim] ([lichChieu], [maPhim], [maPhong]) VALUES (CAST(N'2023-01-02' AS Date), N'PH002     ', N'P002      ')
GO
INSERT [dbo].[Ghe] ([maGhe], [trangThai], [tenGhe], [maPhong]) VALUES (N'GH001     ', 1, N'Ghe VIP   ', N'P001      ')
INSERT [dbo].[Ghe] ([maGhe], [trangThai], [tenGhe], [maPhong]) VALUES (N'GH002     ', 1, N'Ghe thuong', N'P002      ')
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [tongTien], [ngayLapHD], [maNhanVien], [maKhachHang]) VALUES (N'HD001     ', 1500000.0000, CAST(N'2023-05-20' AS Date), N'NV001     ', N'KH001     ')
INSERT [dbo].[HoaDon] ([maHoaDon], [tongTien], [ngayLapHD], [maNhanVien], [maKhachHang]) VALUES (N'HD002     ', 2000000.0000, CAST(N'2023-06-10' AS Date), N'NV002     ', N'KH002     ')
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [hasTheThanhVien], [tenKhachHang], [tuoi], [soDienThoai]) VALUES (N'KH001     ', 1, N'Nguyen Van C', 35, N'0123456789')
INSERT [dbo].[KhachHang] ([maKhachHang], [hasTheThanhVien], [tenKhachHang], [tuoi], [soDienThoai]) VALUES (N'KH002     ', 0, N'Tran Thi D', 40, N'0987654321')
GO
INSERT [dbo].[LoaiPhim] ([maLoaiPhim], [tenLoaiPhim], [moTa]) VALUES (N'LP001     ', N'Hành động', N'Phim có nhi?u c?nh hành d?ng gay c?n')
INSERT [dbo].[LoaiPhim] ([maLoaiPhim], [tenLoaiPhim], [moTa]) VALUES (N'LP002     ', N'Tình cảm', N'Những câu chuyện về tình yêu')
INSERT [dbo].[LoaiPhim] ([maLoaiPhim], [tenLoaiPhim], [moTa]) VALUES (N'LP003     ', N'Hài hước', N'Tình huống dở khóc dở cười')
INSERT [dbo].[LoaiPhim] ([maLoaiPhim], [tenLoaiPhim], [moTa]) VALUES (N'LP004     ', N'Tâm lý', N'Khám phá sâu vào tâm trí và tâm lý của nhân vật')
INSERT [dbo].[LoaiPhim] ([maLoaiPhim], [tenLoaiPhim], [moTa]) VALUES (N'LP005     ', N'Hoạt hình', N'Thế giởi ảo, cảm xúc thật')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [ngayVaoLam], [luong], [tenNhanVien], [tuoi], [soDienThoai]) VALUES (N'NV001     ', CAST(N'2023-05-15' AS Date), 5000000.0000, N'Nguyen Van A', 30, N'0123456789')
INSERT [dbo].[NhanVien] ([maNhanVien], [ngayVaoLam], [luong], [tenNhanVien], [tuoi], [soDienThoai]) VALUES (N'NV002     ', CAST(N'2022-10-20' AS Date), 6000000.0000, N'Tran Thi B', 25, N'0987654321')
GO
INSERT [dbo].[Phim] ([maPhim], [tenPhim], [ngayKhoiChieu], [thoiLuong], [ngonNgu], [gioiHanDoTuoi], [trangThai], [giaTien], [maLoaiPhim], [poster]) VALUES (N'PH001     ', N'Avengers: Endgame', CAST(N'2022-12-31' AS Date), 180, N'Tieng Anh           ', 13, 1, 100000.0000, N'LP001     ', N'avengers-endgame.jpg')
INSERT [dbo].[Phim] ([maPhim], [tenPhim], [ngayKhoiChieu], [thoiLuong], [ngonNgu], [gioiHanDoTuoi], [trangThai], [giaTien], [maLoaiPhim], [poster]) VALUES (N'PH002     ', N'Cái giá của hạnh phúc', CAST(N'2024-04-19' AS Date), 115, N'Tieng Viet          ', 18, 1, 120000.0000, N'LP002     ', N'cai-gia-cua-hanh-phuc.jpg')
INSERT [dbo].[Phim] ([maPhim], [tenPhim], [ngayKhoiChieu], [thoiLuong], [ngonNgu], [gioiHanDoTuoi], [trangThai], [giaTien], [maLoaiPhim], [poster]) VALUES (N'PH003     ', N'Lật mật 7', CAST(N'2024-04-25' AS Date), 138, N'Tieng Viet          ', 13, 1, 120000.0000, N'LP004     ', N'lat-mat-7.jpg')
INSERT [dbo].[Phim] ([maPhim], [tenPhim], [ngayKhoiChieu], [thoiLuong], [ngonNgu], [gioiHanDoTuoi], [trangThai], [giaTien], [maLoaiPhim], [poster]) VALUES (N'PH004     ', N'Mèo mập mang 10 mạng', CAST(N'2024-04-26' AS Date), 88, N'Tieng Anh           ', NULL, 1, 80000.0000, N'LP005     ', N'meo-map-mang-10-mang.jpg')
GO
INSERT [dbo].[Phong] ([maPhong], [soLuongGhe], [tenPhong]) VALUES (N'P001      ', 100, N'Phòng 1   ')
INSERT [dbo].[Phong] ([maPhong], [soLuongGhe], [tenPhong]) VALUES (N'P002      ', 80, N'Phòng 2   ')
GO
SET IDENTITY_INSERT [dbo].[TaiKhoan] ON 

INSERT [dbo].[TaiKhoan] ([id], [taiKhoan], [matKhau], [ngayTao], [isNhanVien]) VALUES (1001, N'NV001     ', N'password01', CAST(N'2023-01-10' AS Date), 1)
INSERT [dbo].[TaiKhoan] ([id], [taiKhoan], [matKhau], [ngayTao], [isNhanVien]) VALUES (2001, N'NV002     ', N'password02', CAST(N'2023-02-15' AS Date), 1)
SET IDENTITY_INSERT [dbo].[TaiKhoan] OFF
GO
INSERT [dbo].[TheThanhVien] ([maTTV], [ngayDangky], [loai], [diemTichLuy], [maKhachHang]) VALUES (N'TTV001    ', CAST(N'2022-12-01' AS Date), N'VIP                 ', 500, N'KH001     ')
INSERT [dbo].[TheThanhVien] ([maTTV], [ngayDangky], [loai], [diemTichLuy], [maKhachHang]) VALUES (N'TTV002    ', CAST(N'2023-01-20' AS Date), N'Standard            ', 200, N'KH002     ')
GO
INSERT [dbo].[Ve] ([maVe], [moTa], [giaTien], [maPhim], [maGhe]) VALUES (N'VE001     ', N'Ve VIP', 200000.0000, N'PH001     ', N'GH001     ')
INSERT [dbo].[Ve] ([maVe], [moTa], [giaTien], [maPhim], [maGhe]) VALUES (N'VE002     ', N'Ve thuong', 150000.0000, N'PH002     ', N'GH002     ')
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [ChiTietHoaDon_HoaDon_FK] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [ChiTietHoaDon_HoaDon_FK]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [ChiTietHoaDon_Ve_FK] FOREIGN KEY([maVe])
REFERENCES [dbo].[Ve] ([maVe])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [ChiTietHoaDon_Ve_FK]
GO
ALTER TABLE [dbo].[ChiTietPhim]  WITH CHECK ADD  CONSTRAINT [ChiTietPhim_Phim_FK] FOREIGN KEY([maPhim])
REFERENCES [dbo].[Phim] ([maPhim])
GO
ALTER TABLE [dbo].[ChiTietPhim] CHECK CONSTRAINT [ChiTietPhim_Phim_FK]
GO
ALTER TABLE [dbo].[ChiTietPhim]  WITH CHECK ADD  CONSTRAINT [ChiTietPhim_Phong_FK] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[ChiTietPhim] CHECK CONSTRAINT [ChiTietPhim_Phong_FK]
GO
ALTER TABLE [dbo].[Ghe]  WITH CHECK ADD  CONSTRAINT [Ghe_Phong_FK] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[Ghe] CHECK CONSTRAINT [Ghe_Phong_FK]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [HoaDon_KhachHang_FK] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [HoaDon_KhachHang_FK]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [HoaDon_NhanVien_FK] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [HoaDon_NhanVien_FK]
GO
ALTER TABLE [dbo].[Phim]  WITH CHECK ADD  CONSTRAINT [Phim_LoaiPhim_FK] FOREIGN KEY([maLoaiPhim])
REFERENCES [dbo].[LoaiPhim] ([maLoaiPhim])
GO
ALTER TABLE [dbo].[Phim] CHECK CONSTRAINT [Phim_LoaiPhim_FK]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [TaiKhoan_NhanVien_FK] FOREIGN KEY([taiKhoan])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [TaiKhoan_NhanVien_FK]
GO
ALTER TABLE [dbo].[TheThanhVien]  WITH CHECK ADD  CONSTRAINT [TheThanhVien_KhachHang_FK] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[TheThanhVien] CHECK CONSTRAINT [TheThanhVien_KhachHang_FK]
GO
ALTER TABLE [dbo].[Ve]  WITH CHECK ADD  CONSTRAINT [Ve_Ghe_Fk] FOREIGN KEY([maGhe])
REFERENCES [dbo].[Ghe] ([maGhe])
GO
ALTER TABLE [dbo].[Ve] CHECK CONSTRAINT [Ve_Ghe_Fk]
GO
ALTER TABLE [dbo].[Ve]  WITH CHECK ADD  CONSTRAINT [Ve_Phim_FK] FOREIGN KEY([maPhim])
REFERENCES [dbo].[Phim] ([maPhim])
GO
ALTER TABLE [dbo].[Ve] CHECK CONSTRAINT [Ve_Phim_FK]
GO
USE [master]
GO
ALTER DATABASE [QuanLyBanVe] SET  READ_WRITE 
GO
