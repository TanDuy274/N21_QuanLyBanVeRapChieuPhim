package ThuNghiemChucNang;

//File Gd2.java
import javax.swing.*;
import java.awt.*;

public class Gd2 extends JFrame {
 private JTextField txtTenPhim;
 private JTextField txtTheLoai;
 private JTextField txtThoiGian;

 public Gd2(String tenPhim, String thoiGian, String theLoai) {
     setTitle("Giao Diện 2");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setSize(400, 200);
     setLocationRelativeTo(null);

     txtTenPhim = new JTextField(tenPhim);
     txtThoiGian = new JTextField(thoiGian);
     txtTheLoai = new JTextField(theLoai);

     JPanel pn = new JPanel();
     pn.add(txtTenPhim);
     pn.add(txtThoiGian);
     pn.add(txtTheLoai);

     add(pn, BorderLayout.CENTER);
 }
}

