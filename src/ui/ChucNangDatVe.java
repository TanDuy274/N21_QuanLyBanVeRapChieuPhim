package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChucNangDatVe extends JPanel implements ActionListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;
	private JButton nextButton;
	private JButton prevButton;
	private JPanel panelButton;
	

    public ChucNangDatVe() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Tạo các bước trong quá trình đặt vé và thêm chúng vào CardLayout
        GiaoDienChonPhim step1Panel = new GiaoDienChonPhim();
        GiaoDienChonThoiGian step2Panel = new GiaoDienChonThoiGian();
        GiaoDienChonGhe step3Panel = new GiaoDienChonGhe();
        GiaoDienThanhToan step4Panel = new GiaoDienThanhToan();

        cardPanel.add(step1Panel, "step1");
        cardPanel.add(step2Panel, "step2");
        cardPanel.add(step3Panel, "step3");
        cardPanel.add(step4Panel, "step4");

        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);

        
        nextButton = new JButton("Next");
        prevButton = new JButton("Prev");
        
        nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(200, 40)); // Thay width và height bằng kích thước mong muốn

        prevButton = new JButton("Prev");
        prevButton.setPreferredSize(new Dimension(200, 40)); // Thay width và height bằng kích thước mong muốn

        nextButton.addActionListener(this);
        prevButton.addActionListener(this);
        
//        nextButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.next(cardPanel);
//                cardLayout.previous(cardPanel);
//            }
//        });
        panelButton = new JPanel();
        panelButton.add(prevButton);
        panelButton.add(nextButton);
        add(panelButton, BorderLayout.SOUTH);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(nextButton)) {
			cardLayout.next(cardPanel);
		}
		if(o.equals(prevButton)) {
			cardLayout.previous(cardPanel);
		}
	}
}
