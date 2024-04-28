package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.ChiTietPhim;
import entity.Phim;
import entity.Phong;

public class ChiTietPhim_DAO {
	public ArrayList<ChiTietPhim> getAllChiTietPhim() {
		ArrayList<ChiTietPhim> dsChiTietPhim = new ArrayList<ChiTietPhim>();
		try {
			ConnectDB.getIntance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from ChiTietPhim";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Date lichChieu = rs.getDate("lichChieu");
				Phim phim = new Phim(rs.getString("maPhim"));
				Phong phong =  new Phong(rs.getString("maPhong"));
				ChiTietPhim ctp = new ChiTietPhim(lichChieu, phim, phong);
				dsChiTietPhim.add(ctp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsChiTietPhim;
	}
}
