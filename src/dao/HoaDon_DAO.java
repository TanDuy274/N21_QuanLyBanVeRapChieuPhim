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


}
