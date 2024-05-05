package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import dao.HoaDon_DAO;
import entity.HoaDon;

public class GiaoDienThanhToan2 extends JPanel implements ActionListener,MouseListener {
	private static HoaDon_DAO hoaDonDAO;
	private JLabel lblTen;
	private JLabel lblSdt;
	private JLabel lblDiem;
	private JLabel lblDiemsudung;
	private static JTextField txtTen;
	private static JTextField txtSdt;
	private static JTextField txtDiem;
	private static JTextField txtDiemsudung;
	private JLabel lblUudai;
	private JLabel lblChiTietUudai;
	private JButton btnApdung;
	private JButton btnHuy;
	private JPanel pnTen;
	private JPanel pnSdt;
	private JPanel pnDiem;
	private JPanel pnDiemsudung;
	private JPanel pnUudai;
	private JPanel pnButton;
	private JLabel lblThongTinHoaDon;
	private JLabel lblMaHoaDon;
	private JLabel lblNgayLap;
	private JLabel lblTenNhanvien;
	private static JTextField txtMaHoaDon;
	private static JTextField txtNgayLap;
	private static JTextField txtTenNhanvien;
	private JPanel pnThongTinHoaDon;
	private JPanel pnNgayLap;
	private JPanel pnMaHoaDon;
	private JPanel pnTenNhanVien;
	private JPanel panelBoxThongTinChiTietHoaDon;
	private JLabel lblTitle1;
	private JPanel pnTitle1;
	private JPanel pnMain;
	private JPanel panelBoder1;
	private JPanel panelBoder2;
	private JLabel lblTTV;
	private JPanel pnTTV;
	private JLabel lblLapHoaDon;
	private JPanel pnLapHoaDon;
	private JLabel lblTiensanpham;
	private JLabel lblThueGTGT;
	private JLabel lblDiemDoi;
	private JLabel lblTongThanhToan;
	private JButton btnInHoaDon;
	private JButton btnLuuHoaDon;
	private JPanel pnBtnHoaDon;
	private JPanel pnBoder3;
	private JTextField txtTiensanpham;
	private JTextField txtThueGTGT;
	private JTextField txtDiemDoi;
	private JTextField txtTongThanhToan;
	private JPanel pnTiensanpham;
	private JPanel pnThueGTGT;
	private JPanel pnDiemDoi;
	private JPanel pnTongThanhToan;
	private JButton btnInVe;
	private JTable table;

