package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GiaoDienMenu extends JPanel implements ActionListener,MouseListener{
    private GiaoDienChinh mainFrame;
	private JButton btnQuanLi;
	private JLabel imageLabel;
	private JPanel pnQuanliPhim;
	private JLabel lblQuanLi;
	private JPanel pnDatVe;
	private JLabel lblDatVe;
	private JPanel pnQLKhachHang;
	private JLabel lblQLKhachhang;
	private JPanel pnQLHoaDon;
	private JLabel lblQLHoadon;
	private JPanel pnDangxuat;
	private JLabel lblDangxuat;
	private JPanel pnDay;
	private JPanel pnUer;
	private JPanel pnUserName;
	private String nhanvien1;
	private JLabel lblUserName;

    public GiaoDienMenu(GiaoDienChinh mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setPreferredSize(new Dimension(200, 600));
        
//      màu cam chủ đạo: 
        Color orangeDark = Color.decode("#F23C21"); // Tạo màu cam tùy chỉnh

//      pnImgUser
        pnUer = new JPanel();
        pnUer.setPreferredSize(new Dimension(190,170));
        pnUer.setBackground(orangeDark);
        ImageIcon imgUser = new ImageIcon("img/account2-icon.png");
        Image scaledUser = scaleImage(imgUser.getImage(), 150, 130);
        ImageIcon imgScaled1 = new ImageIcon(scaledUser);
        JLabel lblImgScaled1= new JLabel(imgScaled1);
        pnUer.add(lblImgScaled1);
        lblUserName = new JLabel("nhanvien1");
        pnUer.add(lblUserName);
        add(pnUer);
        
        //panel Quản lí Phim
        //dùng sự kiện MouseListener cho từng panel chứa icon và label
        pnQuanliPhim = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
//        pnQuanliPhim.setBackground(Color.BLUE);
        pnQuanliPhim.setPreferredSize(new Dimension(190,50));
        
        ImageIcon imgFilm = new ImageIcon("img/movies-icon.png");
        Image scaledFilm = scaleImage(imgFilm.getImage(), 30, 30);
        ImageIcon imgScaled = new ImageIcon(scaledFilm);
        JLabel lblImgScaled = new JLabel(imgScaled);
        pnQuanliPhim.add(lblImgScaled);
        
        lblQuanLi = new JLabel("Quản lý phim");
        pnQuanliPhim.add(lblQuanLi);
        add(pnQuanliPhim);
        
//      panel Đặt vé
        pnDatVe = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
//      pnDatVe.setBackground(Color.BLUE);
        pnDatVe.setPreferredSize(new Dimension(190,50));
      
        ImageIcon imgTicket = new ImageIcon("img/ticket-icon.png");
        Image scaledTicket = scaleImage(imgTicket.getImage(), 30, 30);
        ImageIcon imgScaled2 = new ImageIcon(scaledTicket);
        JLabel lblImgScaled2 = new JLabel(imgScaled2);
        pnDatVe.add(lblImgScaled2);
      
        lblDatVe = new JLabel("Đặt vé");
        pnDatVe.add(lblDatVe);
        add(pnDatVe);
        

        
//      panel QL Khách hàng
        pnQLKhachHang = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
//      pnQLKhachHang.setBackground(Color.BLUE);
        pnQLKhachHang.setPreferredSize(new Dimension(190,50));
      
        ImageIcon imgQLKhachhang = new ImageIcon("img/people-icon.png");
        Image scaledQLKhachhang = scaleImage(imgQLKhachhang.getImage(), 30, 30);
        ImageIcon imgScaled3 = new ImageIcon(scaledQLKhachhang);
        JLabel lblImgScaled3 = new JLabel(imgScaled3);
        pnQLKhachHang.add(lblImgScaled3);
      
        lblQLKhachhang = new JLabel("Quản lí khách hàng");
        pnQLKhachHang.add(lblQLKhachhang);
        add(pnQLKhachHang);
        
        
//      panel QL Hóa đơn
        pnQLHoaDon = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
//      pnQLHoaDon.setBackground(Color.BLUE);
        pnQLHoaDon.setPreferredSize(new Dimension(190,50));
      
        ImageIcon imgQLHoadon = new ImageIcon("img/order-icon.png");
        Image scaledQLHoadon = scaleImage(imgQLHoadon.getImage(), 30, 30);
        ImageIcon imgScaled4 = new ImageIcon(scaledQLHoadon);
        JLabel lblImgScaled4 = new JLabel(imgScaled4);
        pnQLHoaDon.add(lblImgScaled4);
      
        lblQLHoadon = new JLabel("Quản lí hóa đơn");
        pnQLHoaDon.add(lblQLHoadon);
        add(pnQLHoaDon);
        
//        panel đẩy
        pnDay = new JPanel();
        pnDay.setBackground(orangeDark);
        pnDay.setPreferredSize(new Dimension(190,300));
        add(pnDay);
        
//      panel Đăng xuất
        pnDangxuat = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
//      pnDangxuat.setBackground(Color.BLUE);
        pnDangxuat.setPreferredSize(new Dimension(190,50));
      
        ImageIcon imgDangxuat = new ImageIcon("img/sign-out-icon.png");
        Image scaledDangxuat = scaleImage(imgDangxuat.getImage(), 30, 30);
        ImageIcon imgScaled5 = new ImageIcon(scaledDangxuat);
        JLabel lblImgScaled5= new JLabel(imgScaled5);
        pnDangxuat.add(lblImgScaled5);
      
        lblDangxuat = new JLabel("Đăng xuất");
        pnDangxuat.add(lblDangxuat);
        add(pnDangxuat);
        
        
        setBackground(orangeDark); // Thay đổi màu nền thành màu cam
        
        
        
        lblDatVe.addMouseListener(this);
        lblQLKhachhang.addMouseListener(this);
        lblQuanLi.addMouseListener(this);
    }

    private Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
		 
    }

	// Phương thức để thêm nút chức năng vào thanh menu
    private void addButton(String text, final String functionName) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.displayContent(functionName);
            }
        });
        add(button);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(lblDatVe)) {
            mainFrame.displayContent("QlBanVe");
        } else if (source.equals(lblQLKhachhang)) {
        	mainFrame.displayContent("QlKhachHang");
        }else if (source.equals(lblQuanLi)) {
        	mainFrame.displayContent("QlPhim");
        }
    }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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