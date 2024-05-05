package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
import ui.DangNhap;

public class HoaDon_DAO {
	public ArrayList<HoaDon> getAllHoaDon() {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			ConnectDB.getIntance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHD = rs.getString("maHoaDon");
				Date ngapLapHD = rs.getDate("ngayLapHD");
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"));
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"));
				HoaDon hd = new HoaDon(maHD, ngapLapHD, kh, nv);
				dsHoaDon.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}
	

	public	ArrayList<HoaDon> getHDTheoNgay(Date ngayBatDau,Date ngayKetThuc) {

		ArrayList<HoaDon> lsHD = new ArrayList<HoaDon>();
		String ngayBD = (ngayBatDau.getYear()+1900) +"/"+ (ngayBatDau.getMonth()+1) +"/"+ngayBatDau.getDate();
		String ngayKT = (ngayKetThuc.getYear()+1900) +"/"+ (ngayKetThuc.getMonth()+1) +"/"+ngayKetThuc.getDate();

		ConnectDB.getIntance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from QuanLyBanVe.[dbo].[HoaDon] where ngayLapHD between '"+ngayBD+"' and '"+ngayKT+"'";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				HoaDon  hd = new HoaDon();
				hd.setMaHoaDon(rs.getString(1));
				hd.setNgayLapHoaDon(rs.getDate(2));
				hd.setNhanVien(new NhanVien(rs.getString(3)));
				hd.setKhachHang(new KhachHang(rs.getString(4)));
				lsHD.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsHD;

	}
	


	public ArrayList<HoaDon> getAllHoaDonWithDetails() {
        ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
        try {
            ConnectDB.getIntance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT hd.*, nv.*, kh.* " +
                         "FROM HoaDon hd " +
                         "INNER JOIN NhanVien nv ON hd.maNhanVien = nv.maNhanVien " +
                         "INNER JOIN KhachHang kh ON hd.maKhachHang = kh.maKhachHang";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString("maHoaDon");
                Date ngapLapHD = rs.getDate("ngayLapHD");
                NhanVien nv = new NhanVien(rs.getString("maNhanVien"));
                nv.setTenNhanVien(rs.getString("tenNhanVien")); 
                KhachHang kh = new KhachHang(rs.getString("maKhachHang"));
                kh.setTenKhachHang(rs.getString("tenKhachHang")); 
                HoaDon hd = new HoaDon(maHD, ngapLapHD, kh, nv);
                dsHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }
	public ArrayList<HoaDon> getHoaDonByDate(String fromDate, String toDate) {
	    ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
	    try {
	        ConnectDB.getIntance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT hd.*, nv.*, kh.* " +
	                     "FROM HoaDon hd " +
	                     "INNER JOIN NhanVien nv ON hd.maNhanVien = nv.maNhanVien " +
	                     "INNER JOIN KhachHang kh ON hd.maKhachHang = kh.maKhachHang " +
	                     "WHERE hd.ngayLapHD >= '" + fromDate + "' AND hd.ngayLapHD <= '" + toDate + "'";
	        Statement statement = con.createStatement();
	        ResultSet rs = statement.executeQuery(sql);
	        while (rs.next()) {
	            String maHD = rs.getString("maHoaDon");
	            Date ngapLapHD = rs.getDate("ngayLapHD");
	            NhanVien nv = new NhanVien(rs.getString("maNhanVien"));
	            nv.setTenNhanVien(rs.getString("tenNhanVien")); 
	            KhachHang kh = new KhachHang(rs.getString("maKhachHang"));
	            kh.setTenKhachHang(rs.getString("tenKhachHang")); 
	            HoaDon hd = new HoaDon(maHD, ngapLapHD, kh, nv);
	            dsHoaDon.add(hd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dsHoaDon;
	}
	public ArrayList<HoaDon> getHoaDonByMaWithDetails(String maHoaDon) {
	    ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
	    try {
	        ConnectDB.getIntance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT hd.*, nv.*, kh.* " +
	                     "FROM HoaDon hd " +
	                     "INNER JOIN NhanVien nv ON hd.maNhanVien = nv.maNhanVien " +
	                     "INNER JOIN KhachHang kh ON hd.maKhachHang = kh.maKhachHang " +
	                     "WHERE hd.maHoaDon = ?";
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, maHoaDon);
	        ResultSet rs = statement.executeQuery();
	        while (rs.next()) {
	            Date ngayLapHD = rs.getDate("ngayLapHD");
	            NhanVien nv = new NhanVien(rs.getString("maNhanVien"));
	            nv.setTenNhanVien(rs.getString("tenNhanVien")); 
	            KhachHang kh = new KhachHang(rs.getString("maKhachHang"));
	            kh.setTenKhachHang(rs.getString("tenKhachHang")); 
	            HoaDon hd = new HoaDon(maHoaDon, ngayLapHD, kh, nv);
	            dsHoaDon.add(hd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dsHoaDon;
	}
	public void themHoaDon(HoaDon hoaDon) {
	    String sqlSelectMaxMaHD = "SELECT MAX(maHoaDon) FROM HoaDon";
	    String sqlInsertHoaDon = "INSERT INTO HoaDon (maHoaDon, ngayLapHD, maNhanVien, maKhachHang) VALUES (?, ?, ?, ?)";
	    String maKhachHang = new KhachHang_DAO().timMaKhachHangTheoSDT(hoaDon.getKhachHang().getSoDienThoai());
	    try (Connection conn = ConnectDB.getConnection();
	         PreparedStatement psSelectMaxMaHD = conn.prepareStatement(sqlSelectMaxMaHD);
	         ResultSet rsMaxMaHD = psSelectMaxMaHD.executeQuery()) {
	        String maHD = generateMaHoaDon(rsMaxMaHD.getString(1)); // Tạo mã hoá đơn mới
	        try (PreparedStatement psInsertHoaDon = conn.prepareStatement(sqlInsertHoaDon)) {
	            psInsertHoaDon.setString(1, maHD);
	            psInsertHoaDon.setDate(2, new java.sql.Date(hoaDon.getNgayLapHoaDon().getTime()));
	            psInsertHoaDon.setString(3, DangNhap.maNhanVien);
	            psInsertHoaDon.setString(4, maKhachHang);
	            psInsertHoaDon.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


    // Phương thức sinh mã hoá đơn mới
    private String generateMaHoaDon(String maxMaHoaDon) {
        String newMaHoaDon = "HD0001"; // Mã hoá đơn mặc định nếu không có hóa đơn nào trong cơ sở dữ liệu
        if (maxMaHoaDon != null) {
            // Tách số từ mã hoá đơn hiện tại và tăng giá trị lên 1
            int number = Integer.parseInt(maxMaHoaDon.substring(2)) + 1;
            // Format lại chuỗi số với độ dài 4 ký tự và thêm vào "HD"
            newMaHoaDon = String.format("HD%04d", number);
        }
        return newMaHoaDon;
    }

}