	public GiaoDienThanhToan2 ()  { 
		setLayout(new BorderLayout());
//		setSize(1200, 725);
//		setLocationRelativeTo(null);
		
		lblLapHoaDon = new JLabel("LẬP HÓA ĐƠN");
		lblLapHoaDon.setFont(new Font("Arial", 20, Font.BOLD));
		pnLapHoaDon = new  JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
		pnLapHoaDon.add(lblLapHoaDon);
		
		
//		thông tin hóa đơn
		lblMaHoaDon = new JLabel("Mã hóa đơn:");
		lblNgayLap = new JLabel("Ngày lập:");
		lblTenNhanvien = new JLabel("Tên nhân viên:");
		txtMaHoaDon = new JTextField("HD123");
		txtNgayLap = new JTextField("04/05/2024");
		txtTenNhanvien = new JTextField("Nhân Viên Ẩn Danh");
		
		lblMaHoaDon.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font chữ
		lblNgayLap.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTenNhanvien.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMaHoaDon.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNgayLap.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTenNhanvien.setFont(new Font("Arial", Font.PLAIN, 14));
		
		// Định nghĩa màu trong suốt
		Color transparentColor = new Color(255, 255, 255, 100); // 100 là độ mờ, giá trị nằm trong khoảng từ 0 đến 255
		Color systemColor = new Color(0xF0F0F0); 
		
		// Đặt màu nền trong suốt cho các JTextField
		txtMaHoaDon.setBackground(systemColor);
		txtNgayLap.setBackground(systemColor);
		txtTenNhanvien.setBackground(systemColor);
		
		// Đặt border cho JTextField
		Border border = BorderFactory.createLineBorder(systemColor);
		txtMaHoaDon.setBorder(border);
		txtNgayLap.setBorder(border);
		txtTenNhanvien.setBorder(border);
		
		txtMaHoaDon.setBorder(null); txtMaHoaDon.setOpaque(false);txtMaHoaDon.setEditable(false);txtMaHoaDon.setFocusable(false);
		txtNgayLap.setBorder(null); txtNgayLap.setOpaque(false);txtNgayLap.setEditable(false);txtNgayLap.setFocusable(false);
		txtTenNhanvien.setBorder(null); txtTenNhanvien.setOpaque(false);txtTenNhanvien.setEditable(false);txtTenNhanvien.setFocusable(false);
		
		pnMaHoaDon = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		pnNgayLap = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		pnTenNhanVien = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		pnMaHoaDon.add(lblMaHoaDon); 
		pnMaHoaDon.add(txtMaHoaDon); 
		pnNgayLap.add(lblNgayLap);
		pnNgayLap.add(txtNgayLap);
		pnTenNhanVien.add(lblTenNhanvien);
		pnTenNhanVien.add(txtTenNhanvien);
		
		Box boxHoaDon = Box.createVerticalBox();
		boxHoaDon.add(pnMaHoaDon);
	    boxHoaDon.add(pnNgayLap);
	    boxHoaDon.add(pnTenNhanVien);
	        
		panelBoder1 = new JPanel(new BorderLayout());
		panelBoder1.add(boxHoaDon, BorderLayout.CENTER);

        // Tạo border
//        Border border = BorderFactory.createLineBorder(Color.BLACK); // Border đơn giản với đường viền đen
//        panelBoder1.setBorder(border);

       
		
		
//		thẻ thành viên áp dụng điểm
		lblTTV = new JLabel("Đổi điểm thẻ thành viên");
		pnTTV = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,10));
		pnTTV.add(lblTTV);
		lblTen = new JLabel("Thành viên:");
		lblSdt = new JLabel("Số điện thoại:");
		lblDiem = new JLabel("Điểm:");
		lblDiemsudung = new JLabel("Số điểm sử dụng:");
		
		txtTen = new JTextField("Nguyễn Văn C");
		txtSdt = new JTextField("012345678");
		txtDiem = new JTextField("2300");
		lblChiTietUudai = new JLabel("Dùng điểm để thanh toán 20 điểm = 20.000đ");
		txtDiemsudung = new JTextField("400");
		
		btnApdung = new JButton("ÁP DỤNG");
		btnHuy = new JButton("HỦY BỎ");
		btnApdung.setBackground(Color.orange);
		btnHuy.setBackground(Color.orange);
		
		lblTTV.setFont(new Font("Arial", Font.BOLD, 16)); // Set font chữ
		lblTen.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSdt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDiem.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDiemsudung.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTen.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSdt.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDiem.setFont(new Font("Arial", Font.PLAIN, 14));
		lblChiTietUudai.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDiemsudung.setFont(new Font("Arial", Font.PLAIN, 14));
		btnApdung.setFont(new Font("Arial", Font.PLAIN, 14));
		btnHuy.setFont(new Font("Arial", Font.PLAIN, 14));
		btnApdung.setFont(new Font("Arial", Font.PLAIN, 14));
		btnHuy.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTen.setBorder(null); txtTen.setOpaque(false);txtTen.setEditable(false);txtTen.setFocusable(false);
		txtSdt.setBorder(null); txtSdt.setOpaque(false);txtSdt.setEditable(false);txtSdt.setFocusable(false);
		txtDiem.setBorder(null); txtDiem.setOpaque(false);txtDiem.setEditable(false);txtDiem.setFocusable(false);
		txtTen.setForeground(new Color(0, 0, 200));
		txtSdt.setForeground(new Color(0, 0, 200));
		txtDiem.setForeground(new Color(0, 0, 200));
		
		
		pnTen = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,5));
		pnSdt = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,5));
		pnDiem = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,5));
		pnUudai = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,5));
		pnDiemsudung = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,5));
		pnButton = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,5));
		pnTen.add(lblTen); pnTen.add(txtTen);
		pnSdt.add(lblSdt); pnSdt.add(txtSdt);
		pnDiem.add(lblDiem); pnDiem.add(txtDiem);
		pnUudai.add(lblChiTietUudai);
		pnDiemsudung.add(lblDiemsudung); pnDiemsudung.add(txtDiemsudung);
		pnButton.add(Box.createVerticalStrut(50));
		pnButton.add(btnApdung);  pnButton.add(Box.createHorizontalStrut(50));
		pnButton.add(btnHuy); pnButton.add(Box.createHorizontalStrut(30));
	
		
		Box boxDiem1 = Box.createVerticalBox();
		boxDiem1.add(pnTTV);
		boxDiem1.add(pnTen);boxDiem1.add(Box.createVerticalStrut(5));
		boxDiem1.add(pnSdt);boxDiem1.add(Box.createVerticalStrut(5));
		Box boxDiem2 = Box.createVerticalBox();
		boxDiem2.add(pnDiem);boxDiem2.add(Box.createVerticalStrut(5));
		boxDiem2.add(pnUudai);boxDiem2.add(Box.createVerticalStrut(5));
		boxDiem2.add(pnDiemsudung);
		boxDiem2.add(pnButton);
		
		Box boxDiem = Box.createHorizontalBox();
		boxDiem.add(boxDiem1);  boxDiem.add(Box.createHorizontalStrut(120));
		boxDiem.add(boxDiem2);
		
		panelBoder2 = new JPanel(new BorderLayout());
		panelBoder2.add(boxDiem, BorderLayout.CENTER);

        // Tạo border
        Border border2 = BorderFactory.createLineBorder(Color.BLACK); // Border đơn giản với đường viền đen
        panelBoder2.setBorder(border2);
	
