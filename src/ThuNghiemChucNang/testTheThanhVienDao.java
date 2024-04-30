package ThuNghiemChucNang;

import java.sql.SQLException;
import java.util.Date;

import connectDB.ConnectDB;
import dao.TheThanhVien_DAO;
import entity.KhachHang;
import entity.TheThanhVien;

public class testTheThanhVienDao {
    public static void main(String[] args) {
        try {
            ConnectDB.getIntance().connect();
            KhachHang khachHang = new KhachHang();
            khachHang.setMaKhachHang("KH002");
            Date currentDate = new Date();
            TheThanhVien ttv = new TheThanhVien("TTV003", "VIP PRO MAX", currentDate, 1, khachHang);
            TheThanhVien_DAO ttvDao = new TheThanhVien_DAO();           
            ttvDao.insertTheThanhVien(ttv); 
            ConnectDB.getIntance().disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
