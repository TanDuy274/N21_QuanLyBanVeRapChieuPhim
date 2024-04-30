package ui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class GiaoDienThanhToan extends JPanel {
    private JLabel lblTitle1;
	private JLabel lblTien;
	private JPanel pnThongTin;
	private JCheckBox checkBox;
	private JLabel lblSDT;
	private JTextField txtSDT;
	private JLabel lblHoTen;
	private JTextField txtHoTen;
	private JLabel lblGhiChu;
	private JTextArea txtGhiChu;
	private JButton btnThanhtoan;
	private JPanel pnSDT;
	private JPanel pnHoTen;
	private JPanel pnGhiChu;
	private JCheckBox checkBoxDaCoThe;
	private JCheckBox checkBoxLamThe;
	private JCheckBox checkBoxKhongThe;
	private JRadioButton radioButtonDaCoThe;
	private JRadioButton radioButtonLamThe;
	private JRadioButton radioButtonKhongThe;
	private JPanel pnTitle;
	private JLabel lblTuoi;
	private JTextField txtTuoi;
	private JPanel pnTuoi;

    public GiaoDienThanhToan() {
        setLayout(new BorderLayout());
        lblTitle1 = new JLabel("Chọn bắp/nước");
        pnTitle = new JPanel(new FlowLayout(FlowLayout.LEFT,20,80));
        pnTitle.add(lblTitle1);
        add(pnTitle, BorderLayout.NORTH);
       
        String[] columnNames = {"Combo", "Số lượng", "Đơn giá(VNĐ)", "Tổng(VNĐ)"};

        Object[][] data = {
                {"Pepsi vị chanh lớn", 0, 50000, 0},
                {"Bắp rang bơ vị phô mai vừa", 0, 50000, 0},
                {"Bắp rang bơ vị phô mai lớn", 0, 60000, 0},
                {"Pepsi vị chanh vừa", 0, 40000, 0}
        };

        //BẢNG
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(600, 200));
        table.setGridColor(Color.WHITE); // Set màu của đường biên
        table.setBorder(BorderFactory.createEmptyBorder()); // Đặt đường biên trống
        table.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font chữ
        table.setRowHeight(90); // Set chiều cao của mỗi dòng
        
        JScrollPane scrollPane = new JScrollPane(table);
        // Custom renderer cho cột "Combo"
        table.getColumnModel().getColumn(0).setCellRenderer(new ImageTextRenderer());
        // Tạo editor cho cột "Số lượng"
        TableColumn quantityColumn = table.getColumnModel().getColumn(1);
        quantityColumn.setCellEditor(new QuantityEditor());
        TableColumn quantityColumnSoluong = table.getColumnModel().getColumn(0); // Lấy cột "combo"
        quantityColumnSoluong.setPreferredWidth(200); // Đặt chiều rộng mong muốn

        // Set renderer cho các cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa dữ liệu
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); 
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer); // Căn giữa cột "Đơn giá(VNĐ)"
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer); // Căn giữa cột "Tổng(VNĐ)"

        // Set renderer cho tiêu đề cột
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD)); // In đậm tiêu đề
        //  HẾT BANG
        
        lblTien = new JLabel("Tiền sản phẩm:");
       
        Box box = Box.createVerticalBox();
        box.add(scrollPane);
        box.add(lblTien);
        
        
        // THÔNG TIN KHÁCH HÀNG, THANH TOÁN
        pnThongTin = new  JPanel();
        radioButtonDaCoThe = new JRadioButton("Đã có thẻ thành viên");
        radioButtonLamThe = new JRadioButton("Làm thẻ thành viên");
        radioButtonKhongThe = new JRadioButton("Không có thẻ thành viên");
        
        
        
        
        lblSDT = new JLabel("Số điện thoại:");
        txtSDT = new JTextField(40);
        lblHoTen = new JLabel("Họ và tên:");
        txtHoTen = new JTextField(40);
        lblTuoi = new JLabel("Tuổi");
        txtTuoi = new JTextField(40);
        lblGhiChu = new JLabel("Ghi chú:");
        txtGhiChu = new JTextArea(3,40);
        JScrollPane scrollPaneGhiChu = new JScrollPane(txtGhiChu);
        btnThanhtoan = new JButton("Thanh toán");
      
        pnSDT = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,10));
        pnSDT.add(lblSDT); pnSDT.add(txtSDT);
        pnHoTen = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,10));
        pnHoTen.add(lblHoTen); pnHoTen.add(txtHoTen);
        pnTuoi = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,10));
        pnTuoi.add(lblTuoi); pnTuoi.add(txtTuoi);
        pnGhiChu = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,10));
        pnGhiChu.add(lblGhiChu); pnGhiChu.add(scrollPaneGhiChu);
        
       
        pnThongTin.add(radioButtonLamThe);
        pnThongTin.add(radioButtonDaCoThe);
        pnThongTin.add(radioButtonKhongThe);
        pnThongTin.add(pnSDT);
        pnThongTin.add(pnHoTen);
        pnThongTin.add(pnTuoi);
        pnThongTin.add(pnGhiChu);
        pnThongTin.add(btnThanhtoan);
        
        radioButtonDaCoThe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  // Xử lý sự kiện khi radio button Đã có thẻ thành viên được chọn
                // Hiển thị input yêu cầu nhập số điện thoại
                lblSDT.setVisible(true);
                txtSDT.setVisible(true);
                lblGhiChu.setVisible(true);
                txtGhiChu.setVisible(true);
                // Ẩn input nhập họ tên 
                lblHoTen.setVisible(false);
                txtHoTen.setVisible(false);
               
            }
        });
        
        radioButtonLamThe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 // Xử lý sự kiện khi radio button Làm thẻ thành viên được chọn
                // Hiển thị input yêu cầu nhập số điện thoại và họ tên
                lblSDT.setVisible(true);
                txtSDT.setVisible(true);
                lblHoTen.setVisible(true);
                txtHoTen.setVisible(true);
                lblTuoi.setVisible(true);
                txtTuoi.setVisible(true);		
                lblGhiChu.setVisible(true);
                txtGhiChu.setVisible(true);
            }
        });
        
        radioButtonKhongThe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// Xử lý sự kiện khi radio button Không có thẻ thành viên được chọn
                // Hiển thị input yêu cầu nhập ghi chú
                lblGhiChu.setVisible(true);
                txtGhiChu.setVisible(true);
                lblTuoi.setVisible(true);
                txtTuoi.setVisible(true);
                // Ẩn input nhập số điện thoại và họ tên
                lblSDT.setVisible(false);
                txtSDT.setVisible(false);
                lblHoTen.setVisible(false);
                txtHoTen.setVisible(false);
            }
        });
        
        btnThanhtoan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Xử lý dữ liệu khi nhấn nút Submit
                if (checkBox.isSelected()) {
                    // Đã có thẻ thành viên
                    String sdt = txtSDT.getText();
                    String hoTen = txtHoTen.getText();
                    // Xử lý dữ liệu đã nhập
                    // Ví dụ: Hiển thị hoặc lưu vào cơ sở dữ liệu
                } else {
                    // Không có thẻ thành viên
                    String ghiChu = txtGhiChu.getText();
                    // Xử lý dữ liệu đã nhập
                    // Ví dụ: Hiển thị hoặc lưu vào cơ sở dữ liệu
                }
            }
        });
        
     // Tạo một nhóm để chỉ cho phép chọn một radio button trong nhóm
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonDaCoThe);
        buttonGroup.add(radioButtonLamThe);
        buttonGroup.add(radioButtonKhongThe);
        
        add(box, BorderLayout.WEST);
        add(pnThongTin, BorderLayout.CENTER);
        
    }

  

    // Renderer để chèn hình ảnh vào bên trái của văn bản
    static class ImageTextRenderer extends DefaultTableCellRenderer {
        private JLabel label = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Thay đổi đường dẫn tới hình ảnh của bạn
            ImageIcon imageIcon = new ImageIcon("img/bap-nuoc.png");
            Image scaledImage = scaleImage(imageIcon.getImage(), 60, 60);
            label.setIcon(new ImageIcon(scaledImage));
            label.setText(value.toString());
            return label;
        }

        private Image scaleImage(Image image, int w, int h) {
            return image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        }
    }

    // Editor cho cột "Số lượng"
    static class QuantityEditor extends AbstractCellEditor implements TableCellEditor {
        private JComboBox<Integer> comboBox;

        public QuantityEditor() {
            comboBox = new JComboBox<>();
            for (int i = 0; i <= 10; i++) {
                comboBox.addItem(i);
            }

            // Thêm sự kiện cho JComboBox
            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped(); // Khi giá trị được chọn thay đổi, chạy sự kiện fireEditingStopped
                }
            });
        }

        @Override
        public Object getCellEditorValue() {
            return comboBox.getSelectedItem(); // Trả về giá trị đã chọn trong JComboBox
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            comboBox.setSelectedItem(value); // Đặt giá trị mặc định cho JComboBox
            return comboBox; // Trả về JComboBox làm editor cho ô cụ thể
        }
    }
}
