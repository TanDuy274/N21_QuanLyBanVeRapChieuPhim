package ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaoDienChonThoiGian extends JPanel implements ActionListener {
	
	JButton currentSelectedButton = null;
    private JLabel lblTitle;
	private ImageIcon phimDoremon;
	private Object scaled7;
	private JLabel lblPhimDoremon;
	private JButton btnSuatChieu1;
	private JPanel pnSuatChieu;
	private JButton btnSuatChieu2;
	private JButton btnSuatChieu3;
	private JButton btnSuatChieu4;
	private JButton btnSuatChieu5;
	private JButton btnSuatChieu6;
	private JButton btnSuatChieu7;
	private JButton btnSuatChieu8,btnSuatChieu9,btnSuatChieu10,btnSuatChieu11,btnSuatChieu12,btnSuatChieu13,btnSuatChieu14,btnSuatChieu15,btnSuatChieu16,btnSuatChieu17,btnSuatChieu18,btnSuatChieu19,btnSuatChieu20,btnSuatChieu21,btnSuatChieu22,btnSuatChieu23,btnSuatChieu24;
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
	private JPanel pnRap;
	private JButton btnRap1,btnRap2,btnRap3,btnRap4,btnRap5,btnRap6,btnRap7,btnRap8;
	private JPanel pnThongTin;
	private JLabel lblSoPhong;
	private JLabel lblSoSuatChieu;
	private JLabel lblSoThoiGian;
	private JTextField txtSoPhong;
	private JTextField txtSoSuatChieu;
	private JTextField txtSoThoiGian;
	

	public GiaoDienChonThoiGian() {
        setLayout(new BorderLayout());
        
        lblTitle = new JLabel("PHIM: Nobita và ba chàng hiệp sĩ mộng mơ");
        Font font = lblTitle.getFont(); 
        Font newFont = font.deriveFont(Font.BOLD, 22); 
        lblTitle.setFont(newFont);
        
      
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(lblTitle);
        
        
//        GiaoDienChonPhim gd = new GiaoDienChonPhim();
        lblPhimDoremon = new JLabel(new ImageIcon("img/3_hiepsimongmo.jpg"));
//        lblPhimDoremon = new JLabel(new ImageIcon("img/" + gd.getPosterPath()));
     
        JPanel imagePanel = new JPanel();
        imagePanel.add(lblPhimDoremon);
       
        pnRap = new JPanel();
        
        btnRap1 = new JButton("Rạp 1");
        btnRap2 = new JButton("Rạp 2");
        btnRap3 = new JButton("Rạp 3");
        btnRap4 = new JButton("Rạp 4");
        btnRap5 = new JButton("Rạp 5");
        btnRap6 = new JButton("Rạp 6");
        btnRap7 = new JButton("Rạp 7");
        btnRap8 = new JButton("Rạp 8");
        
        pnRap.add(btnRap1);
        pnRap.add(btnRap2);
        pnRap.add(btnRap3);
        pnRap.add(btnRap4);
        pnRap.add(btnRap5);
        pnRap.add(btnRap6);
        pnRap.add(btnRap7);
        pnRap.add(btnRap8);
        btnRap1.setPreferredSize(new Dimension(100, 50)); 
        btnRap2.setPreferredSize(new Dimension(100, 50)); 
        btnRap3.setPreferredSize(new Dimension(100, 50)); 
        btnRap4.setPreferredSize(new Dimension(100, 50)); 
        btnRap5.setPreferredSize(new Dimension(100, 50)); 
        btnRap6.setPreferredSize(new Dimension(100, 50)); 
        btnRap7.setPreferredSize(new Dimension(100, 50)); 
        btnRap8.setPreferredSize(new Dimension(100, 50)); 
        
        btnRap1.setBackground(Color.ORANGE);
        btnRap2.setBackground(Color.ORANGE);
        btnRap3.setBackground(Color.ORANGE);
        btnRap4.setBackground(Color.ORANGE);
        btnRap5.setBackground(Color.ORANGE);
        btnRap6.setBackground(Color.ORANGE);
        btnRap7.setBackground(Color.ORANGE);
        btnRap8.setBackground(Color.ORANGE);
        
        JPanel pnSuatChieu = new JPanel(new GridLayout(3, 8, 5, 20));
        
        btnSuatChieu1 = new JButton("09:05");
        btnSuatChieu2 = new JButton("09:40");
        btnSuatChieu3 = new JButton("10:20");
        btnSuatChieu4 = new JButton("11:00");
        btnSuatChieu5 = new JButton("11:35");
        btnSuatChieu6 = new JButton("12:10");
        btnSuatChieu7 = new JButton("13:00");
        btnSuatChieu8 = new JButton("13:40");
        btnSuatChieu9 = new JButton("14:20");
        btnSuatChieu10 = new JButton("15:00");
        btnSuatChieu11 = new JButton("15:40");
        btnSuatChieu12 = new JButton("16:20");
        btnSuatChieu13 = new JButton("17:00");
        btnSuatChieu14 = new JButton("17:40");
        btnSuatChieu15 = new JButton("18:20");
        btnSuatChieu16 = new JButton("19:00");
        btnSuatChieu17 = new JButton("19:40");
        btnSuatChieu18 = new JButton("20:20");
        btnSuatChieu19 = new JButton("21:00");
        btnSuatChieu20 = new JButton("21:40");
        btnSuatChieu21 = new JButton("22:20");
        btnSuatChieu22 = new JButton("23:00");
        btnSuatChieu23 = new JButton("23:40");
        btnSuatChieu24 = new JButton("00:20");

       
        
        pnSuatChieu.add(btnSuatChieu1);
        pnSuatChieu.add(btnSuatChieu2);
        pnSuatChieu.add(btnSuatChieu3);
        pnSuatChieu.add(btnSuatChieu4);
        pnSuatChieu.add(btnSuatChieu5);
        pnSuatChieu.add(btnSuatChieu6);
        pnSuatChieu.add(btnSuatChieu7);
        pnSuatChieu.add(btnSuatChieu8);
        pnSuatChieu.add(btnSuatChieu9);
        pnSuatChieu.add(btnSuatChieu10);
        pnSuatChieu.add(btnSuatChieu11);
        pnSuatChieu.add(btnSuatChieu12);
        pnSuatChieu.add(btnSuatChieu13);
        pnSuatChieu.add(btnSuatChieu14);
        pnSuatChieu.add(btnSuatChieu15);
        pnSuatChieu.add(btnSuatChieu16);
        pnSuatChieu.add(btnSuatChieu17);
        pnSuatChieu.add(btnSuatChieu18);
        pnSuatChieu.add(btnSuatChieu19);
        pnSuatChieu.add(btnSuatChieu20);
        pnSuatChieu.add(btnSuatChieu21);
        pnSuatChieu.add(btnSuatChieu22);
        pnSuatChieu.add(btnSuatChieu23);
        pnSuatChieu.add(btnSuatChieu24);
        btnSuatChieu1.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu2.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu3.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu4.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu5.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu6.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu7.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu8.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu9.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu10.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu11.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu12.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu13.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu14.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu15.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu16.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu17.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu18.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu19.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu20.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu21.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu22.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu23.setPreferredSize(new Dimension(100, 50)); 
        btnSuatChieu24.setPreferredSize(new Dimension(100, 50)); 
        
        btnSuatChieu1.setBackground(new Color(0, 153, 255));
        btnSuatChieu2.setBackground(new Color(0, 153, 255));
        btnSuatChieu3.setBackground(new Color(0, 153, 255));
        btnSuatChieu4.setBackground(new Color(0, 153, 255));
        btnSuatChieu5.setBackground(new Color(0, 153, 255));
        
        
        btnSuatChieu1.setEnabled(false);
        
        btnSuatChieu2.setEnabled(false);
        btnSuatChieu3.setEnabled(false);
        btnSuatChieu4.setEnabled(false);
        btnSuatChieu5.setEnabled(false);
        
        
        btnSuatChieu6.setBackground(Color.ORANGE);
        btnSuatChieu7.setBackground(Color.ORANGE);
        btnSuatChieu8.setBackground(Color.ORANGE);
        btnSuatChieu9.setBackground(Color.ORANGE);
        btnSuatChieu10.setBackground(Color.ORANGE);
        btnSuatChieu11.setBackground(Color.ORANGE);
        btnSuatChieu12.setBackground(Color.ORANGE);
        btnSuatChieu13.setBackground(Color.ORANGE);
        btnSuatChieu14.setBackground(Color.ORANGE);
        btnSuatChieu15.setBackground(Color.ORANGE);
        btnSuatChieu16.setBackground(Color.ORANGE);
        btnSuatChieu17.setBackground(Color.ORANGE);
        btnSuatChieu18.setBackground(Color.ORANGE);
        btnSuatChieu19.setBackground(Color.ORANGE);
        btnSuatChieu20.setBackground(Color.ORANGE);
        btnSuatChieu21.setBackground(Color.ORANGE);
        btnSuatChieu22.setBackground(Color.ORANGE);
        btnSuatChieu23.setBackground(Color.ORANGE);
        btnSuatChieu24.setBackground(Color.ORANGE);

        
        btnSuatChieu1.setForeground(Color.darkGray);
        pnNgay = new JPanel();
        
        btnNgay1 = new JButton("28 thg 4");
        btnNgay2 = new JButton("29 thg 4");
        btnNgay3 = new JButton("30 thg 4");
        btnNgay4 = new JButton("01 thg 5");
        btnNgay5 = new JButton("02 thg 5");
        btnNgay6 = new JButton("03 thg 5");
        btnNgay7 = new JButton("04 thg 5");
        btnNgay8 = new JButton("05 thg 5");
        
        // Ngày 1
//        pnTg1 = new JPanel(new GridLayout(2, 1));
//        lblNgay1 = new JLabel("28 thg 4");
//        lblThu1 = new JLabel("Hôm nay");
//        pnTg1.add(lblNgay1);
//        pnTg1.add(lblThu1);
//        btnNgay1 = new JButton();
        btnNgay1.setBackground(Color.ORANGE);
//        pnTg1.setBackground(btnNgay1.getBackground());
//        btnNgay1.add(pnTg1);
       

        // Ngày 2
//        pnTg2 = new JPanel(new GridLayout(2, 1));
//        lblNgay2 = new JLabel("29 thg 4");
//        lblThu2 = new JLabel("Thứ 2");
//        pnTg2.add(lblNgay2);
//        pnTg2.add(lblThu2);
//        btnNgay2 = new JButton();
        btnNgay2.setBackground(Color.ORANGE);
//        pnTg2.setBackground(btnNgay1.getBackground());
//        btnNgay2.add(pnTg2);
//
//        // Ngày 3
//        pnTg3 = new JPanel(new GridLayout(2, 1));
//        lblNgay3 = new JLabel("30 thg 4");
//        lblThu3 = new JLabel("Thứ 3");
//        pnTg3.add(lblNgay3);
//        pnTg3.add(lblThu3);
//        btnNgay3 = new JButton();
        btnNgay3.setBackground(Color.ORANGE);
//        pnTg3.setBackground(btnNgay1.getBackground());
//        btnNgay3.add(pnTg3);
//
//        // Ngày 4
//        pnTg4 = new JPanel(new GridLayout(2, 1));
//        lblNgay4 = new JLabel("1 thg 5");
//        lblThu4 = new JLabel("Thứ 4");
//        pnTg4.add(lblNgay4);
//        pnTg4.add(lblThu4);
//        btnNgay4 = new JButton();
        btnNgay4.setBackground(Color.ORANGE);
//        pnTg4.setBackground(btnNgay1.getBackground());
//        btnNgay4.add(pnTg4);
//
//        // Ngày 5
//        pnTg5 = new JPanel(new GridLayout(2, 1));
//        lblNgay5 = new JLabel("2 thg 5");
//        lblThu5 = new JLabel("Thứ 5");
//        pnTg5.add(lblNgay5);
//        pnTg5.add(lblThu5);
//        btnNgay5 = new JButton();
        btnNgay5.setBackground(Color.ORANGE);
//        pnTg5.setBackground(btnNgay1.getBackground());
//        btnNgay5.add(pnTg5);
//
//        // Ngày 6
//        pnTg6 = new JPanel(new GridLayout(2, 1));
//        lblNgay6 = new JLabel("3 thg 5");
//        lblThu6 = new JLabel("Thứ 6");
//        pnTg6.add(lblNgay6);
//        pnTg6.add(lblThu6);
//        btnNgay6 = new JButton();
        btnNgay6.setBackground(Color.ORANGE);
//        pnTg6.setBackground(btnNgay1.getBackground());
//        btnNgay6.add(pnTg6);
//
//        // Ngày 7
//        pnTg7 = new JPanel(new GridLayout(2, 1));
//        lblNgay7 = new JLabel("4 thg 5");
//        lblThu7 = new JLabel("Thứ 7");
//        pnTg7.add(lblNgay7);
//        pnTg7.add(lblThu7);
//        btnNgay7 = new JButton();
        btnNgay7.setBackground(Color.ORANGE);
//        pnTg7.setBackground(btnNgay1.getBackground());
//        btnNgay7.add(pnTg7);
//
//        // Ngày 8
//        pnTg8 = new JPanel(new GridLayout(2, 1));
//        lblNgay8 = new JLabel("5 thg 5");
//        lblThu8 = new JLabel("Chủ Nhật");
//        pnTg8.add(lblNgay8);
//        pnTg8.add(lblThu8);
//        btnNgay8 = new JButton();
        btnNgay8.setBackground(Color.ORANGE);
//        pnTg8.setBackground(btnNgay1.getBackground());
//        btnNgay8.add(pnTg8);

        btnNgay1.setPreferredSize(new Dimension(100, 50)); 
        btnNgay2.setPreferredSize(new Dimension(100, 50)); 
        btnNgay3.setPreferredSize(new Dimension(100, 50)); 
        btnNgay4.setPreferredSize(new Dimension(100, 50)); 
        btnNgay5.setPreferredSize(new Dimension(100, 50)); 
        btnNgay6.setPreferredSize(new Dimension(100, 50)); 
        btnNgay7.setPreferredSize(new Dimension(100, 50)); 
        btnNgay8.setPreferredSize(new Dimension(100, 50)); 
        pnNgay.add(btnNgay1);
        pnNgay.add(btnNgay2);
        pnNgay.add(btnNgay3);
        pnNgay.add(btnNgay4);
        pnNgay.add(btnNgay5);
        pnNgay.add(btnNgay6);
        pnNgay.add(btnNgay7);
        pnNgay.add(btnNgay8);
        
    
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
        
        
       
        
        pnThoiGian.add(pnRap);     
        pnThoiGian.add(pnNgay);        
        pnThoiGian.add(pnSuatChieu);
        pnThoiGian.add(pnThongTin);
      
        pnRap.setBorder(BorderFactory.createTitledBorder("Chọn Phòng"));
        pnSuatChieu.setBorder(BorderFactory.createTitledBorder("Chọn Suất Chiếu"));   
        pnNgay.setBorder(BorderFactory.createTitledBorder("Chọn Thời Gian"));  
        
        
        
        add(titlePanel, BorderLayout.NORTH);
        add(imagePanel,BorderLayout.WEST);
        add(pnThoiGian,BorderLayout.CENTER);
        
        
        
        btnRap1.addActionListener(this);
        btnRap2.addActionListener(this);
        btnRap3.addActionListener(this);
        btnRap4.addActionListener(this);
        btnRap5.addActionListener(this);
        btnRap6.addActionListener(this);
        btnRap7.addActionListener(this);
        btnRap8.addActionListener(this);
        btnSuatChieu1.addActionListener(this);
        btnSuatChieu2.addActionListener(this);
        btnSuatChieu3.addActionListener(this);
        btnSuatChieu4.addActionListener(this);
        btnSuatChieu5.addActionListener(this);
        btnSuatChieu6.addActionListener(this);
        btnSuatChieu7.addActionListener(this);
        btnSuatChieu8.addActionListener(this);
        btnSuatChieu9.addActionListener(this);
        btnSuatChieu10.addActionListener(this);
        btnSuatChieu11.addActionListener(this);
        btnSuatChieu12.addActionListener(this);
        btnSuatChieu13.addActionListener(this);
        btnSuatChieu14.addActionListener(this);
        btnSuatChieu15.addActionListener(this);
        btnSuatChieu16.addActionListener(this);
        btnSuatChieu17.addActionListener(this);
        btnSuatChieu18.addActionListener(this);
        btnSuatChieu19.addActionListener(this);
        btnSuatChieu20.addActionListener(this);
        btnSuatChieu21.addActionListener(this);
        btnSuatChieu22.addActionListener(this);
        btnSuatChieu23.addActionListener(this);
        btnSuatChieu24.addActionListener(this);
        btnNgay1.addActionListener(this);
        btnNgay2.addActionListener(this);
        btnNgay3.addActionListener(this);
        btnNgay4.addActionListener(this);
        btnNgay5.addActionListener(this);
        btnNgay6.addActionListener(this);
        btnNgay7.addActionListener(this);
        btnNgay8.addActionListener(this);
        
       

    }


	@Override
	public void actionPerformed(ActionEvent e) {
	    Object o = e.getSource();

	 // Xử lý sự kiện cho các nút
	    if (o instanceof JButton) {

	        JOptionPane.showMessageDialog(null, new GiaoDienChonPhim().getTenPhim());
//	        JOptionPane.showMessageDialog(null, new GiaoDienChonPhim().getPosterPath());
	        JButton selectedButton = (JButton) o;

	        // Hủy màu của nút trước đó nếu có
	        if (currentSelectedButton != null) {
	            currentSelectedButton.setBackground(Color.ORANGE);
	            

	        }

	        // Đặt màu nền của nút hiện tại thành màu mới
	        selectedButton.setBackground(new Color(0, 153, 255));

	        // Lưu trữ nút hiện tại vào biến currentSelectedButton
	        currentSelectedButton = selectedButton;

	        // Cập nhật thông tin phòng nếu là nút phòng
	        if (selectedButton.equals(btnRap1) || selectedButton.equals(btnRap2) || selectedButton.equals(btnRap3) ||
	            selectedButton.equals(btnRap4) || selectedButton.equals(btnRap5) || selectedButton.equals(btnRap6) ||
	            selectedButton.equals(btnRap7) || selectedButton.equals(btnRap8)) {
	            txtSoPhong.setText(selectedButton.getText());
	        }
	        
	        // Cập nhật thông tin suất chiếu nếu là nút suất chiếu
	        else if (selectedButton.equals(btnSuatChieu1) || selectedButton.equals(btnSuatChieu2) || 
	                 selectedButton.equals(btnSuatChieu3) || selectedButton.equals(btnSuatChieu4) || 
	                 selectedButton.equals(btnSuatChieu5) || selectedButton.equals(btnSuatChieu6) || 
	                 selectedButton.equals(btnSuatChieu7) || selectedButton.equals(btnSuatChieu8) || 
	                 selectedButton.equals(btnSuatChieu9) || selectedButton.equals(btnSuatChieu10) || 
	                 selectedButton.equals(btnSuatChieu11) || selectedButton.equals(btnSuatChieu12) || 
	                 selectedButton.equals(btnSuatChieu13) || selectedButton.equals(btnSuatChieu14) || 
	                 selectedButton.equals(btnSuatChieu15) || selectedButton.equals(btnSuatChieu16) || 
	                 selectedButton.equals(btnSuatChieu17) || selectedButton.equals(btnSuatChieu18) || 
	                 selectedButton.equals(btnSuatChieu19) || selectedButton.equals(btnSuatChieu20) || 
	                 selectedButton.equals(btnSuatChieu21) || selectedButton.equals(btnSuatChieu22) || 
	                 selectedButton.equals(btnSuatChieu23) || selectedButton.equals(btnSuatChieu24)) {
	            txtSoSuatChieu.setText(selectedButton.getText());
	        }

	        // Cập nhật thông tin ngày nếu là nút ngày
	        else if (selectedButton.equals(btnNgay1) || selectedButton.equals(btnNgay2) || 
	                 selectedButton.equals(btnNgay3) || selectedButton.equals(btnNgay4) || 
	                 selectedButton.equals(btnNgay5) || selectedButton.equals(btnNgay6) || 
	                 selectedButton.equals(btnNgay7) || selectedButton.equals(btnNgay8)) {
	            
	            txtSoThoiGian.setText(selectedButton.getText());
	        }
	    }


	
	}}
