package ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import connectDB.ConnectDB;
import dao.ChiTietPhim_DAO;
import dao.Phim_DAO;
import dao.Phong_DAO;
import entity.ChiTietPhim;
import entity.Phim;
import entity.Phong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GiaoDienChonThoiGian2 extends JPanel implements ActionListener {
	public static String soPhong;
	public static String thoiGian;
	public static String suatChieu;

	private static int widthImg = 380;
	private static int heightImg = 500;
	JButton currentSelectedButton = null;
	private static JLabel lblTitle;
	private ImageIcon phimDoremon;
	private Object scaled7;
	private static JLabel lblPhimDoremon;
	private JButton btnSuatChieu1;
	private JPanel pnSuatChieu;
	private JButton btnSuatChieu2;
	private JButton btnSuatChieu3;
	private JButton btnSuatChieu4;
	private JButton btnSuatChieu5;
	private JButton btnSuatChieu6;
	private JButton btnSuatChieu7;
	private JButton btnSuatChieu8, btnSuatChieu9, btnSuatChieu10, btnSuatChieu11, btnSuatChieu12, btnSuatChieu13,
			btnSuatChieu14, btnSuatChieu15, btnSuatChieu16, btnSuatChieu17, btnSuatChieu18, btnSuatChieu19,
			btnSuatChieu20, btnSuatChieu21, btnSuatChieu22, btnSuatChieu23, btnSuatChieu24;
	private JButton btnNgay1;
	private JPanel pnNgay;
	private JPanel pnThoiGian;
	private JButton btnNgay2;
	private JButton btnNgay3;
	private JButton btnNgay4;
	private JButton btnNgay5;
	private JButton btnNgay6;
	private JButton btnNgay7;
	private JButton btnNgay8;
	private JLabel lblNgay1;
	private JLabel lblThu1;
	private JPanel pnTg1;
	private JPanel pnTg2;
	private JLabel lblNgay2;
	private JLabel lblThu2;
	private JLabel lblNgay3;
	private JPanel pnTg3;
	private JLabel lblThu3;
	private JPanel pnTg4;
	private JLabel lblNgay4;
	private JLabel lblThu4;
	private JPanel pnTg5;
	private JLabel lblNgay5;
	private JLabel lblThu5;
	private JPanel pnTg6;
	private JLabel lblNgay6;
	private JLabel lblThu6;
	private JPanel pnTg7;
	private JLabel lblThu7;
	private JLabel lblNgay7;
	private JPanel pnTg8;
	private JLabel lblThu8;
	private JLabel lblNgay8;
	private JPanel pnPhong;
	private JButton btnRap1, btnRap2, btnRap3, btnRap4, btnRap5, btnRap6, btnRap7, btnRap8;
	private JPanel pnThongTin;
	private JLabel lblSoPhong;
	private JLabel lblSoSuatChieu;
	private JLabel lblSoThoiGian;
	private JTextField txtSoPhong;
	private JTextField txtSoSuatChieu;
	private JTextField txtSoThoiGian;

	private JButton btnTest;
	private static GiaoDienChonPhim gdChonPhim;
	private static String duongDanHinhAnh;

	private Phim_DAO phimDAO;
	private Phong_DAO phongDAO;
	private ChiTietPhim_DAO ctpDAO;

	JButton btnChonPhong[];
	JButton btnChonNgay[];
	JButton btnChonSuat[];

	private Set<String> tenPhongSet;
	private Set<String> ngChieuSet;
	private Set<String> giChieuSet;

	public GiaoDienChonThoiGian2() {

		try {
			ConnectDB.getIntance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		phimDAO = new Phim_DAO();
		phongDAO = new Phong_DAO();
		ctpDAO = new ChiTietPhim_DAO();

		setLayout(new BorderLayout());
		gdChonPhim = new GiaoDienChonPhim();

		lblTitle = new JLabel("Phim:");

		Font font = lblTitle.getFont();
		Font newFont = font.deriveFont(Font.BOLD, 22);
		lblTitle.setFont(newFont);

		JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		titlePanel.add(lblTitle);

		duongDanHinhAnh = "img/3_hiepsimongmo.jpg";

		ImageIcon imageIcon = new ImageIcon(duongDanHinhAnh);
		lblPhimDoremon = new JLabel(imageIcon);
		lblPhimDoremon.setIcon(resizeImageIcon(imageIcon, widthImg, heightImg));

		JPanel imagePanel = new JPanel();
		imagePanel.add(lblPhimDoremon);
		add(imagePanel, BorderLayout.WEST);

		// Khởi tạo các Set
		tenPhongSet = new HashSet<>();
		ngChieuSet = new HashSet<>();
		giChieuSet = new HashSet<>();

		// get suất chiếu
//		List<ChiTietPhim> ctpList = ctpDAO.getChiTietPhimByMaPhong(phimDAO.getMaTheoTenPhim(gdChonPhim.getMaPhim()));	
		List<ChiTietPhim> ctpList = ctpDAO.getChiTietPhimByMaPhim("PH003");
		for (ChiTietPhim chiTietPhim : ctpList) {
			Phim phim = phimDAO.getPhimTheoMa(chiTietPhim.getPhim().getMaPhim());
			Phong phong = phongDAO.getPhongTheoMa(chiTietPhim.getPhong().getMaPhong());

			LocalDateTime lichChieu = chiTietPhim.getLichChieu();
			LocalDateTime gioKetThuc = lichChieu.plusMinutes((long) phim.getThoiLuong());

			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

			String ngayChieu = dateFormat.format(lichChieu);
			String gioChieu = timeFormat.format(lichChieu);
			String gioKetThucStr = timeFormat.format(gioKetThuc);

			tenPhongSet.add(phong.getTenPhong());
			ngChieuSet.add(ngayChieu);
			giChieuSet.add(gioChieu + " - " + gioKetThucStr);

		}

		pnPhong = new JPanel();
		for (String tenPhong : tenPhongSet) {
			JButton btnPhong = new JButton(tenPhong);
			btnPhong.setPreferredSize(new Dimension(120, 50));
			btnPhong.setBackground(Color.ORANGE);
			btnPhong.addActionListener(this);
			pnPhong.add(btnPhong);
		}

		// Tạo JPanel cho ngày
		pnNgay = new JPanel();
		for (String ngChieu : ngChieuSet) {
			JButton btnNgay = new JButton(ngChieu);
			btnNgay.setPreferredSize(new Dimension(120, 50));
			btnNgay.setBackground(Color.ORANGE);
			btnNgay.addActionListener(this);
			pnNgay.add(btnNgay);
		}

		// Tạo JPanel cho suất chiếu
		pnSuatChieu = new JPanel();
		for (String giChieu : giChieuSet) {
			JButton btnSuatChieu = new JButton(giChieu);
			btnSuatChieu.setPreferredSize(new Dimension(120, 50));
			btnSuatChieu.setBackground(Color.ORANGE);
			btnSuatChieu.addActionListener(this);
			pnSuatChieu.add(btnSuatChieu);
		}

		// hết suất
//		btnSuatChieu1.setBackground(new Color(0, 153, 255));
//		btnSuatChieu2.setBackground(new Color(0, 153, 255));
//		btnSuatChieu3.setBackground(new Color(0, 153, 255));
//		btnSuatChieu4.setBackground(new Color(0, 153, 255));
//		btnSuatChieu5.setBackground(new Color(0, 153, 255));
//		btnSuatChieu1.setEnabled(false);
//		btnSuatChieu2.setEnabled(false);
//		btnSuatChieu3.setEnabled(false);
//		btnSuatChieu4.setEnabled(false);
//		btnSuatChieu5.setEnabled(false);
//		btnSuatChieu1.setForeground(Color.darkGray);

		pnThongTin = new JPanel(new GridLayout(3, 2));
		lblSoPhong = new JLabel("Phòng đã chọn");
		txtSoPhong = new JTextField(30);

		lblSoSuatChieu = new JLabel("Suất chiếu đã chọn");
		txtSoSuatChieu = new JTextField(30);
		lblSoThoiGian = new JLabel("Thời gian đã chọn");
		txtSoThoiGian = new JTextField(30);

		// Đặt font cho các nhãn và ô nhập liệu
		Font font1 = new Font("Arial", Font.BOLD, 15);
		lblSoPhong.setFont(font1);
		lblSoSuatChieu.setFont(font1);
		lblSoThoiGian.setFont(font1);
		txtSoPhong.setFont(font1);
		txtSoSuatChieu.setFont(font1);
		txtSoThoiGian.setFont(font1);

		// Ẩn viền và background cho các ô nhập liệu
		txtSoPhong.setBorder(null);
		txtSoSuatChieu.setBorder(null);
		txtSoThoiGian.setBorder(null);
		txtSoPhong.setOpaque(false);
		txtSoSuatChieu.setOpaque(false);
		txtSoThoiGian.setOpaque(false);

//     // Không cho phép người dùng nhập vào các ô nhập liệu
//        txtSoPhong.setEnabled(false);
//        txtSoSuatChieu.setEnabled(false);
//        txtSoThoiGian.setEnabled(false);

		// Không cho phép người dùng chỉnh sửa nội dung của các ô nhập liệu
		txtSoPhong.setEditable(false);
		txtSoSuatChieu.setEditable(false);
		txtSoThoiGian.setEditable(false);
		pnThongTin.add(lblSoPhong);
		pnThongTin.add(txtSoPhong);
		pnThongTin.add(lblSoSuatChieu);
		pnThongTin.add(txtSoSuatChieu);
		pnThongTin.add(lblSoThoiGian);
		pnThongTin.add(txtSoThoiGian);

		// Không cho phép focus vào các ô nhập liệu
		txtSoPhong.setFocusable(false);
		txtSoSuatChieu.setFocusable(false);
		txtSoThoiGian.setFocusable(false);

		pnThoiGian = new JPanel();

		btnTest = new JButton("LOAD DỮ LIỆU PHIM");
		btnTest.setPreferredSize(new Dimension(180, 40));
		btnTest.setBackground(Color.white);

		pnThoiGian.add(pnPhong);
		pnThoiGian.add(pnNgay);
		pnThoiGian.add(pnSuatChieu);
		pnThoiGian.add(pnThongTin);
//        pnThoiGian.add(btnTest);

		pnPhong.setBorder(BorderFactory.createTitledBorder("Chọn Phòng"));
		pnSuatChieu.setBorder(BorderFactory.createTitledBorder("Chọn Suất Chiếu"));
		pnNgay.setBorder(BorderFactory.createTitledBorder("Chọn Thời Gian"));

		Box pnWrap = Box.createVerticalBox();
		pnWrap.add(titlePanel);
		pnWrap.add(pnNgay);
		pnWrap.add(pnPhong);
		pnWrap.add(pnSuatChieu);
		pnWrap.add(pnThoiGian);
		add(pnWrap, BorderLayout.CENTER);
		

	}

	private static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
		Image image = icon.getImage();
		Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(newImage);
	}

	public static void capNhatHinhAnh(String duongDanMoi) {
		if (!duongDanHinhAnh.equals(duongDanMoi)) {
			duongDanHinhAnh = duongDanMoi;
			ImageIcon imageIconMoi = new ImageIcon(duongDanHinhAnh);
			lblPhimDoremon.setIcon(imageIconMoi);
			lblPhimDoremon.setIcon(resizeImageIcon(imageIconMoi, widthImg, heightImg));

			duongDanMoi = "img/" + gdChonPhim.getPosterPath();
			capNhatHinhAnh(duongDanMoi);
		}
	}

	public static void layThongTinPhim(String tenPhim) {
		lblTitle.setText(tenPhim);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTest)) {
			lblTitle.setText("PHIM: " + gdChonPhim.getTenPhim());
			String duongDanMoi = "img/" + gdChonPhim.getPosterPath();
			capNhatHinhAnh(duongDanMoi);
			revalidate();
			repaint();
		}
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Chọn thời gian");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GiaoDienChonThoiGian2 chontime = new GiaoDienChonThoiGian2();
		frame.getContentPane().add(chontime);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); // Hiển thị frame

	}
}
