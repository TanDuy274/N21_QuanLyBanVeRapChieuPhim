package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ScreenSize extends JFrame{
    public static void main(String[] args) {
        // Lấy kích thước màn hình
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // In ra chiều rộng và chiều cao của màn hình
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        System.out.println("Chiều rộng màn hình: " + width + " pixels");
        System.out.println("Chiều cao màn hình: " + height + " pixels");
        
     // Lấy kích thước của JFrame
        JFrame frame = new JFrame("Quản Lý Bán Hàng");
        ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ((JFrame) frame).getContentPane().add(new ChucNangDatVe());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        Dimension size = frame.getSize();
        int widthF = size.width;
        int heightF = size.height;
        System.out.println("Chiều rộng màn hình: " + widthF + " pixels");
        System.out.println("Chiều cao màn hình: " + heightF + " pixels");

    }
}
