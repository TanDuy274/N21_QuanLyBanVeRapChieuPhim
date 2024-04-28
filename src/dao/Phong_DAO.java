package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Phong;

public class Phong_DAO {
	public ArrayList<Phong> getAllPhong() {
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		try {
			ConnectDB.getIntance();
			Connection con  = ConnectDB.getConnection();
			String sql = "select * from Phong";
			Statement statement = con .createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maPhong = rs.getString("maPhong");
				Integer soLuong = rs.getInt("soLuongGhe");
				String tenPhong = rs.getString("tenPhong");
				Phong p = new Phong(maPhong, tenPhong, soLuong);
				dsPhong.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhong;
	}
}
