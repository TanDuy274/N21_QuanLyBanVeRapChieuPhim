package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.TheThanhVien;

public class TheThanhVien_DAO {
	public ArrayList<TheThanhVien> getAllTheThanhVien() {
		ArrayList<TheThanhVien> dsTTV = new ArrayList<TheThanhVien>();
		try {
			ConnectDB.getIntance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TheThanhVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maTTV = rs.getString("maTTV");
				Date ngayDK = rs.getDate("ngayDangKy");
				String loai = rs.getString("loai");
				Double diemTL = rs.getDouble("diemTichLuy");
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"));
				TheThanhVien ttv = new TheThanhVien(maTTV, loai, ngayDK, diemTL, kh);
				dsTTV.add(ttv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTTV;
	}
	
}
