package game_panel_sample;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class game_result extends JPanel{
	public game_result() {
		this.setBounds(0, 0, 824, 461);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(120, 53, 577, 345);
		add(panel);
		panel.setLayout(null);
		
		JLabel game_result_Label = new JLabel("");
		game_result_Label.setIcon(new ImageIcon("C:\\Users\\dongdong\\eclipse-workspace\\game_panel_sample\\images\\game_result_text1.png"));
		game_result_Label.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 45));
		game_result_Label.setBounds(135, 43, 325, 70);
		panel.add(game_result_Label);
		
		JLabel correct_Label = new JLabel("New label");
		correct_Label.setIcon(new ImageIcon("C:\\Users\\dongdong\\eclipse-workspace\\game_panel_sample\\images\\game_result_text.png"));
		correct_Label.setBounds(51, 139, 313, 89);
		panel.add(correct_Label);
		
		JLabel user_correct_Label = new JLabel("10 개");
		user_correct_Label.setFont(new Font("굴림", Font.BOLD, 50));
		user_correct_Label.setBounds(376, 139, 148, 77);
		panel.add(user_correct_Label);
		
		JButton restart_Button = new JButton("");
		restart_Button.setIcon(new ImageIcon("C:\\Users\\dongdong\\eclipse-workspace\\game_panel_sample\\images\\game_restart_button.png"));
		restart_Button.setFont(new Font("굴림", Font.BOLD, 30));
		restart_Button.setBounds(131, 240, 313, 72);
		panel.add(restart_Button);
	}
}
