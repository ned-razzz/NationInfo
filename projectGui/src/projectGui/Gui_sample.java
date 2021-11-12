package projectGui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Gui_sample {

	private JFrame main_Frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_sample window = new Gui_sample();
					window.main_Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui_sample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		main_Frame = new JFrame();
		main_Frame.setBounds(100, 100, 136, 556);
		main_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_Frame.setTitle("국정원");
		main_Frame.getContentPane().setLayout(null);
	
		
		//메인 패널
		JPanel main_Panel = new JPanel();
		main_Panel.setBounds(0, 0, 824, 461);
		main_Panel.setBackground(Color.WHITE);
		main_Frame.getContentPane().add(main_Panel);
		main_Panel.setLayout(null);
		main_Panel.setVisible(true);
		
		//검색창 이동 버튼
		JButton searchPanel_Button = new JButton("");
		searchPanel_Button.setIcon(new ImageIcon("C:\\Users\\dongdong\\Desktop\\green_Earth.png"));
		searchPanel_Button.setBounds(100, 240, 150, 130);
		searchPanel_Button.setBorderPainted(false);
		main_Panel.add(searchPanel_Button);
		
		//게임창 이동 버튼
		JButton gamePanel_Button = new JButton("");
		gamePanel_Button.setIcon(new ImageIcon("C:\\Users\\dongdong\\Desktop\\blue_Earth.png"));
		gamePanel_Button.setBounds(574, 240, 150, 130);
		gamePanel_Button.setBorderPainted(false);
		main_Panel.add(gamePanel_Button);
		
		//메인 타이틀 텍스트
		JLabel main_Title_label = new JLabel("Country Imformation Search");
		main_Title_label.setFont(new Font("Arial Black", Font.PLAIN, 19));
		main_Title_label.setBounds(262, 39, 300, 90);
		main_Panel.add(main_Title_label);
		
		//설정 진입 버튼
		JButton setup_Button = new JButton("");
		setup_Button.setForeground(Color.WHITE);
		setup_Button.setIcon(new ImageIcon("C:\\Users\\dongdong\\Desktop\\set_up_icon.png"));
		setup_Button.setBorderPainted(false);
		setup_Button.setBounds(750, 20, 40, 40);
		
		main_Panel.add(setup_Button);
		
		//국가검색진입 텍스트
		JLabel countrysearch_Label = new JLabel("Country Search");
		countrysearch_Label.setFont(new Font("Arial Black", Font.PLAIN, 12));
		countrysearch_Label.setBounds(130, 370, 100, 20);
		main_Panel.add(countrysearch_Label);
		
		//국가게임진입 텍스트
		JLabel countrygame_Label = new JLabel("Country Game");
		countrygame_Label.setFont(new Font("Arial Black", Font.PLAIN, 12));
		countrygame_Label.setBounds(600, 370, 100, 20);
		main_Panel.add(countrygame_Label);
		
		//설정진입 텍스트
		JLabel setup_Label = new JLabel("Set_up");
		setup_Label.setBounds(750, 60, 40, 15);
		main_Panel.add(setup_Label);
		
		/*JPanel setup_Panel = new JPanel();
		setup_Panel.setBounds(0, 0, 824, 461);
		main_Frame.getContentPane().add(setup_Panel);
		setup_Panel.setLayout(null);
		setup_Panel.setVisible(false);
		
		JComboBox language_Combobox = new JComboBox();
		language_Combobox.setBounds(260, 50, 480, 35);
		setup_Panel.add(language_Combobox);
		
		JLabel language_Label = new JLabel("Language");
		language_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		language_Label.setBounds(140, 50, 90, 35);
		setup_Panel.add(language_Label);
		
		JComboBox fontsize_Combobox = new JComboBox();
		fontsize_Combobox.setBounds(260, 130, 480, 35);
		setup_Panel.add(fontsize_Combobox);
		
		JLabel fontsize_Label = new JLabel("FontSize");
		fontsize_Label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		fontsize_Label.setBounds(140, 132, 90, 35);
		setup_Panel.add(fontsize_Label);
		
		JButton gotomain_Button = new JButton("");
		gotomain_Button.setIcon(new ImageIcon("C:\\Users\\dongdong\\Desktop\\home_icon.jpg"));
		gotomain_Button.setBounds(70, 380, 45, 45);
		setup_Panel.add(gotomain_Button);
		
		JLabel gotomain_Label = new JLabel("Goto_Main");
		gotomain_Label.setBounds(64, 436, 68, 15);
		setup_Panel.add(gotomain_Label);*/
		
	
		
		//패널 클래스로 가져오기 좀더 연구
		Setup_Panel1 setup_Panel=new Setup_Panel1();
		setup_Panel.setVisible(true);
		main_Frame.getContentPane().add(setup_Panel);
		main_Frame.pack();
		
		//설정창 진입 버튼 리스너
		setup_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setup_Panel.setVisible(true);
				main_Panel.setVisible(false);
			}
		});
		
		/*setup_Panel.gotomain_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_Panel.setVisible(true);
				setup_Panel.setVisible(false);
			}
		});*/
		
	}
}
