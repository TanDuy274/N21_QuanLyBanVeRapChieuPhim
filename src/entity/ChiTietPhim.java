package entity;

import java.util.Date;

public class ChiTietPhim {
	private Date lichChieu;
	private Phim phim;
	private Phong phong;
	public ChiTietPhim() {
		
	}
	public ChiTietPhim(Date lichChieu, Phim phim, Phong phong) {
		super();
		this.lichChieu = lichChieu;
		this.phim = phim;
		this.phong = phong;
	}
	public Date getLichChieu() {
		return lichChieu;
	}
	public void setLichChieu(Date lichChieu) {
		this.lichChieu = lichChieu;
	}
	public Phim getPhim() {
		return phim;
	}
	public void setPhim(Phim phim) {
		this.phim = phim;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	@Override
	public String toString() {
		return "ChiTietPhim [lichChieu=" + lichChieu + ", phim=" + phim + ", phong=" + phong + "]";
	}
	
}
