package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.LineBorder;
import Enums.ImageManager;

/**
 * 메인 화면을 담당하는 클래스
 */
public class MainPage extends JPanel {
	private JLabel main_title_label;
	private JLabel search_label;
	private JLabel game_label;
	
	private JButton search_panel_button;
	private JButton game_panel_button;
	private static JButton goback_main_button;

	public MainPage() {
		setFrame();
		setTitle();
		setButton();
		setLabel();
	}

	private void setFrame() {
		setBounds(0, 0, ViewFrame.WIDTH-16, ViewFrame.HEIGHT-39);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setBorder(new LineBorder(new Color(0,0,0), 2));
	}

	private void setButton() {
		//국가 검색 버튼
		search_panel_button = new JButton();
		search_panel_button.setIcon(ImageManager.GO_SEARCH.getIcon());
		search_panel_button.setBounds(100, 240, 150, 130);
		search_panel_button.setBorderPainted(false);
		add(search_panel_button);

		//게임 버튼
		game_panel_button = new JButton();
		game_panel_button.setIcon(ImageManager.GO_GAME.getIcon());
		game_panel_button.setBounds(574, 240, 150, 130);
		game_panel_button.setBorderPainted(false);
		add(game_panel_button);

		//메인화면으로 돌아가기 버튼
		goback_main_button = new JButton("");
		goback_main_button.setForeground(Color.WHITE);
		goback_main_button.setIcon(ImageManager.BACK_MAIN.getIcon());
	}
	
	//메인 화면 타이틀 이미지
	private void setTitle() {
		main_title_label = new JLabel("");
		main_title_label.setIcon(ImageManager.MAIN_TITLE.getIcon());
		main_title_label.setFont(new Font("Arial Black", Font.PLAIN, 19));
		main_title_label.setBounds(262, 39, 300, 90);
		add(main_title_label);
	}

	//버튼 텍스트
	private void setLabel() {
		//국가검색 진입 텍스트
		search_label = new JLabel("국가 검색");
		search_label.setFont(new Font("돋움",  Font.BOLD, 20));
		search_label.setBounds(110, 370, 126, 20);
		search_label.setHorizontalAlignment(JLabel.CENTER);
		add(search_label);

		//국가게임 진입 텍스트
		game_label = new JLabel("미니 게임");
		game_label.setFont(new Font("돋움", Font.BOLD, 20));
		game_label.setBounds(588, 370, 126, 20);
		game_label.setHorizontalAlignment(JLabel.CENTER);
		add(game_label);
	}

	public JButton getSearchButton() {
		return search_panel_button;
	}

	public JButton getGameButton() {
		return game_panel_button;
	}

	public JButton getGobackButton() {
		return goback_main_button;
	}

}
