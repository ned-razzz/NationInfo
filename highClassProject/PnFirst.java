package highClassProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PnFirst extends JPanel {

	public PnFirst() {
		setBounds(0, 0, 824, 461);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setBorder(new LineBorder(new Color(0,0,0), 2));
		
		//메인 타이틀 텍스트
		JLabel main_Title_label = new JLabel("Country Imformation Search");
		main_Title_label.setFont(new Font("Arial Black", Font.PLAIN, 19));
		main_Title_label.setBounds(262, 39, 300, 90);
		add(main_Title_label);
		
		//설정 진입 버튼
//		JButton setup_Button = new JButton("");
//		setup_Button.setForeground(Color.WHITE);
//		setup_Button.setIcon(new ImageIcon("C:\\Users\\dongdong\\Desktop\\set_up_icon.png"));
//		setup_Button.setBorderPainted(false);
//		setup_Button.setBounds(750, 20, 40, 40);
//		add(setup_Button);
//		
		//국가검색진입 텍스트
		JLabel countrysearch_Label = new JLabel("Country Search");
		countrysearch_Label.setFont(new Font("Arial Black", Font.PLAIN, 12));
		countrysearch_Label.setBounds(130, 370, 100, 20);
		add(countrysearch_Label);
		
		//국가게임진입 텍스트
		JLabel countrygame_Label = new JLabel("Country Game");
		countrygame_Label.setFont(new Font("Arial Black", Font.PLAIN, 12));
		countrygame_Label.setBounds(600, 370, 100, 20);
		add(countrygame_Label);
		
		
	}


}