package ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import connectDB.ConnectDB;
import dao.LoaiPhim_DAO;
import dao.Phim_DAO;
import entity.LoaiPhim;
import entity.Phim;

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
    private JList<Phim> movieList;
    private DefaultListModel<Phim> movieListModel;

    private Phim_DAO movieDAO;
    private LoaiPhim_DAO categoryDAO;

    // biến global để lưu trữ thông tin phim
    public static String maPhimVar;
    public static String posterPathVar;
    public static String tenPhimVar;
    
    /**
     * 
     * get set mã, tên, hình
     */
    public String getTenPhim() {
    	return tenPhimVar;
    }
    
    public void setTenPhim(String tenPhimVar) {
    	this.tenPhimVar = tenPhimVar;
    }
    
    public String getMaPhim() {
    	return maPhimVar;
    }
    
    public void setMaPhim(String maPhimVar) {
    	this.maPhimVar = maPhimVar;
    }
    
    public String getPosterPath() {
    	return posterPathVar;
    }
    
    public void setPosterPath(String posterPathVar) {
    	this.posterPathVar = posterPathVar;
    }
    
    

    public GiaoDienChonPhim() {
        try {
            ConnectDB.getIntance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        movieDAO = new Phim_DAO();
        categoryDAO = new LoaiPhim_DAO();

        this.setLayout(new BorderLayout());
        JPanel wrapPanel = new JPanel();
        wrapPanel.setLayout(new BorderLayout());

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
        tfSearch.setBorder(new LineBorder(new Color(00, 153, 255), 2, true));

        btnSearch = new CustomButton(new ImageIcon("img//icons8-search-30.png"));
        btnSearch.setFocusPainted(false);
        btnSearch.setPreferredSize(new Dimension(100, 33));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Helvetica", Font.BOLD, 14));
        btnSearch.setBorder(new LineBorder(new Color(00, 153, 255), 2, true));
        btnSearch.setBackground(new Color(00, 153, 255));

        comboCategory = new JComboBox<String>();
        comboCategory.setBorder(new LineBorder(new Color(00, 153, 255), 2, getFocusTraversalKeysEnabled()));
        comboCategory.addItem("Tất cả");
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
        midPanel.setLayout(new BorderLayout());

        movieListModel = new DefaultListModel<>();
        movieList = new JList<>(movieListModel);
        movieList.setCellRenderer(new PhimListRenderer()); // Sử dụng renderer để hiển thị mỗi phim
        movieList.setLayoutOrientation(JList.HORIZONTAL_WRAP); // scroll dọc
//        movieList.setLayoutOrientation(JList.VERTICAL_WRAP); // scroll ngang
        movieList.setVisibleRowCount(-1); // hiển thị càng nhiều hàng càng tốt
        movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // chỉ cho phép chọn một phim
        JScrollPane scrollPane = new JScrollPane(movieList);
        midPanel.add(scrollPane, BorderLayout.CENTER);	
        
        wrapPanel.add(scrollPane, BorderLayout.CENTER);

        this.add(wrapPanel, BorderLayout.CENTER);
        
        movieList.addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Phim selectedMovie = movieList.getSelectedValue();
                    if (selectedMovie != null) {
//                        maPhimVar = selectedMovie.getMaPhim();
                    	setMaPhim(selectedMovie.getMaPhim());
//                        posterPathVar = selectedMovie.getPoster();
                    	setPosterPath(selectedMovie.getPoster());
//                        tenPhimVar = selectedMovie.getTenPhim();
                    	setTenPhim(selectedMovie.getTenPhim());
                        
                        JOptionPane.showMessageDialog(null, "Bạn đã chọn phim: " + tenPhimVar
                            + "\nMã: " + maPhimVar);
                    }
                }
            }
        });

        tfSearch.addFocusListener(this);
        btnSearch.addActionListener(this);
        comboCategory.addActionListener(this);

        loadMovieFromDatabase();
    }

    private void loadCategoryToComboBox() {
        List<LoaiPhim> categoryList = categoryDAO.getAllLoaiPhim();
        for (LoaiPhim loaiPhim : categoryList) {
            comboCategory.addItem(loaiPhim.getTenLoaiPhim());
        }
    }

    private void loadMovieFromDatabase() {
        List<Phim> movieListData = movieDAO.getAllPhim();
        List<LoaiPhim> categoryList = categoryDAO.getAllLoaiPhim();
        for (Phim movie : movieListData) {
        	for (LoaiPhim loaiPhim : categoryList) {
				if (movie.getLoaiPhim().getMaLoaiPhim().equals(loaiPhim.getMaLoaiPhim())) {
					movieListModel.addElement(movie);					
				}
			}
        }
    }

    private class PhimListRenderer extends JPanel implements ListCellRenderer<Phim> {
        private static final long serialVersionUID = 1L;

        private JLabel posterLabel = new JLabel();
        private JLabel titleLabel = new JLabel();
        private JLabel genreLabel = new JLabel();
        private JLabel lengthLabel = new JLabel();

        public PhimListRenderer() {
            setLayout(new BorderLayout());
            setPreferredSize(new Dimension(320, 420)); // scroll dọc
//            setPreferredSize(new Dimension(420, 600)); // scroll ngang
            
            add(posterLabel, BorderLayout.NORTH);
            Box bMovieDesc = Box.createVerticalBox();
            titleLabel.setFont(new Font("Helvetica", Font.BOLD, 18));
            bMovieDesc.add(titleLabel);
            genreLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
            bMovieDesc.add(genreLabel);
            lengthLabel.setFont(new Font("Helvetica", Font.PLAIN, 15));
            bMovieDesc.add(lengthLabel);

            add(bMovieDesc, BorderLayout.CENTER);
        }


        @Override
        public Component getListCellRendererComponent(JList<? extends Phim> list, Phim value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            ImageIcon poster = new ImageIcon("img//" + value.getPoster());
            Image scaled = scaleImage(poster.getImage(), 270, 320); // scroll dọc
//            Image scaled = scaleImage(poster.getImage(), 370, 480); // scroll ngang
            posterLabel.setIcon(new ImageIcon(scaled));
            titleLabel.setText(value.getTenPhim());
            String loai = "";
            List<LoaiPhim> categoryList = categoryDAO.getAllLoaiPhim();
            for (LoaiPhim loaiPhim : categoryList) {
				if (value.getLoaiPhim().getMaLoaiPhim().equals(loaiPhim.getMaLoaiPhim())) {
					loai = loaiPhim.getTenLoaiPhim();
				}
			}
            genreLabel.setText("Thể loại: " + loai);
            lengthLabel.setText("Thời lượng: " + value.getThoiLuong() + " phút");
            
            setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20)); // scroll dọc
