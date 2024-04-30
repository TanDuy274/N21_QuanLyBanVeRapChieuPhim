package ThuNghiemChucNang;

import javax.swing.*;

import dao.Phim_DAO;
import entity.Phim;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Page1 extends JFrame {
    private JComboBox<String> comboBox;
    private JButton btnNext;
    private Phim phim;
    private Phim_DAO phimdao;

    public Page1() {
        setTitle("Chọn Tên Phim");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        ArrayList<Phim> dsPhim = new Phim_DAO().getAllPhim();
        comboBox = new JComboBox<>();
        for (Phim phim : dsPhim) {
            comboBox.addItem(phim.getTenPhim());
        }
        panel.add(comboBox, BorderLayout.CENTER);

        btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMovieName = (String) comboBox.getSelectedItem();
                dispose(); // Đóng cửa sổ hiện tại
                new Page2(selectedMovieName).setVisible(true); // Hiển thị trang thứ hai và truyền tên phim đã chọn
            }
        });
        panel.add(btnNext, BorderLayout.SOUTH);

        add(panel);
    }

    public static void main(String[] args) {
        new Page1().setVisible(true);
    }
}

