package View;

import View.Gamepage.*;
import View.Searchpage.SearchManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class ViewFrame extends JFrame {

	public final static int WIDTH = 840;
	public final static int HEIGHT = 500;
	public final static String TITLE = "Nation Data Search Program";

	private PageManager page_manager;
	private MainPage main_page;
	private SearchManager search_page;
	private GamePage game_page;
	private SetupPage setup_page;
	
	/**
	 * Create the application.
	 */
	public ViewFrame(ActionListener event_handler) {
		ControlHandler.setActionHandler(event_handler);
		setComponents();
		setWindowFrame();
		setLayers();
		System.out.println(getSize().width + " " + getSize().height);
	}

	/**
	 * Launch the application.
	 */
	public void launch() {
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void setWindowFrame() {
		setTitle(TITLE);
		setBounds(0, 0, WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	}

	private void setComponents() {
		Container content_pane = getContentPane();
		
		//주요 패널 객체 설정
		main_page = new MainPage();
		search_page = new SearchManager();
		setup_page = new SetupPage();
		game_page = new GamePage(content_pane);
		
		page_manager = new PageManager(main_page, search_page, game_page);
		page_manager.setMoveButtonListener();

		JButton setup_button = setup_page.getSetupButton();
		JButton goback_main_button = main_page.getGobackButton();
		setup_button.setBounds(WIDTH-70, 10, 40, 40);
		goback_main_button.setBounds(WIDTH-120, 10, 40, 40);
		System.out.println(goback_main_button.getSize().width);


		//UI에 추가
		content_pane.add(main_page);
		content_pane.add(game_page);
		content_pane.add(search_page);
		content_pane.add(setup_page);
		content_pane.add(setup_button);
		content_pane.add(goback_main_button);

		//초기 visible 설정
		page_manager.visitPanel(VisitPage.MAIN);
	}

	private void setLayers() {
		//UI 요소 계층화 : 설정 버튼 및 설정창은 최상단에 위치
		JLayeredPane jlp = getLayeredPane();
		jlp.add(main_page, JLayeredPane.DEFAULT_LAYER);
		jlp.add(search_page, JLayeredPane.DEFAULT_LAYER);
		jlp.add(game_page, JLayeredPane.DEFAULT_LAYER);
		jlp.add(main_page.getGobackButton(), JLayeredPane.PALETTE_LAYER);
		jlp.add(setup_page.getSetupButton(), JLayeredPane.MODAL_LAYER);
		jlp.add(setup_page, JLayeredPane.MODAL_LAYER);
	}

	public SearchManager getSearchPage() {
		return search_page;
	}
}
