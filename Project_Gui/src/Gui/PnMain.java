package Gui;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PnMain extends JPanel {

	public PnMain() {
		// TODO Auto-generated constructor stub
		
		
		setBounds(0, 0, 836, 472);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setBorder(new LineBorder(new Color(0,0,0), 2));
		
		PnSearch_main pnSearch_main = new PnSearch_main();
//		PnSearch_result pnSearch_result = new PnSearch_result();
		PnFirst pnFirst = new PnFirst();
		PnGame pnGame = new PnGame();
		
		
		this.add(pnFirst);
		this.add(pnSearch_main);
		this.add(pnGame);
//		this.add(pnSearch_result);
		pnFirst.setVisible(true);
		pnSearch_main.setVisible(false);
		pnGame.setVisible(false);
//		pnSearch_result.setVisible(false);
		
		// 내부 버튼
		JButton searchPanel_Button = new JButton("");
		searchPanel_Button.setIcon(new ImageIcon("C:\\Users\\dongdong\\Desktop\\green_Earth.png"));
		searchPanel_Button.setBounds(100, 240, 150, 130);
		searchPanel_Button.setBorderPainted(false);
		pnFirst.add(searchPanel_Button);
		
		JButton gamePanel_Button = new JButton("");
		gamePanel_Button.setIcon(new ImageIcon("C:\\Users\\dongdong\\Desktop\\blue_Earth.png"));
		gamePanel_Button.setBounds(574, 240, 150, 130);
		gamePanel_Button.setBorderPainted(false);
		pnFirst.add(gamePanel_Button);
		
		
		
		
		searchPanel_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnFirst.setVisible(false);
				pnSearch_main.setVisible(true);
			}
		});
		
		gamePanel_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnFirst.setVisible(false);
				pnGame.setVisible(true);
			}
		});
	}


}
