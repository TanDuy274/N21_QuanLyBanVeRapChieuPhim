package ui;

import javax.swing.*;
import java.awt.*;

public class ThongKe extends JPanel {
    private JPanel panelThongKe1;
    private JPanel panelThongKe2;
    private JPanel panelThongKe3;
    private JPanel panelThongKe4;
    
    
    private JTabbedPane tabbedPanel;

    
    public ThongKe() {
        setLayout(new BorderLayout());     
        tabbedPanel = new JTabbedPane();
        tabbedPanel.add("Thống kê 1", new ThongKe1());       
        tabbedPanel.add("Thống kê 2", new ThongKe2());
        tabbedPanel.add("Thống kê 3", new ThongKe3());
        tabbedPanel.add("Thống kê 4", new ThongKe4());
        add(tabbedPanel, BorderLayout.CENTER);
    }
}
