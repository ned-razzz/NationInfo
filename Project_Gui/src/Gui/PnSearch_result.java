package Gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

//검색겨로가를 보여주는 패널
public class PnSearch_result extends JPanel {

	//생성자
	public PnSearch_result() {
		initialize();
	}
	
	private void initialize() {
		//기본옵션
		setBounds(0, 0, 824, 451);
		setLayout(null);
		
//		//버튼들이 모여있는 버튼패널
//		JPanel Button_Panel = new JPanel();
//		Button_Panel.setBounds(40, 61, 130, 49);
//		add(Button_Panel);
//		Button_Panel.setLayout(null);
		
		//국가정보를 보여주는 기능과 관련된 버튼 패널
		JPanel Country_Imformation_Button_Panel = new JPanel();
		Country_Imformation_Button_Panel.setBounds(40, 60, 130, 315);
		Country_Imformation_Button_Panel.setVisible(true);
		add(Country_Imformation_Button_Panel);
		Country_Imformation_Button_Panel.setLayout(null);
		
		//주요국가 버튼
		JButton a_major_city_Button = new JButton("a_major_city");
		a_major_city_Button.setIcon(new ImageIcon("./images/major_city.png"));
		a_major_city_Button.setBounds(0, 270, 130, 45);
		Country_Imformation_Button_Panel.add(a_major_city_Button);
		
		//한눈에 보기 버튼
		JButton at_a_look_Button = new JButton("at a look");
		at_a_look_Button.setIcon(new ImageIcon("./images/at_a_look_button2.png"));
		at_a_look_Button.setBounds(0, 22, 130, 45);
		Country_Imformation_Button_Panel.add(at_a_look_Button);
		
		//국가 정보 버튼
		JButton country_Button = new JButton("Country");
		country_Button.setIcon(new ImageIcon("./images/contry_button.png"));
		country_Button.setBounds(0, 73, 130, 45);
		Country_Imformation_Button_Panel.add(country_Button);
		
		//수도 정보 버튼
		JButton capital_Button = new JButton("Capital");
		capital_Button.setIcon(new ImageIcon("./images/capital.png"));
		capital_Button.setBounds(0, 123, 130, 45);
		Country_Imformation_Button_Panel.add(capital_Button);
		
		//기후 정보 버튼
		JButton climate_Button = new JButton("Climate");
		climate_Button.setIcon(new ImageIcon("./images/climate.png"));
		climate_Button.setBounds(0, 173, 130, 45);
		Country_Imformation_Button_Panel.add(climate_Button);
		
		//위치 정보 버튼
		JButton location_Button = new JButton("Location");
		location_Button.setIcon(new ImageIcon("./images/Location.png"));
		location_Button.setBounds(0, 222, 130, 45);
		Country_Imformation_Button_Panel.add(location_Button);
		

		//정보를 제공하는 패널
		JPanel Imformation_Panel = new JPanel();
		Imformation_Panel.setBounds(182, 70, 600, 315);
		add(Imformation_Panel);
		Imformation_Panel.setLayout(null);
		
	
		
		//정보를 보여주는 텍스트 에어리어
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 577, 315);
		Imformation_Panel.add(textArea);
		
		//스코를바
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(581, 0, 17, 315);
		Imformation_Panel.add(scrollBar);
		

	}
	
	
}