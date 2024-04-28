package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTiet_HoaDon;
import entity.HoaDon;
import entity.Ve;

public class ChiTietHoaDon_DAO {
	public ArrayList<ChiTiet_HoaDon> getAllChiTietHoaDon() {
		ArrayList<ChiTiet_HoaDon> dsChiTietHoaDon = new ArrayList<ChiTiet_HoaDon>();
		try {
			ConnectDB.getIntance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from ChiTietHoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Integer soLuong = rs.getInt("soLuong");
				HoaDon hd = new HoaDon(rs.getString("maHoaDon"));
				Ve v = new Ve(rs.getString("maVe"));
				ChiTiet_HoaDon cthd = new ChiTiet_HoaDon(soLuong, hd, v);
				dsChiTietHoaDon.add(cthd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsChiTietHoaDon;
	}
}
