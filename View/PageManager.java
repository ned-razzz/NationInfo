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
enum VisitPage {
	MAIN,
	SEARCH,
	GAME,
	NEITHER;
}

public class PageManager {
	private MainPage main_page;
	private PnGame game_page;
	private SearchManager search_page;

	//Singleton Pattern
	public PageManager(MainPage main, SearchManager search, PnGame game) {
		main_page = main;
		search_page = search;
		game_page = game;
		main_page.setVisible(false);
		search_page.setVisible(false);
		game_page.setVisible(false);
	}

	//패널 이동 버튼 ActionListener 설정
	public void setBtnListener() {
		main_page.getSearchButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visitPanel(VisitPage.SEARCH);
			}
		});
		main_page.getGameButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visitPanel(VisitPage.GAME);
			}
		});
		main_page.getGobackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visitPanel(VisitPage.MAIN);
			}
		});
	}

	public void visitPanel(VisitPage visit_to) {
		main_page.setVisible(false);
		game_page.setVisible(false);
		search_page.setVisible(false);
		main_page.getGobackButton().setVisible(false);
		switch(visit_to) {
			case MAIN:
				main_page.setVisible(true);
				break;
			case SEARCH:
				search_page.setVisible(true);
				main_page.getGobackButton().setVisible(true);
				break;
			case GAME:
				game_page.setVisible(true);
				main_page.getGobackButton().setVisible(true);
				break;
			case NEITHER:
				break;
			default:
				System.out.println("\u001B[31m" + "visitPanel(): invalid penal");
				System.out.println("\t" + "\u001B[31m" + "at PnMain Class");
		}
	}
}
