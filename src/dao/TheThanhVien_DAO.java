package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

/**
 * 
 * @author Daddy_Tan
 */
	
//	public int insertTheThanhVien(TheThanhVien ttv)
//	{
//		try {
//			ConnectDB.getIntance();
//			Connection con = ConnectDB.getConnection();
//			String sql = "INSERT INTO TheThanhVien (maTTV, ngayDangKy, loai, diemTichLuy, maKhachHang) VALUES ('" + ttv.getMaTheThanhVien() + "', '" + ttv.getNgayDangKy() + "', '" + ttv.getLoai() + "', '" + ttv.getDiemTichLuy() + "', '" + ttv.getKhachHang().getMaKhachHang() + "')";
//			
//			Statement st = con.createStatement();			
//			int kq = st.executeUpdate(sql);
//			
//			System.out.println("Bạn đã dùng lệnh:"+sql);
//			
//			System.out.println("có "+kq+" bị thay đổi");
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//		
//	}
	public void insertTheThanhVien(TheThanhVien ttv) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
          
            con = ConnectDB.getIntance().getConnection();
            
        
            String sql = "INSERT INTO TheThanhVien (maTTV, ngayDangKy, loai, diemTichLuy, maKhachHang) VALUES (?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            
         
            pstmt.setString(1, ttv.getMaTheThanhVien());
            pstmt.setDate(2, new java.sql.Date(ttv.getNgayDangKy().getTime()));
            pstmt.setString(3, ttv.getLoai());
            pstmt.setDouble(4, ttv.getDiemTichLuy());
            pstmt.setString(5, ttv.getKhachHang().getMaKhachHang());
            
           
            pstmt.executeUpdate();
            
            System.out.println("Thêm thành viên thành công.");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm thành viên: " + e.getMessage());
        } finally {
         
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
