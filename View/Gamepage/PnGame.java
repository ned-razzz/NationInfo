package View.Gamepage;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

import Enums.ImageManager;
import Control.gameControl.Game;

public class PnGame extends JPanel{
	GameRun game_run;
	Game game;
	
	public PnGame(Container content_pane) {		
		game = new Game();
		game_run = new GameRun(content_pane, this, game);
		content_pane.add(game_run);
		
		this.setBounds(0, 0, 824, 461);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(120, 53, 577, 345);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(ImageManager.LABEL_GAME.getIcon());
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel.setBounds(62, 47, 450, 70);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(ImageManager.START_GAME.getIcon());
		btnNewButton.setBounds(123, 203, 348, 65);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game_run.init();
				setVisible(false);
			}
		});
	}
}