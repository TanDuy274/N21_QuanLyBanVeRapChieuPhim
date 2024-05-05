package ui;

import javax.swing.*;
import java.awt.*;

public class GiaoDienVe extends JPanel {

    private JLabel lblTenPhim;
	private JLabel lblTheLoai;
	private JLabel lblTenTheLoai;
	private JLabel lblThoiLuong;
	private JLabel lblTenThoiLuong;
	private JLabel lblNgayKhoiChieu;
	private JLabel lblTenNgayKhoiChieu;
	private JLabel lblGioChieu;
	private JLabel lblTenGioChieu;
	private JLabel lblPhongChieu;
	private JLabel lblTenPhongChieu;
	private JLabel lblGhe;
	private JLabel lblTenGhe;
	private JPanel tenPanel;
	private JPanel theLoaiPanel;
	private JPanel thoiLuongPanel;
	private JPanel ngayChieuPanel;
	private JPanel gioChieuPanel;
	private JPanel phongChieuPanel;
	private JPanel ghePanel;
 
	public GiaoDienVe() {
        lblTenPhim = new JLabel("Avengers: Endgame");
        lblTenPhim.setFont(new Font("Arial", Font.BOLD, 30));
        lblTenPhim.setForeground(Color.BLUE);
        
        lblTheLoai = new JLabel("Thể loại");
        lblTheLoai.setFont(new Font("Arial", Font.BOLD, 15));
        lblTheLoai.setPreferredSize(new Dimension(140, 30));
//        lblTheLoai.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblTenTheLoai = new JLabel("Kinh dị");
        lblTenTheLoai.setFont(new Font("Arial", Font.BOLD, 15));
        lblTenTheLoai.setPreferredSize(new Dimension(140, 30));
        lblTenTheLoai.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblThoiLuong = new JLabel("Thời lượng");
        lblThoiLuong.setFont(new Font("Arial", Font.BOLD, 15));
        lblThoiLuong.setPreferredSize(new Dimension(140, 30));
//        lblThoiLuong.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblTenThoiLuong = new JLabel("90 phút");
        lblTenThoiLuong.setFont(new Font("Arial", Font.BOLD, 15));
        lblTenThoiLuong.setPreferredSize(new Dimension(140, 30));
        lblTenThoiLuong.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblNgayKhoiChieu = new JLabel("Ngày khởi chiếu");
        lblNgayKhoiChieu.setFont(new Font("Arial", Font.BOLD, 15));
        lblNgayKhoiChieu.setPreferredSize(new Dimension(140, 30));
//        lblNgayKhoiChieu.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblTenNgayKhoiChieu = new JLabel("04/05/2024");
        lblTenNgayKhoiChieu.setFont(new Font("Arial", Font.BOLD, 15));
        lblTenNgayKhoiChieu.setPreferredSize(new Dimension(140, 30));
        lblTenNgayKhoiChieu.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblGioChieu = new JLabel("Giờ chiếu");
        lblGioChieu.setFont(new Font("Arial", Font.BOLD, 15));
        lblGioChieu.setPreferredSize(new Dimension(140, 30));
//        lblGioChieu.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblTenGioChieu = new JLabel("22:30");
        lblTenGioChieu.setFont(new Font("Arial", Font.BOLD, 15));
        lblTenGioChieu.setPreferredSize(new Dimension(140, 30));
        lblTenGioChieu.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblPhongChieu = new JLabel("Phòng chiếu");
        lblPhongChieu.setFont(new Font("Arial", Font.BOLD, 15));
        lblPhongChieu.setPreferredSize(new Dimension(140, 30));
//        lblPhongChieu.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblTenPhongChieu = new JLabel("Phong001");
        lblTenPhongChieu.setFont(new Font("Arial", Font.BOLD, 15));
        lblTenPhongChieu.setPreferredSize(new Dimension(140, 30));
        lblTenPhongChieu.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblGhe = new JLabel("Ghế ngồi");
        lblGhe.setFont(new Font("Arial", Font.BOLD, 15));
        lblGhe.setPreferredSize(new Dimension(140, 30));
//        lblGhe.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblTenGhe = new JLabel("G5");
        lblTenGhe.setFont(new Font("Arial", Font.BOLD, 15));
        lblTenGhe.setPreferredSize(new Dimension(140, 30));
        lblTenGhe.setHorizontalAlignment(SwingConstants.CENTER);
        
        Box b = Box.createVerticalBox();
        
        tenPanel = new JPanel();
        tenPanel.setBackground(Color.WHITE);
        tenPanel.add(lblTenPhim);
        theLoaiPanel = new JPanel();
        theLoaiPanel.setBackground(Color.WHITE);
        theLoaiPanel.add(lblTheLoai);
        theLoaiPanel.add(lblTenTheLoai);
        thoiLuongPanel = new JPanel();
        thoiLuongPanel.setBackground(Color.WHITE);
        thoiLuongPanel.add(lblThoiLuong);
        thoiLuongPanel.add(lblTenThoiLuong);
        ngayChieuPanel = new JPanel();
        ngayChieuPanel.setBackground(Color.WHITE);
        ngayChieuPanel.add(lblNgayKhoiChieu);
        ngayChieuPanel.add(lblTenNgayKhoiChieu);
        gioChieuPanel = new JPanel();
        gioChieuPanel.setBackground(Color.WHITE);
        gioChieuPanel.add(lblGioChieu);
        gioChieuPanel.add(lblTenGioChieu);
        phongChieuPanel = new JPanel();
        phongChieuPanel.setBackground(Color.WHITE);
        phongChieuPanel.add(lblPhongChieu);
        phongChieuPanel.add(lblTenPhongChieu);
        ghePanel = new JPanel();
        ghePanel.setBackground(Color.WHITE);
        ghePanel.add(lblGhe);
        ghePanel.add(lblTenGhe);
        
        b.add(tenPanel);
        b.add(theLoaiPanel);
        b.add(thoiLuongPanel);
        b.add(ngayChieuPanel);
        b.add(gioChieuPanel);
        b.add(phongChieuPanel);
        b.add(ghePanel);
        
        add(b);
        setBackground(Color.WHITE);
    }

    // Phương thức để thiết lập giá trị cho các trường thông tin
    public void setThongTinVe() {
        
    }

    public static void main(String[] args) {
        // Tạo JFrame để chứa JPanel
        JFrame frame = new JFrame("Thông tin vé xem phim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo một đối tượng GiaoDienVe
        GiaoDienVe panel = new GiaoDienVe();

        // Thiết lập thông tin vé xem phim
//        panel.setThongTinVe("1234", "Avengers: Endgame", "A1", "$15.00", "2024-05-04 19:00", "Phòng 1", "Vé thường");

        // Thêm JPanel vào JFrame
        frame.getContentPane().add(panel);

        // Đặt kích thước cửa sổ và vị trí của nó
        frame.setSize(400, 400); // Kích thước mặc định
        frame.setLocationRelativeTo(null); // Đặt vị trí cửa sổ ở trung tâm màn hình

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
