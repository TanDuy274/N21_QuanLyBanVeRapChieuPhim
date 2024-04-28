package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import connectDB.ConnectDB;
import dao.LoaiPhim_DAO;
import dao.Phim_DAO;
import entity.LoaiPhim;
import entity.Phim;
import ui.CustomButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author nguyentrunghau
 */

public class GiaoDienChonPhim extends JPanel implements ActionListener, FocusListener {
	private static final long serialVersionUID = 1L;
	private JTextField tfSearch;
    private JButton btnSearch;
    private JComboBox<String> comboCategory;
	private JPanel midContainer;
	
	private Phim_DAO movieDAO;
	private LoaiPhim_DAO categoryDAO;
	private JButton btnBooking;
	
	public final String maPhim = "";
	
	/*
	 * Mã màu: #0080ff - button xanh
	 */
	
    public GiaoDienChonPhim() {
        /**
         * Kết nối DB
         */
        try {
			ConnectDB.getIntance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        /**
         * DAO
         */
        movieDAO = new Phim_DAO();
        categoryDAO = new LoaiPhim_DAO();
        
        this.setLayout(new BorderLayout());
        JPanel wrapPanel = new JPanel();
        wrapPanel.setLayout(new BorderLayout());
        wrapPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JPanel topPanel = new JPanel();
        Box topContainer = Box.createVerticalBox();
        Box topTitle = Box.createHorizontalBox();
        Box topTools = Box.createHorizontalBox();

        JLabel lblTitle = new JLabel("CHỌN PHIM");
        lblTitle.setFont(new Font("Helvetica", Font.BOLD, 20));

        JLabel lblSearch = new JLabel("Tìm kiếm phim: ");
        lblSearch.setFont(new Font("Helvetica", Font.BOLD, 14));
        JLabel lblCategory = new JLabel("Thể loại: ");
        lblCategory.setFont(new Font("Helvetica", Font.BOLD, 14));
        
        tfSearch = new JTextField(30);
        tfSearch.setPreferredSize(new Dimension(300, 33));
        tfSearch.setToolTipText("Tìm kiếm phim");
        tfSearch.setText("Tìm kiếm phim theo tên");
        tfSearch.setFont(new Font("Helvetica", Font.ITALIC, 15));
        tfSearch.setForeground(Color.LIGHT_GRAY);
        tfSearch.setBorder(new LineBorder(Color.blue, 2, true));
        
        btnSearch = new CustomButton(new ImageIcon("img//icons8-search-30.png"));  
        btnSearch.setPreferredSize(new Dimension(100, 33));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Helvetica", Font.BOLD, 14));
        btnSearch.setBorder(new LineBorder(Color.decode("#0080ff"), 2, true));
        btnSearch.setBackground(Color.decode("#0080ff"));

        comboCategory = new JComboBox<String>();
        comboCategory.setBorder(new LineBorder(Color.blue, 2, getFocusTraversalKeysEnabled()));
        loadCategoryToComboBox();

        topTitle.add(lblTitle);
        topTools.add(lblSearch);
        topTools.add(Box.createHorizontalStrut(10));
        topTools.add(tfSearch);
        topTools.add(Box.createHorizontalStrut(20));
        topTools.add(btnSearch);
        topTools.add(Box.createHorizontalStrut(25));
        topTools.add(lblCategory);
        topTools.add(Box.createHorizontalStrut(10));
        topTools.add(comboCategory);

        topContainer.add(topTitle);
        topContainer.add(Box.createVerticalStrut(10));
        topContainer.add(topTools);
        topContainer.add(Box.createVerticalStrut(10));

        topPanel.add(topContainer);

        wrapPanel.add(topPanel, BorderLayout.NORTH);
        
        // Container phim
        JPanel midPanel = new JPanel();
        
        midContainer = new JPanel();
        midContainer = new JPanel(new GridBagLayout());
        midContainer.setDoubleBuffered(true);
        midPanel.add(midContainer, BorderLayout.CENTER);
        midPanel.setBackground(Color.LIGHT_GRAY);
        midPanel.setBackground(Color.decode("#e1e1e1"));
        
        JScrollPane scrollPane = new JScrollPane(midPanel);
        wrapPanel.add(scrollPane, BorderLayout.CENTER);
        
        this.add(wrapPanel, BorderLayout.CENTER);
        
        // Add event
        tfSearch.addFocusListener(this);
        comboCategory.addActionListener(this);
        
        // Load danh sách phim từ database vào panel
        loadMovieFromDatabase();
    }
    
    private void loadCategoryToComboBox() {
    	List<LoaiPhim> categoryList = categoryDAO.getAllLoaiPhim();
    	for (LoaiPhim loaiPhim : categoryList) {
			comboCategory.addItem(loaiPhim.getTenLoaiPhim());
		}
    }
    
    private void loadMovieFromDatabase() {
    	List<Phim> movieList = movieDAO.getAllPhim();
    	List<LoaiPhim> categoryList = categoryDAO.getAllLoaiPhim();
    	
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(25, 15, 25, 15); // Khoảng cách giữa các ô
//        for (int i = 0; i < 12; i++) { // hiển thị 12 phim
//            JPanel moviePanel = createMoviePanel("img//cai-gia-cua-hanh-phuc.jpg", 
//            		"Tên phim dàiiiiiiiiiiiii" + (i + 1), "Đạo diễn: ABC", "Hành động", 120);
//            
//            midContainer.add(moviePanel, gbc);
//            gbc.gridx++;
//            if (gbc.gridx > 3) { // Số cột tối đa là 4, sau đó chuyển sang hàng mới
//                gbc.gridx = 0;
//                gbc.gridy++;
//            }
//        }

        for (Phim movie : movieList) {
        	for (LoaiPhim loaiPhim : categoryList) {
				if (movie.getLoaiPhim().getMaLoaiPhim().equals(loaiPhim.getMaLoaiPhim())) {
					
					JPanel moviePanel = createMoviePanel("img//" + movie.getPoster(), 
							movie.getTenPhim(), loaiPhim.getTenLoaiPhim(), movie.getThoiLuong(), movie.getMaPhim());
					
					midContainer.add(moviePanel, gbc);
					gbc.gridx++;
					if (gbc.gridx > 3) { // Số cột tối đa là 4, sau đó chuyển sang hàng mới
						gbc.gridx = 0;
						gbc.gridy++;
					}
				}
			}
		}
    }
    

    // Tạo một panel cho mỗi phim
    private JPanel createMoviePanel(String posterPath, String title, String genre, double length, String maphim) { //, String director
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        ImageIcon imgTmp = new ImageIcon(posterPath);
        Image scaled = scaleImage(imgTmp.getImage(), 220, 285); // 190 285
        ImageIcon poster = new ImageIcon(scaled);
        JLabel posterLabel = new JLabel(poster);
        
        Box bMovieDesc = Box.createVerticalBox();
        String truncatedTitle = title.length() > 30 ? title.substring(0, 30) + "..." : title;
        JLabel titleLabel = new JLabel(truncatedTitle);

        // Thiết lập kích thước cố định cho tiêu đề
        titleLabel.setPreferredSize(new Dimension(100, 30));

        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
//        JLabel directorLabel = new JLabel(director); // Đạo diễn
        JLabel genreLabel = new JLabel("Thể loại: " + genre);
        JLabel lengthLabel = new JLabel("Thời lượng: " + length + " phút");
        bMovieDesc.add(titleLabel);
//        bMovieDesc.add(directorLabel);
        bMovieDesc.add(genreLabel);
        bMovieDesc.add(lengthLabel);
        
        btnBooking = new JButton("Đặt vé");
        btnBooking.setBackground(Color.decode("#0080ff"));
        btnBooking.setForeground(Color.white);
        btnBooking.setPreferredSize(new Dimension(0, 30));
        btnBooking.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        // gắn sự kiện
        btnBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "Bạn đã chọn phim: " + title
            			+ "\nMã: " + maphim);
//            	JOptionPane.showMessageDialog(null, posterPath);
            	
            }
        });
        
        panel.add(posterLabel, BorderLayout.NORTH);
        panel.add(bMovieDesc, BorderLayout.CENTER);
        panel.add(btnBooking, BorderLayout.SOUTH);
        return panel;
    }

    private Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;	 
    }

	/**
     *
     * Placeholder
     */
    @Override
    public void focusGained(FocusEvent e) {
        if (tfSearch.getText().equals("Tìm kiếm phim theo tên")) {
            tfSearch.setFont(new Font("Helvetica", Font.PLAIN, 15));
            tfSearch.setForeground(Color.BLACK);
            tfSearch.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (tfSearch.getText().equals("")) {
            tfSearch.setFont(new Font("Helvetica", Font.ITALIC, 15));
            tfSearch.setForeground(Color.LIGHT_GRAY);
            tfSearch.setText("Tìm kiếm phim theo tên");
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(comboCategory)) {
			String cate = (String) comboCategory.getSelectedItem();
			loadMoviesByCategoryFromDatabase(cate);
		}
	}

	private void loadMoviesByCategoryFromDatabase(String cate) {
		
	}

}
