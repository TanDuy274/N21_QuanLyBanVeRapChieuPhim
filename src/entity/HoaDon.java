package entity;

import java.util.Date;

public class HoaDon {
	private String maHoaDon;
	private Date ngayLapHoaDon;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	public HoaDon() {
		
	}
	
	public HoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public HoaDon(String maHoaDon, Date ngayLapHoaDon, KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
//	public double tongTien() {
//		return 0;
//		
//	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", khachHang=" + khachHang
				+ ", nhanVien=" + nhanVien + "]";
	}
	
	
}
