package Gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

//검색창 패널
public class PnSearch_main extends JPanel {

	
	private JPanel pnSearch_Simple; //간편검색
	private JPanel search_Simps;
	private PnSearch_result pnSearch_result; //결과창 패널
	
	public PnSearch_main() {
		this.setBounds(0, 0, 824, 461);
		this.setLayout(null);
//		this.add(pnSearch_Simple);
//		this.add(btMap_Closed);
//		this.add(pnSearch_Detail);
//		
//		this.add(pnMap_Opened);
//		this.add(btSetUp);
//		this.add(btSrch);
//		this.add(btMap);
		
		//images
		//ImageIcon imgBtStup = new ImageIcon("./Images/btStup2.PNG");
		
		// 이미지 아이콘 불러오기
		ImageIcon imgBtSrch = new ImageIcon("./Images/search_go.png");
		ImageIcon imgBtMap = new ImageIcon("./Images/map.png");
				
		//간편검색 패널 설정
		pnSearch_Simple = new JPanel();
		pnSearch_Simple.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnSearch_Simple.setBounds(10, 10, 704, 451);
		pnSearch_Simple.setLayout(null);
		this.add(pnSearch_Simple);
		
		// 검색 창 안의 패널 - 검색 입력칸과 검색 결과가 들어있음
		search_Simps = new JPanel();
		search_Simps.setBorder(new LineBorder(new Color(0, 0, 0)));
		search_Simps.setBounds(39, 31, 530, 342);
		pnSearch_Simple.add(search_Simps);
		search_Simps.setLayout(null);
		
		//결과창 패널 추가
		pnSearch_result = new PnSearch_result();
		this.add(pnSearch_result);
		pnSearch_result.setVisible(false);
		
		//간편 검색창 텍스트 에어리어
		JTextArea txtName_sim = new JTextArea();
		txtName_sim.setBounds(0, 0, 530, 38);
		txtName_sim.setText("* \uC774\uB984 \uAE30\uC785");
		search_Simps.add(txtName_sim);
				
		//나라 검색 결과 버튼(예시)
		JButton btCountry1 = new JButton("Country");
		btCountry1.setBounds(0, 38, 530, 40);
		search_Simps.add(btCountry1);
		
		//간편검색 오프버튼
		JButton switch_Off = new JButton("\uC0C1\uC138-off");
		switch_Off.setBounds(595, 39, 97, 40);
		pnSearch_Simple.add(switch_Off);
		pnSearch_Simple.setVisible(false);

		//맵 버튼
		JButton btMap_Closed = new JButton(new ImageIcon("./Images/mapClosed.PNG"));
		btMap_Closed.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btMap_Closed.setBounds(300, 10, 183, 436);
		this.add(btMap_Closed);

		//상세검색 패널
		JPanel pnSearch_Detail = new JPanel();
		pnSearch_Detail.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnSearch_Detail.setBounds(10, 10, 704, 451);
		this.add(pnSearch_Detail);
		pnSearch_Detail.setLayout(null);

		//상세검색 텍스트 에어리어, 텍스트 필드로 수정
		JTextArea txtName = new JTextArea();
		txtName.setBounds(150, 29, 400, 39);
		pnSearch_Detail.add(txtName);
		txtName.setText("* \uC774\uB984 \uAE30\uC785");

		//상세검색 콤보박스 기후
		JComboBox select_Climate = new JComboBox();
		select_Climate.setBounds(100, 115, 180, 32);
		pnSearch_Detail.add(select_Climate);
		JLabel select_climate_Label=new JLabel();
		select_climate_Label.setBounds(40,115,30,30);
		select_climate_Label.setText("기후");
		pnSearch_Detail.add(select_climate_Label);
		
		//상세검색 콤보박스 종교
		JComboBox select_Religion = new JComboBox();
		select_Religion.setBounds(100, 175, 180, 32);
		pnSearch_Detail.add(select_Religion);
		JLabel select_Religion_Label=new JLabel();
		select_Religion_Label.setBounds(40,175,30,30);
		select_Religion_Label.setText("종교");
		pnSearch_Detail.add(select_Religion_Label);

		//상세검색 콤보박스 국가코드
		JComboBox select_code = new JComboBox();
		select_code.setBounds(100, 235, 180, 32);
		pnSearch_Detail.add(select_code);
		JLabel select_code_Label=new JLabel();
		select_code_Label.setBounds(20,235,50,30);
		select_code_Label.setText("국가코드");
		pnSearch_Detail.add(select_code_Label);

		//상세검색 콤보박스 위치
		JComboBox select_location = new JComboBox();
		select_location.setBounds(100, 295, 180, 32);
		pnSearch_Detail.add(select_location);
		JLabel select_location_Label=new JLabel();
		select_location_Label.setBounds(40,295,30,30);
		select_location_Label.setText("위치");
		pnSearch_Detail.add(select_location_Label);
		
		//상세검색 콤보박스 넓이
		JComboBox select_area = new JComboBox();
		select_area.setBounds(100, 355, 180, 32);
		pnSearch_Detail.add(select_area);
		JLabel select_area_Label=new JLabel();
		select_area_Label.setBounds(40,355,30,30);
		select_area_Label.setText("넓이");
		pnSearch_Detail.add(select_area_Label);
		
		//상세검색 on/off 버튼
		JButton switch_On = new JButton("\uC0C1\uC138-on");
		switch_On.setBounds(595, 39, 97, 40);
		pnSearch_Detail.add(switch_On);

		//검색 결과 창(세부 검색창)
		JTable tbCtris = new JTable();
		tbCtris.setBounds(297, 91, 374, 332);
		pnSearch_Detail.add(tbCtris);

//		JButton btSetUp = new JButton(imgBtStup);
//		btSetUp.setBounds(741, 10, 59, 57);
//		this.add(btSetUp);

		//검색버튼(검색창으로 가는)
		JButton btSrch = new JButton(imgBtSrch);
		btSrch.setBounds(741, 326, 59, 58);
		this.add(btSrch);

		//열린지도창
		JPanel pnMap_Opened = new JPanel();
		pnMap_Opened.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnMap_Opened.setBounds(10, 10, 704, 451);
		this.add(pnMap_Opened);

		//지도버튼(지도 창으로 가는)
		JButton btMap = new JButton(imgBtMap);
		btMap.setBounds(741, 394, 59, 57);
		this.add(btMap);

	    // 검색 결과 창의 닫기 버튼 (여기서 선언하여 listener를 정의하여,
		// 다시 main 패널의 하위 패널을 보여줄 수 있게 함)
		JButton go_to_main_Button = new JButton("X");
		go_to_main_Button.setFont(new Font("Verdana", Font.BOLD, 15));
		go_to_main_Button.setBounds(12, 10, 43, 30);
		pnSearch_result.add(go_to_main_Button);
		
		btMap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnMap_Opened.setVisible(true);
				btMap_Closed.setVisible(false);
				pnSearch_Simple.setVisible(false);
				pnSearch_Detail.setVisible(false);
			}
		});

		btMap_Closed.setVisible(true);
		pnMap_Opened.setVisible(false);
		pnSearch_Detail.setVisible(false);

		btSrch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnMap_Opened.setVisible(false);
				btMap_Closed.setVisible(false);
				pnSearch_Simple.setVisible(true);
				pnSearch_Detail.setVisible(false);
			}
		});
		switch_Off.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnSearch_Detail.setVisible(true);
				pnSearch_Simple.setVisible(false);
			}
		});
		switch_On.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pnSearch_Simple.setVisible(true);
				pnSearch_Detail.setVisible(false);
			}
		});
			
		btMap_Closed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btMap_Closed.setVisible(false);
				pnMap_Opened.setVisible(true);
			}
		});
	
		btCountry1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnSearch_result.setVisible(true);
				pnSearch_Simple.setVisible(false);
				btSrch.setVisible(false);
				btMap.setVisible(false);
			}
		});
		
		go_to_main_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnSearch_result.setVisible(false);
				pnSearch_Simple.setVisible(true);
				btSrch.setVisible(true);
				btMap.setVisible(true);
			}
		});
	}
	
	
	private void invisible() {
		this.setVisible(false);
	}
	private void visible() {
		this.setVisible(true);
	}
	
}
