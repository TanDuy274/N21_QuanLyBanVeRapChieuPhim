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



}
