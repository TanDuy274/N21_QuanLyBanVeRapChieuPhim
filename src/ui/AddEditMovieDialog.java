package ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.LoaiPhim_DAO;
import dao.Phim_DAO;
import entity.LoaiPhim;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class AddEditMovieDialog extends JDialog implements ActionListener {
	private JComboBox<String> comboLoaiPhim;
	private JComboBox<String> comboNgonNgu;
	private JDateChooser dateChooser;
	private JButton btnSave;
	private JButton btnCancel;
	private JTextField tfTenPhim;
	private JTextField tfThoiLuong;
	private JTextField tfGHTuoi;
	private JTextField tfGiaTien;
	private JTextField tfTrangThai;
	private JDateChooser dcKhoiChieu;
	private JButton btnChonAnh;
	private JLabel lblPoster;
	private String pathImageShow;
	private Phim_DAO movieDAO;
	private LoaiPhim_DAO categoryDAO;

	public AddEditMovieDialog(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		try {
            ConnectDB.getIntance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        movieDAO = new Phim_DAO();
        categoryDAO = new LoaiPhim_DAO();
        
		
		initComponents();
	}

	private void initComponents() {
		// Đặt kích thước, vị trí, hiển thị dialog
		setSize(630, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		setLayout(new BorderLayout());

		JPanel pnWrap = new JPanel(new BorderLayout());
		Box bLeft = Box.createVerticalBox();
		Box bRight = Box.createVerticalBox();

		lblPoster = new JLabel("");
		lblPoster.setBorder(BorderFactory.createLineBorder(Color.black));
		ImageIcon defaultImageIcon = new ImageIcon("img//lat-mat-7.jpg");
		Image image = defaultImageIcon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
		defaultImageIcon = new ImageIcon(image);
		lblPoster.setIcon(defaultImageIcon);
	    lblPoster.setIcon(defaultImageIcon);
		btnChonAnh = new CustomButton("Chọn ảnh");
		btnChonAnh.setFocusPainted(false);
		btnChonAnh.setBackground(new Color(00, 153, 255));
		JLabel lblTenPhim = new JLabel("Tên phim: ");
		tfTenPhim = new JTextField(20);
		JLabel lblThoiLuong = new JLabel("Thời lượng: ");
		tfThoiLuong = new JTextField(20);
		JLabel lblGHTuoi = new JLabel("Giới hạn tuổi: ");
		tfGHTuoi = new JTextField(20);
		
		lblTenPhim.setPreferredSize(lblGHTuoi.getPreferredSize());
		lblThoiLuong.setPreferredSize(lblGHTuoi.getPreferredSize());
		tfTenPhim.setFont(new Font("Helvetica", Font.PLAIN, 14));	
		tfThoiLuong.setFont(new Font("Helvetica", Font.PLAIN, 14));
		tfGHTuoi.setFont(new Font("Helvetica", Font.PLAIN, 14));
		
		Box bL1 = Box.createHorizontalBox();
		Box bL2 = Box.createHorizontalBox();
		Box bL3 = Box.createHorizontalBox();
		Box bL4 = Box.createHorizontalBox();
		Box bL5 = Box.createHorizontalBox();
		

		bL1.add(lblPoster);
		bL2.add(btnChonAnh);
		bL3.add(lblTenPhim);
		bL3.add(tfTenPhim);
		bL4.add(lblThoiLuong);
		bL4.add(tfThoiLuong);
		bL5.add(lblGHTuoi);
		bL5.add(tfGHTuoi);

		bLeft.add(bL1);
		bLeft.add(Box.createVerticalStrut(15));
		bLeft.add(bL2);
		bLeft.add(Box.createVerticalStrut(15));
		bLeft.add(bL3);
		bLeft.add(Box.createVerticalStrut(15));
		bLeft.add(bL4);
		bLeft.add(Box.createVerticalStrut(15));
		bLeft.add(bL5);
		bLeft.add(Box.createVerticalStrut(15));

		JLabel lblLoaiPhim = new JLabel("Loại phim: ");
		comboLoaiPhim = new JComboBox<String>();
		loadCategoryToComboBox();
		JLabel lblNgonNgu = new JLabel("Ngôn ngữ: ");
		comboNgonNgu = new JComboBox<String>();
		comboNgonNgu.addItem("Tieng Viet");
		comboNgonNgu.addItem("Tieng Anh");
		comboNgonNgu.addItem("Tieng Han");
		comboNgonNgu.addItem("Tieng Nhat");
		comboNgonNgu.addItem("Tieng An Do");
		comboNgonNgu.addItem("Tieng Thai");
		
		JLabel lblKhoiChieu = new JLabel("Ngày khởi chiếu: ");
		dcKhoiChieu = new JDateChooser();
		JLabel lblGiaTien = new JLabel("Giá tiền: ");
		tfGiaTien = new JTextField(20);
		JLabel lblTrangThai = new JLabel("Trạng thái: ");
		tfTrangThai = new JTextField(20);

		lblLoaiPhim.setPreferredSize(lblKhoiChieu.getPreferredSize());
		lblNgonNgu.setPreferredSize(lblKhoiChieu.getPreferredSize());
		lblGiaTien.setPreferredSize(lblKhoiChieu.getPreferredSize());
		lblTrangThai.setPreferredSize(lblKhoiChieu.getPreferredSize());
		comboLoaiPhim.setFont(new Font("Helvetica", Font.PLAIN, 14));	
		comboNgonNgu.setFont(new Font("Helvetica", Font.PLAIN, 14));
		tfGiaTien.setFont(new Font("Helvetica", Font.PLAIN, 14));
		dcKhoiChieu.setFont(new Font("Helvetica", Font.PLAIN, 14));
		dcKhoiChieu.getCalendarButton().setToolTipText("Ngày khởi chiếu");
		dcKhoiChieu.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dcKhoiChieu.getCalendarButton().setBackground(new Color(00, 153, 255));
		dcKhoiChieu.setDateFormatString("dd/MM/yyyy");
		tfTrangThai.setFont(new Font("Helvetica", Font.PLAIN, 14));
		
		Box bR1 = Box.createHorizontalBox();
		Box bR2 = Box.createHorizontalBox();
		Box bR3 = Box.createHorizontalBox();
		Box bR4 = Box.createHorizontalBox();
		Box bR5 = Box.createHorizontalBox();

		bR1.add(lblLoaiPhim);
		bR1.add(comboLoaiPhim);
		bR2.add(lblNgonNgu);
		bR2.add(comboNgonNgu);
		bR3.add(lblKhoiChieu);
		bR3.add(dcKhoiChieu);
		bR4.add(lblGiaTien);
		bR4.add(tfGiaTien);
		bR5.add(lblTrangThai);
		bR5.add(tfTrangThai);

		bRight.add(Box.createVerticalStrut(15));
		bRight.add(bR1);
		bRight.add(Box.createVerticalStrut(15));
		bRight.add(bR2);
		bRight.add(Box.createVerticalStrut(15));
		bRight.add(bR3);
		bRight.add(Box.createVerticalStrut(15));
		bRight.add(bR4);
		bRight.add(Box.createVerticalStrut(15));
		bRight.add(bR5);
		bRight.add(Box.createVerticalStrut(242));

		pnWrap.add(bLeft, BorderLayout.WEST);
		pnWrap.add(bRight, BorderLayout.EAST);

		// Tạo các nút "Lưu" và "Hủy"
		btnSave = new CustomButton("Lưu");
		btnSave.setFocusPainted(false);
		btnSave.setBackground(Color.blue);
		btnCancel = new CustomButton("Hủy");
		btnCancel.setFocusPainted(false);
		btnCancel.setBackground(Color.gray);

		// Tạo và cấu hình layout
		JPanel pnTools = new JPanel();
		pnTools.add(btnSave);
		pnTools.add(btnCancel);

		pnWrap.add(pnTools, BorderLayout.SOUTH);
		pnWrap.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(pnWrap, BorderLayout.CENTER);

		// Đặt sự kiện cho nút "Lưu" và "Hủy"
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
		btnChonAnh.addActionListener(this);

	}
	private void loadCategoryToComboBox() {
        List<LoaiPhim> categoryList = categoryDAO.getAllLoaiPhim();
        for (LoaiPhim loaiPhim : categoryList) {
            comboLoaiPhim.addItem(loaiPhim.getTenLoaiPhim());
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnChonAnh)) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
			fileChooser.setFileFilter(filter);

			int result = fileChooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				displayImage(selectedFile);
			}
		} else if (o.equals(btnSave)) {
			String ten = tfTenPhim.getText().trim();
			String thoiLuong = tfThoiLuong.getText().trim();
			String ghTuoi = tfGHTuoi.getText().trim();
			String loai = (String) comboLoaiPhim.getSelectedItem();
			String ngonNgu = (String) comboNgonNgu.getSelectedItem();
			String ngayKC = dcKhoiChieu.getDateFormatString();
			String gia = tfGiaTien.getText().trim();
//			Boolean trangThai = true;
//			String 
			// Đóng dialog
		} else if (o.equals(btnCancel)) {
			// Đóng dialog
			setVisible(false);
		}
	}

	private void displayImage(File file) {
		try {
			ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
			Image image = imageIcon.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(image);
			lblPoster.setIcon(imageIcon);
			pathImageShow = file.getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
