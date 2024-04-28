package entity;

public class ChiTiet_HoaDon {
	private int soLuong;
	private HoaDon hoaDon;
	private Ve ve;
	public ChiTiet_HoaDon() {
		
	}
	public ChiTiet_HoaDon(int soLuong, HoaDon hoaDon, Ve ve) {
		super();
		this.soLuong = soLuong;
		this.hoaDon = hoaDon;
		this.ve = ve;
	}

	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public Ve getVe() {
		return ve;
	}
	public void setVe(Ve ve) {
		this.ve = ve;
	}
	
	public double tongTien() {
		return 0;

	}
	
	public double tongGiaTien() { // có tính thuế các kiểu
		return 0;
	}
	@Override
	public String toString() {
		return "ChiTiet_HoaDon [soLuong=" + soLuong + ", hoaDon=" + hoaDon + ", ve=" + ve + "]";
	}
	
	
}