//        box ngang chứa thông tin hóa đơn và thẻ thành viên
        Box boxHeader = Box.createHorizontalBox();
        boxHeader.add(panelBoder1);  boxHeader.add(Box.createHorizontalStrut(350)); //khoảng cách thông tin hóa đơn và đổi điểm
        boxHeader.add(panelBoder2);
        
//        bảng
        String[] columnNames = {"TT", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"};
        Object[][] data = {
                {1, "Phim Quật mộ trùng ma", 80000 , 1 , 80000},
                {2, "Bắp + Pepsi vị chanh vừa", 80000,1, 80000}
        	};
        
      //BẢNG
        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(600, 250));
        table.setGridColor(Color.WHITE); // Set màu của đường biên
        table.setBorder(BorderFactory.createEmptyBorder()); // Đặt đường biên trống
        table.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font chữ
        table.setRowHeight(40); // Set chiều cao của mỗi dòng
        JScrollPane scrollPane = new JScrollPane(table);


//      tổng tiền
        lblTiensanpham = new JLabel("Tổng tiền sản phẩm:");
        lblThueGTGT = new JLabel("Thuế GTGT 10%: ");
        lblDiemDoi = new JLabel("Điểm:");
        lblTongThanhToan = new JLabel("Tổng thanh toán:");
        btnInHoaDon = new JButton("IN HÓA ĐƠN");
        btnLuuHoaDon = new JButton("LƯU HÓA ĐƠN");
        btnInVe = new JButton("IN VÉ");
        txtTiensanpham = new JTextField("160.000");
        txtThueGTGT = new JTextField("16.000");
        txtDiemDoi = new JTextField("400");
        txtTongThanhToan = new JTextField("143,600");
        
        txtTongThanhToan.setForeground(new Color(0, 255, 0));
        btnInHoaDon.setBackground(Color.PINK);
        btnLuuHoaDon.setBackground(Color.PINK);
        btnInVe.setBackground(Color.PINK);
        
        lblTiensanpham.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font chữ
        lblThueGTGT.setFont(new Font("Arial", Font.PLAIN, 14));
        lblDiemDoi.setFont(new Font("Arial", Font.PLAIN, 14));
        lblTongThanhToan.setFont(new Font("Arial", Font.PLAIN, 14));
        btnInHoaDon.setFont(new Font("Arial", Font.PLAIN, 14));
        btnLuuHoaDon.setFont(new Font("Arial", Font.PLAIN, 14));
        btnInVe.setFont(new Font("Arial", Font.PLAIN, 14));
        txtTiensanpham.setFont(new Font("Arial", Font.PLAIN, 14));
        txtThueGTGT.setFont(new Font("Arial", Font.PLAIN, 14));
        txtDiemDoi.setFont(new Font("Arial", Font.PLAIN, 14));
        txtTongThanhToan.setFont(new Font("Arial", Font.PLAIN, 14));
        txtTiensanpham.setBorder(null); txtTiensanpham.setOpaque(false);txtTiensanpham.setEditable(false);txtTiensanpham.setFocusable(false);
        txtThueGTGT.setBorder(null); txtThueGTGT.setOpaque(false);txtThueGTGT.setEditable(false);txtThueGTGT.setFocusable(false);
        txtDiemDoi.setBorder(null); txtDiemDoi.setOpaque(false);txtDiemDoi.setEditable(false);txtDiemDoi.setFocusable(false);
        txtTiensanpham.setBorder(null); txtTongThanhToan.setOpaque(false);txtTongThanhToan.setEditable(false);txtTongThanhToan.setFocusable(false);
        txtThueGTGT.setForeground(new Color(0, 0, 200));
        txtDiemDoi.setForeground(new Color(0, 0, 200));
        txtTiensanpham.setForeground(new Color(0, 0, 200));
        
        
        pnTiensanpham = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,5));
        pnTiensanpham.add(lblTiensanpham); pnTiensanpham.add(txtTiensanpham);
        pnThueGTGT = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,5));
        pnThueGTGT.add(lblThueGTGT); pnThueGTGT.add(txtThueGTGT);
        pnDiemDoi = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,5));
        pnDiemDoi.add(lblDiemDoi); pnDiemDoi.add(txtDiemDoi);
        pnTongThanhToan = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,5));
        pnTongThanhToan.add(lblTongThanhToan); pnTongThanhToan.add(txtTongThanhToan);
        
        
        Box box1 = Box.createVerticalBox();
        box1.add(pnTiensanpham); box1.add(Box.createVerticalStrut(15));
        box1.add(pnThueGTGT); box1.add(Box.createVerticalStrut(15));
        box1.add(pnDiemDoi);box1.add(Box.createVerticalStrut(15));
        Box box2 = Box.createVerticalBox();
        box2.add(pnTongThanhToan);
        pnBtnHoaDon = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
        pnBtnHoaDon.add(btnInHoaDon);
        pnBtnHoaDon.add(btnLuuHoaDon);
        pnBtnHoaDon.add(btnInVe);
        box2.add(pnBtnHoaDon);
        Box box12 = Box.createHorizontalBox();
        box12.add(box1); box12.add(Box.createHorizontalStrut(100));
        box12.add(box2);
        pnBoder3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50,20));
        pnBoder3.add(box12);
