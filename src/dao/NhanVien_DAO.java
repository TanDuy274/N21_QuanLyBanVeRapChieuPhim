package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {
	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			ConnectDB.getIntance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maNV = rs.getString("maNhanVien");
				Date ngayVaoLam = rs.getDate("ngayVaoLam");
				Double luong = rs.getDouble("luong");
				String tenNV = rs.getString("tenNhanVien");
				Integer tuoi = rs.getInt("tuoi");
				String soDT = rs.getString("soDienThoai");
				NhanVien nv = new NhanVien(maNV, tenNV, soDT, ngayVaoLam, luong, tuoi);
				dsNhanVien.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}
	
}
