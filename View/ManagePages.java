package View;

import View.Gamepage.PnGame;
import View.Searchpage.SearchManager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
* 여러 패널들을 조정하고 소통시키는 패널 관리자 클래스
 */
public class ManagePages extends JPanel {
	private MainPage main_page;
	private PnGame game_page;
	private SearchManager search_page;

	public ManagePages() {
		setFrame();
		setPenals();
		setMoveListener();
		visitPanel("main");
	}

	//기본값 설정
	private void setFrame() {
		setBounds(0, 0, 836, 472);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setBorder(new LineBorder(new Color(0,0,0), 2));
	}

	private void setPenals() {
		//주요 패널 객체 설정
		main_page = new MainPage();
		game_page = new PnGame();
		search_page = new SearchManager();

		add(main_page);
		add(game_page);
		add(search_page);

		//초기 visible 설정
		main_page.setVisible(false);
		search_page.setVisible(false);
		game_page.setVisible(false);
	}

	//관리자 클래스에 의해 설정된 패널 이동 버튼 핸들러
	private void setMoveListener() {
		main_page.setBtnListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visitPanel("search");
			}
		},
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						visitPanel("game");
					}
				},
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						main_page.setVisible(true);
						setPenals();
					}
				});
	}

	public void visitPanel(String panel) {
		main_page.setVisible(false);
		game_page.setVisible(false);
		search_page.setVisible(false);
		switch(panel) {
			case "main":
				main_page.setVisible(true);
				break;
			case "search":
				search_page.setVisible(true);
				break;
			case "game":
				game_page.setVisible(true);
				break;
			default:
				System.out.println("\u001B[31m" + "visitPanel(): invalid penal");
				System.out.println("\t" + "\u001B[31m" + "at PnMain Class");
		}
	}

	public MainPage getMainPanel() {
		return main_page;
	}

	public SearchManager getSearchPanel() {
		return search_page;
	}
}
