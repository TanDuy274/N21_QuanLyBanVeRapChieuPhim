package ui;

import javax.swing.*;
import java.awt.*;

public class MovieManagementPanel extends JPanel {
    public MovieManagementPanel() {
        setLayout(new BorderLayout());
        add(new JLabel("Giao diện quản lý phim"), BorderLayout.CENTER);
    }
}
