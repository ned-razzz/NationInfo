package game_panel_sample;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class game_main extends JPanel{
	public game_main() {
		this.setBounds(0, 0, 824, 461);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(120, 53, 577, 345);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dongdong\\eclipse-workspace\\game_panel_sample\\images\\game_text.png"));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel.setBounds(62, 47, 450, 70);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\dongdong\\eclipse-workspace\\game_panel_sample\\images\\start_button.png"));
		btnNewButton.setBounds(123, 203, 348, 65);
		panel.add(btnNewButton);
	}



}
