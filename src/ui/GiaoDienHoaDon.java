package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaoDienHoaDon extends JFrame{
	private JLabel lblTitle;
	private JLabel lblDiachi;
	private JLabel lblTitle2;
	private JLabel lblMaHD;
	private JLabel lblThuNgan;
	private JLabel lblKH;
	private JTextField txtMaHD;
	private Object txtThuNgan;
	private JTextField txtKH;
	private JPanel pnTitle;
	private JPanel pnTitle2;
	private JPanel pnMain;

	public GiaoDienHoaDon() {
		setSize(400, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		lblTitle = new JLabel("Cinema ABC");
		lblDiachi = new JLabel("50 Nguyễn Thái Sơn, Gò Vấp, Hồ Chí Minh");
		lblTitle2 = new JLabel("HÓA ĐƠN");
		lblMaHD = new JLabel("Mã hóa đơn");
		lblThuNgan = new JLabel("Thu ngân:");
		lblKH = new JLabel("Khách hàng - ĐT:");
		txtMaHD = new JTextField("HD123");
		txtThuNgan = new JTextField("Nhân viên ẩn danh");
		txtKH =  new JTextField();
		
		pnTitle = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
		pnTitle2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
	
		Box box = Box.createVerticalBox();
		box.add(pnTitle);
//		box.add(lblDiachi);
//		box.add(pnTitle2);
//		box.add(lblMaHD);
		
		pnMain = new JPanel();
		pnMain.add(box);
		
//		add
		add(pnMain, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new GiaoDienHoaDon().setVisible(true);
	}
}