//            setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20)); //scroll ngang
   
            return this;
        }

        private Image scaleImage(Image image, int w, int h) {
            Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            return scaled;
        }
    }

    
    /**
     * placeholder tìm kiếm
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

    /**
     * event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(comboCategory)) {
            String cate = (String) comboCategory.getSelectedItem();
            loadMoviesByCategoryFromDatabase(cate);
        } else if (o.equals(btnSearch)) {
            System.out.println(getMaPhim());
            String tenPhim = tfSearch.getText();
            if ((tenPhim.length() > 0)) {
                loadMoviesByNameFromDatabase(tenPhim);
                if (tenPhim.equals("Tìm kiếm phim theo tên")) {
                	movieListModel.clear();
                	loadMovieFromDatabase();
                }
            } else {
                movieListModel.clear();
                loadMovieFromDatabase();
            }
        }
    }

    private void loadMoviesByNameFromDatabase(String tenPhim) {
        movieListModel.clear();
        List<Phim> movieListData = movieDAO.getPhimByTen(tenPhim);
        for (Phim movie : movieListData) {
        	movieListModel.addElement(movie);					
        }
    }

    private void loadMoviesByCategoryFromDatabase(String cate) {
        movieListModel.clear();
        if (cate.equals("Tất cả")) {
            loadMovieFromDatabase();
        } else {
            List<Phim> movieListData = movieDAO.getPhimByLoaiPhim(cate);
            for (Phim movie : movieListData) {
            	movieListModel.addElement(movie);					
            }
        }
    }
    
    

}