//         Tạo border
        Border border3 = BorderFactory.createLineBorder(Color.BLACK); // Border đơn giản với đường viền đen
        pnBoder3.setBorder(border3);
        		
//		box chính
		Box boxMain = Box.createVerticalBox();
		
		boxMain.add(boxHeader); boxMain.add(Box.createVerticalStrut(30));
		boxMain.add(scrollPane);boxMain.add(Box.createVerticalStrut(10));
		boxMain.add(pnBoder3);
		pnMain = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
		pnMain.add(boxMain);
	
		
		
		
//		add title 2
		
		//add
		add(pnLapHoaDon, BorderLayout.NORTH);
		add(pnMain, BorderLayout.CENTER);
		
		btnInHoaDon.addActionListener(this);
		
		table.addMouseListener(this);
		
	}
	
	public static void main(String[] args) {
		new GiaoDienThanhToan2().setVisible(true);
	}
	
	public static void capNhatThongTinTrangThanhToan() {
	    hoaDonDAO = new HoaDon_DAO();
	    HoaDon hoaDon = hoaDonDAO.layHoaDonCuoiCungCoTen();
	    
	    if (hoaDon != null) {
	        txtMaHoaDon.setText(hoaDon.getMaHoaDon());
	        txtNgayLap.setText(hoaDon.getNgayLapHoaDon().toString());
	        txtTenNhanvien.setText(hoaDon.getNhanVien().getTenNhanVien());
	        txtTen.setText(hoaDon.getKhachHang().getTenKhachHang());
	        txtSdt.setText(hoaDon.getKhachHang().getSoDienThoai());
	    } else {
	        
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnInHoaDon)) {
			GiaoDienHoaDon giaoDienHoaDon = new GiaoDienHoaDon();
			giaoDienHoaDon.setVisible(true);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && table.getSelectedColumn() == 3) {
            // Hiển thị hộp thoại nhập số lượng
            String quantityStr = JOptionPane.showInputDialog(null, "Nhập số lượng:", "Nhập số lượng", JOptionPane.PLAIN_MESSAGE);
            if (quantityStr != null && !quantityStr.isEmpty()) {
                try {
                    int quantity = Integer.parseInt(quantityStr);
                    if (quantity >= 0) {
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow != -1) {
                            // Cập nhật giá trị số lượng và tổng tiền cho hàng tương ứng trong bảng
                            int price = Integer.parseInt(table.getValueAt(selectedRow, 2).toString());
                            table.setValueAt(quantity, selectedRow, 3);
                            table.setValueAt(quantity * price, selectedRow, 4);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Số lượng phải là một số nguyên dương.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		 
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
