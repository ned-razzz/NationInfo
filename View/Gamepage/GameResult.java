package View.Gamepage;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Enums.ImageManager;

public class GameResult extends JPanel{
	JLabel user_correct_Label;
	
	public GameResult(PnGame pn) {
		this.setBounds(0, 0, 824, 461);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(120, 53, 577, 345);
		add(panel);
		panel.setLayout(null);
		
		JLabel game_result_Label = new JLabel("");
		game_result_Label.setIcon(ImageManager.GO_RESULT_GAME.getIcon());
		game_result_Label.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 45));
		game_result_Label.setBounds(135, 43, 325, 70);
		panel.add(game_result_Label);
		
		JLabel correct_Label = new JLabel("New label");
		correct_Label.setIcon(ImageManager.RESULT_GAME.getIcon());
		correct_Label.setBounds(51, 139, 313, 89);
		panel.add(correct_Label);
		
		user_correct_Label = new JLabel("");
		user_correct_Label.setFont(new Font("굴림", Font.BOLD, 50));
		user_correct_Label.setBounds(376, 139, 148, 77);
		panel.add(user_correct_Label);
		
		JButton restart_Button = new JButton("");
		restart_Button.setIcon(ImageManager.RESTART_GAME.getIcon());
		restart_Button.setFont(new Font("굴림", Font.BOLD, 30));
		restart_Button.setBounds(131, 240, 313, 72);
		panel.add(restart_Button);
		restart_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				pn.setVisible(true);
			}
		});
	}
	
	public void setResult(int score) {
		user_correct_Label.setText(score + "점");
	}
}
