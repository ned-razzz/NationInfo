package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

//첫화면을 보여주는 패널 클래스
public class PnFirst extends JPanel {

	public PnFirst() {
		setBounds(0, 0, 824, 461);
		setBackground(Color.WHITE);
		setLayout(null);
		setVisible(true);
		setBorder(new LineBorder(new Color(0,0,0), 2));
		
		//메인 타이틀 텍스트
		JLabel main_Title_label = new JLabel("");
		main_Title_label.setIcon(new ImageIcon("./images/Pnfirst_Title.PNG"));
		main_Title_label.setFont(new Font("Arial Black", Font.PLAIN, 19));
		main_Title_label.setBounds(262, 39, 300, 90);
		add(main_Title_label);
		
	
		//국가검색 진입 텍스트
		JLabel countrysearch_Label = new JLabel("");
		countrysearch_Label.setIcon(new ImageIcon("View/images/CountrySearch_label.png"));
		countrysearch_Label.setFont(new Font("Arial Black", Font.PLAIN, 12));
		countrysearch_Label.setBounds(120, 370, 126, 20);
		add(countrysearch_Label);
		
		//국가게임 진입 텍스트
		JLabel countrygame_Label = new JLabel("");
		countrygame_Label.setIcon(new ImageIcon("View/images/CountryGame_label.png"));
		countrygame_Label.setFont(new Font("Arial Black", Font.PLAIN, 12));
		countrygame_Label.setBounds(588, 370, 126, 20);
		add(countrygame_Label);
		
		
		
		
	}


}
