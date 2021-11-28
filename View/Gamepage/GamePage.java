package View.Gamepage;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

import Enums.ImgData;

public class GamePage extends JPanel{
	GameRunner game_run;
	GameAlgorithm game;
	
	public GamePage(Container content_pane) {
		game = new GameAlgorithm();
		game_run = new GameRunner(content_pane, this, game);
		content_pane.add(game_run);

		setFrame();;
		defineComponents();
	}

	private void setFrame() {
		setBounds(0, 0, 824, 461);
		setLayout(null);
	}

	private void defineComponents() {
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(120, 53, 577, 345);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(ImgData.LABEL_GAME.getIcon());
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel.setBounds(62, 47, 450, 70);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(ImgData.START_GAME.getIcon());
		btnNewButton.setBounds(123, 203, 348, 65);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runGame();
			}
		});

		add(panel);
	}

	public void runGame() {
		game_run.init();
		setVisible(false);
	}
}