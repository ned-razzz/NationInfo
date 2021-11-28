package View.Searchpage;

import Enums.BtnAction;
import Enums.ModernColor;
import Enums.Schema;
import View.ControlHandler;

import java.awt.*;
import java.util.HashMap;

import javax.swing.*;

import javax.swing.border.LineBorder;

/**
 * 검색 결과에서 특정 나라의 상세 정보 열람
 */
public class ResultInfo extends JDialog {
	private JTextArea info_document; //정보 내용
	public JScrollPane scroll_container;

	private JPanel menu_bar; //메뉴
	private JButton menu_brief; //국가 이름, 코드, 수도
	private JButton menu_region; //위치, 기후, 주요도시
	private JButton	menu_culture; //종교, 인종, 언어
	private JButton menu_area; //면적
	private JButton menu_source; //정보, 출처

	private HashMap<Schema, String> country_data;


	public ResultInfo(JFrame upper_frame, HashMap<Schema, String> get_data) {
		super(upper_frame, "검색 결과");
		country_data = get_data;
		setComps();
		setFrame();
	}

	private void setFrame() {
		setBounds(0, 0, 700, 400);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void setComps() {
		info_document = new JTextArea();
		info_document.setBorder(new LineBorder(ModernColor.BLACK.COLOR, 3));
		info_document.setLineWrap(true);

		scroll_container = new JScrollPane(info_document);
		scroll_container.setBounds(150, 40, 500, 300);
		scroll_container.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_container.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scroll_container);

		menu_bar = new JPanel();
		menu_bar.setBounds(10, 40, 130, 300);
		menu_bar.setVisible(true);
		menu_bar.setLayout(new GridLayout(0, 1, 0, 10));
		add(menu_bar);

		menu_brief = new JButton("기본 정보");
		menu_brief.setActionCommand(BtnAction.SEARCH_BRIEF.toString());
		menu_brief.setBounds(0, 20, 130, 45);
		menu_brief.setBackground(ModernColor.WHITE.COLOR);
		menu_bar.add(menu_brief);
		ControlHandler.addButton(menu_brief);

		menu_region = new JButton("지역 정보");
		menu_region.setActionCommand(BtnAction.SEARCH_REGION.toString());
		menu_region.setBounds(0, 70, 130, 45);
		menu_region.setBackground(ModernColor.WHITE.COLOR);
		menu_bar.add(menu_region);
		ControlHandler.addButton(menu_region);

		menu_culture = new JButton("문화 정보");
		menu_culture.setActionCommand(BtnAction.SEARCH_CULTURE.toString());
		menu_culture.setBounds(0, 120, 130, 45);
		menu_culture.setBackground(ModernColor.WHITE.COLOR);
		menu_bar.add(menu_culture);
		ControlHandler.addButton(menu_culture);

		menu_area = new JButton("면적 정보");
		menu_area.setActionCommand(BtnAction.SEARCH_AREA.toString());
		menu_area.setBounds(0, 170, 130, 45);
		menu_area.setBackground(ModernColor.WHITE.COLOR);
		menu_bar.add(menu_area);
		ControlHandler.addButton(menu_area);

		menu_source = new JButton("정보 출처");
		menu_source.setActionCommand(BtnAction.SEARCH_SOURE.toString());
		menu_source.setBounds(0, 220, 130, 45);
		menu_source.setBackground(ModernColor.WHITE.COLOR);
		menu_bar.add(menu_source);
		ControlHandler.addButton(menu_source);


	}

	public HashMap<Schema, String> getCountryData() {
		return country_data;
	}
	public void setinstruction(String str) {
		info_document.setText(str);
//		JScrollBar scroll_bar = scroll_container.getVerticalScrollBar();
//		scroll_bar.setValue(30);
	}
}