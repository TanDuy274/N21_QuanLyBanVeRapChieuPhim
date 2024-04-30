package ThuNghiemChucNang;

import javax.swing.*;

import dao.Phim_DAO;
import entity.Phim;

import java.awt.*;
import java.util.ArrayList;

public class Page2 extends JFrame {
	private Phim phim;
    private Phim_DAO phimdao;
	private Phim selectedPhim;
    public Page2(String movieName) {
        setTitle("Thông Tin Phim");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Lấy thông tin phim dựa trên tên phim đã chọn
        new Phim_DAO().getPhimByTen(movieName);

        // Hiển thị thông tin phim
        JTextArea textArea = new JTextArea();
        textArea.append("Mã Phim: " + selectedPhim.getMaPhim() + "\n");
        textArea.append("Tên Phim: " + selectedPhim.getTenPhim() + "\n");
        textArea.append("Ngày Khởi Chiếu: " + selectedPhim.getNgayKhoiChieu() + "\n");
        textArea.append("Thời Lượng: " + selectedPhim.getThoiLuong() + "\n");
        textArea.append("Ngôn Ngữ: " + selectedPhim.getNgonNgu() + "\n");
        textArea.append("Giới Hạn Độ Tuổi: " + selectedPhim.getGioiHanDoTuoi() + "\n");
        textArea.append("Trạng Thái: " + (selectedPhim.getTrangThai() ? "Đang Chiếu" : "Ngừng Chiếu") + "\n");
        textArea.append("Poster: " + selectedPhim.getPoster() + "\n");
        textArea.append("Giá Tiền: " + selectedPhim.getGiaTien() + "\n");

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        add(panel);
    }

    public static void main(String[] args) {
        // Đoạn code dưới đây chỉ để kiểm tra trang Page2, thực tế không cần thiết khi đã có Page1
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Page2("Tên phim cần hiển thị").setVisible(true);
            }
        });
    }
}
