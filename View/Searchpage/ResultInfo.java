package View.Searchpage;

import Enums.BtnAction;
import Enums.ModernColor;
import View.ControlListeners;

import java.awt.*;
import java.util.HashMap;

import javax.swing.*;

import javax.swing.border.LineBorder;

/**
 * 검색 결과에서 특정 나라의 상세 정보 열람
 */
public class ResultInfo extends JDialog {
	private JTextArea info_document; //정보 내용
	private JPanel menu_bar; //메뉴
	private JButton menu_brief; //국가 이름, 코드, 수도
	private JButton menu_region; //위치, 기후, 주요도시
	private JButton	menu_culture; //종교, 인종, 언어
	private JButton menu_area; //면적
	private JButton menu_source; //정보, 출처

	private HashMap<String, String> data;


	public ResultInfo(JFrame upper_frame, HashMap<String, String> get_data) {
		super(upper_frame, "검색 결과");
		data = get_data;
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

		menu_bar = new JPanel();
		menu_bar.setBounds(10, 40, 130, 300);
		menu_bar.setVisible(true);
		menu_bar.setLayout(new GridLayout(0, 1, 0, 10));
		add(menu_bar);

		menu_brief = new JButton("기본 정보");
		menu_brief.setActionCommand(BtnAction.LOOKFOR_BRIEF.toString());
		menu_brief.setBounds(0, 20, 130, 45);
		menu_brief.setBackground(ModernColor.WHITE.COLOR);
		menu_bar.add(menu_brief);
		ControlListeners.addButtonHandler(menu_brief);

		menu_region = new JButton("지역 정보");
		menu_region.setActionCommand(BtnAction.LOOKFOR_REGION.toString());
		menu_region.setBounds(0, 70, 130, 45);
		menu_region.setBackground(ModernColor.WHITE.COLOR);
		menu_bar.add(menu_region);
		ControlListeners.addButtonHandler(menu_region);

		menu_culture = new JButton("문화 정보");
		menu_culture.setActionCommand(BtnAction.LOOKFOR_CULTURE.toString());
		menu_culture.setBounds(0, 120, 130, 45);
		menu_culture.setBackground(ModernColor.WHITE.COLOR);
		menu_bar.add(menu_culture);
		ControlListeners.addButtonHandler(menu_culture);

		menu_area = new JButton("면적 정보");
		menu_area.setActionCommand(BtnAction.LOOKFOR_AREA.toString());
		menu_area.setBounds(0, 170, 130, 45);
		menu_area.setBackground(ModernColor.WHITE.COLOR);
		menu_bar.add(menu_area);
		ControlListeners.addButtonHandler(menu_area);

		menu_source = new JButton("정보 출처");
		menu_source.setActionCommand(BtnAction.LOOKFOR_SOURE.toString());
		menu_source.setBounds(0, 220, 130, 45);
		menu_source.setBackground(ModernColor.WHITE.COLOR);
		menu_bar.add(menu_source);
		ControlListeners.addButtonHandler(menu_source);

		JScrollPane scroll = new JScrollPane(info_document);
		scroll.setBounds(150, 40, 500, 300);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setAutoscrolls(true);
		add(scroll);
	}

//
//	//버튼리스너
//		at_a_look_Button.addActionListener(new ActionListener() {
//
//		public void actionPerformed(ActionEvent e) {
//			textArea.setText(null);
////				con.get_ColumnInfo().entrySet().stream().forEach(entry -> {
////		            textArea.append("● " + entry.getKey() + "\t" + entry.getValue() + "\n");
////		        });
//
//		}
//	});
//
//		a_major_city_Button.addActionListener(new ActionListener() {
//
//		public void actionPerformed(ActionEvent e) {
//			textArea.setText(null);
////				con.get_ColumnInfo().entrySet().stream().filter(entry -> entry.getKey().equals("major_cities")).forEach(entry -> {
////					textArea.append("● " + entry.getKey() + ": " + entry.getValue());
////		        });
//
//		}
//	});
//
//		capital_Button.addActionListener(new ActionListener() {
//
//		public void actionPerformed(ActionEvent e) {
//			textArea.setText(null);
////				con.get_ColumnInfo().entrySet().stream().filter(entry -> entry.getKey().equals("capital")).forEach(entry -> {
////					textArea.append("● " + entry.getKey() + ": " + entry.getValue());
////		        });
//
//		}
//	});
//
//		climate_Button.addActionListener(new ActionListener() {
//
//		public void actionPerformed(ActionEvent e) {
//			textArea.setText(null);
////				con.get_ColumnInfo().entrySet().stream().filter(entry -> entry.getKey().equals("climate")).forEach(entry -> {
////					textArea.append("● " + entry.getKey() + ": " + entry.getValue());
////		        });
//
//		}
//	});
//
//		location_Button.addActionListener(new ActionListener() {
//
//		public void actionPerformed(ActionEvent e) {
//			textArea.setText(null);
////				con.get_ColumnInfo().entrySet().stream().filter(entry -> entry.getKey().equals("location")).forEach(entry -> {
////					textArea.append("● " + entry.getKey() + ": " + entry.getValue());
////		        });
//
//		}
//	});

}