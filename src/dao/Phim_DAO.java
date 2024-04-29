package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.LoaiPhim;
import entity.Phim;

public class Phim_DAO {
	public ArrayList<Phim> getAllPhim() {
		ArrayList<Phim> dsPhim = new ArrayList<Phim>();
		try {
			ConnectDB.getIntance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Phim";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maPhim = rs.getString("maPhim");
				String tenPhim = rs.getString("tenPhim");
				Date ngayKhoiChieu = rs.getDate("ngayKhoiChieu");
				Double thoiLuong = rs.getDouble("thoiLuong");
				String ngonNgu = rs.getString("ngonNgu");
				Integer gioiHanTuoi = rs.getInt("gioiHanDoTuoi");
				Integer trangThai =  rs.getInt("trangThai");
				String poster = rs.getString("poster");
				Double giaTien = rs.getDouble("giaTien");
				LoaiPhim lp = new LoaiPhim(rs.getString("maLoaiPhim"));
				Phim p = new Phim(maPhim, tenPhim, ngonNgu, ngayKhoiChieu, thoiLuong, giaTien, gioiHanTuoi, trangThai == 1 ? true : false, poster, lp);
				dsPhim.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhim;
	}
	
	public ArrayList<Phim> getPhimByTen(String ten) {
		ArrayList<Phim> dsPhim = new ArrayList<Phim>();
		PreparedStatement statement = null;
		try {
			ConnectDB.getIntance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Phim where tenPhim like ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + ten + "%");
//			statement.setString(1, ten);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maPhim = rs.getString("maPhim");
				String tenPhim = rs.getString("tenPhim");
				Date ngayKhoiChieu = rs.getDate("ngayKhoiChieu");
				Double thoiLuong = rs.getDouble("thoiLuong");
				String ngonNgu = rs.getString("ngonNgu");
				Integer gioiHanTuoi = rs.getInt("gioiHanDoTuoi");
				Integer trangThai =  rs.getInt("trangThai");
				String poster = rs.getString("poster");
				Double giaTien = rs.getDouble("giaTien");
				LoaiPhim lp = new LoaiPhim(rs.getString("maLoaiPhim"));
				Phim p = new Phim(maPhim, tenPhim, ngonNgu, ngayKhoiChieu, thoiLuong, giaTien, gioiHanTuoi, trangThai == 1 ? true : false, poster, lp);
				dsPhim.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhim;
	}
	
	public ArrayList<Phim> getPhimByLoaiPhim(String loaiPhim) {
		ArrayList<Phim> dsPhim = new ArrayList<Phim>();
		PreparedStatement statement = null;
		try {
			ConnectDB.getIntance();
			Connection con = ConnectDB.getConnection();
			String sql = "select p.* from Phim p join LoaiPhim lp on p.maLoaiPhim = lp.maLoaiPhim "
					+ "where lp.tenLoaiPhim = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, loaiPhim);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maPhim = rs.getString("maPhim");
				String tenPhim = rs.getString("tenPhim");
				Date ngayKhoiChieu = rs.getDate("ngayKhoiChieu");
				Double thoiLuong = rs.getDouble("thoiLuong");
				String ngonNgu = rs.getString("ngonNgu");
				Integer gioiHanTuoi = rs.getInt("gioiHanDoTuoi");
				Integer trangThai =  rs.getInt("trangThai");
				String poster = rs.getString("poster");
				Double giaTien = rs.getDouble("giaTien");
				LoaiPhim lp = new LoaiPhim(rs.getString("maLoaiPhim"));
				Phim p = new Phim(maPhim, tenPhim, ngonNgu, ngayKhoiChieu, thoiLuong, giaTien, gioiHanTuoi, trangThai == 1 ? true : false, poster, lp);
				dsPhim.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhim;
	}
		
}
