package View;

import javax.swing.*;


public class ViewFrame extends JFrame {

	public final static int WIDTH = 840;
	public final static int HEIGHT = 500;
	public final static String TITLE = "Nation Data Search Program";

	private SetupPage setup_panel;
	private ManagePages main_panel;
	
	/**
	 * Create the application.
	 */
	public ViewFrame() {
		setup_panel = new SetupPage();
		main_panel = new ManagePages();
		setWindowFrame();
		constructComponents();
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

	private void constructComponents() {
		JButton setup_button = setup_panel.getSetupBtn();
		JButton return_main_button = main_panel.getMainPanel().getGobackButton();

		//UI에 추가
		getContentPane().add(main_panel);
		getContentPane().add(setup_panel);
		getContentPane().add(setup_button);
		getContentPane().add(return_main_button);

		//UI 요소 계층화 : 설정 버튼 및 설정창은 최상단에 위치
		JLayeredPane jlp = getLayeredPane();
		jlp.add(main_panel, JLayeredPane.DEFAULT_LAYER);
		jlp.add(setup_button, JLayeredPane.PALETTE_LAYER);
		jlp.add(return_main_button, JLayeredPane.PALETTE_LAYER);
		jlp.add(setup_panel, JLayeredPane.MODAL_LAYER);

		setup_button.setVisible(true);
		main_panel.setVisible(true);
	}

	public ManagePages getMainPanel() {
		return main_panel;
	}
}
