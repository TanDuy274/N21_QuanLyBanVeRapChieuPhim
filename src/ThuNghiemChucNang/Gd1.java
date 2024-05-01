package ThuNghiemChucNang;

//File Gd1.java
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gd1 extends JFrame implements ActionListener {
 public static String tenPhim;
 public static String thoiGian;
 public static String theLoai;
 private JTextField txtTenPhim;
 private JTextField txtTheLoai;
 private JTextField txtThoiGian;
 private JButton btnNext;
 private JPanel pn;

 public Gd1() {
     setTitle("Giao Diện 1");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setSize(400, 200);
     setLocationRelativeTo(null);

     txtTenPhim = new JTextField("Phim hoạt hình");
     txtThoiGian = new JTextField("120 phút");
     txtTheLoai = new JTextField("Hành động");

     btnNext = new JButton("Next");

     pn = new JPanel();
     pn.add(txtTenPhim);
     pn.add(txtThoiGian);
     pn.add(txtTheLoai);
     pn.add(btnNext);
     add(pn, BorderLayout.CENTER);

     btnNext.addActionListener(this);
 }

 public static void main(String[] args) {
     new Gd1().setVisible(true);
 }

 @Override
 public void actionPerformed(ActionEvent e) {
     Object o = e.getSource();
     if (o.equals(btnNext)) {
         tenPhim = txtTenPhim.getText();
         thoiGian = txtThoiGian.getText();
         theLoai = txtTheLoai.getText();

         Gd2 gd2 = new Gd2(tenPhim, thoiGian, theLoai);
         gd2.setVisible(true);
         setVisible(false);
     }
 }
}

