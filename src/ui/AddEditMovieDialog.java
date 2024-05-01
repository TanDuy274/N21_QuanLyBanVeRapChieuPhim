package ui;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEditMovieDialog extends JDialog implements ActionListener {
    private JTextField tfMovieName;
    private JComboBox<String> comboCategory;
    private JDateChooser dateChooser;
    // Định nghĩa thêm các thành phần cần thiết khác

    public AddEditMovieDialog(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
        initComponents();
    }

    private void initComponents() {
    	// Đặt kích thước, vị trí, hiển thị dialog
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
//        setVisible(true); // Hiển thị dialog
        
        // Khởi tạo và cấu hình các thành phần như tfMovieName, comboCategory, dateChooser,...
        // Tạo các nút "Lưu" và "Hủy"
        JButton btnSave = new JButton("Lưu");
        JButton btnCancel = new JButton("Hủy");

        // Đặt sự kiện cho nút "Lưu" và "Hủy"
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);

        // Tạo và cấu hình layout
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(btnSave);
        panel.add(btnCancel);
        add(panel);

        // Thêm các thành phần vào dialog
        // Đặt kích thước, vị trí, hiển thị dialog
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Lưu")) {
            // Lấy thông tin từ các thành phần nhập liệu
            String movieName = tfMovieName.getText();
            String category = (String) comboCategory.getSelectedItem();
            // Lấy ngày từ dateChooser
            // Thực hiện thêm mới hoặc cập nhật bộ phim
            // Cập nhật hoặc thêm mới vào TableModel
            // Gọi fireTableDataChanged() để cập nhật giao diện
            // Đóng dialog
        } else if (e.getActionCommand().equals("Hủy")) {
            // Đóng dialog
        }
    }
}
