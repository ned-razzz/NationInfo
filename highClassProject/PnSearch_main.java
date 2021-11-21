package highClassProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class PnSearch_main extends JPanel {

	private JPanel pnSearch_Simple;
	private JPanel search_Simps;
	private PnSearch_result pnSearch_result;
	
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
//		ImageIcon imgBtStup = new ImageIcon("./Images/btStup2.PNG");
		ImageIcon imgBtSrch = new ImageIcon("./Images/btSrch2.PNG");
		ImageIcon imgBtMap = new ImageIcon("./Images/btMap2.PNG");
				
		pnSearch_Simple = new JPanel();
		pnSearch_Simple.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnSearch_Simple.setBounds(10, 10, 704, 451);
		this.add(pnSearch_Simple);
		pnSearch_Simple.setLayout(null);
			
		search_Simps = new JPanel();
		search_Simps.setBorder(new LineBorder(new Color(0, 0, 0)));
		search_Simps.setBounds(39, 31, 530, 342);
		pnSearch_Simple.add(search_Simps);
		search_Simps.setLayout(null);
		
		pnSearch_result = new PnSearch_result();
		add(pnSearch_result);
		pnSearch_result.setVisible(false);
		
		JTextArea txtName_sim = new JTextArea();
		txtName_sim.setBounds(0, 0, 530, 38);
		search_Simps.add(txtName_sim);
		txtName_sim.setText("* \uC774\uB984 \uAE30\uC785");
				
		JButton btCountry1 = new JButton("Country");
		btCountry1.setBounds(0, 38, 530, 40);
		search_Simps.add(btCountry1);
		
		
		
		JButton switch_Off = new JButton("\uC0C1\uC138-off");
		switch_Off.setBounds(595, 39, 97, 40);
		pnSearch_Simple.add(switch_Off);
		pnSearch_Simple.setVisible(false);

		JButton btMap_Closed = new JButton(new ImageIcon("./Images/mapClosed.PNG"));

		btMap_Closed.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btMap_Closed.setBounds(300, 10, 183, 436);
		this.add(btMap_Closed);

		JPanel pnSearch_Detail = new JPanel();
		pnSearch_Detail.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnSearch_Detail.setBounds(10, 10, 704, 451);
		this.add(pnSearch_Detail);
		pnSearch_Detail.setLayout(null);
		
		JTextArea tbCtris = new JTextArea();
		tbCtris.setBounds(297, 91, 374, 332);
		pnSearch_Detail.add(tbCtris);
		
		JTextArea txtName = new JTextArea();
		txtName.setBounds(36, 29, 448, 39);
		pnSearch_Detail.add(txtName);
		txtName.setText("* \uC774\uB984 \uAE30\uC785");
		

		JTextArea txtWth = new JTextArea();
		txtWth.setBounds(39, 115, 236, 32);
		pnSearch_Detail.add(txtWth);
		
	
		JTextArea txtRelig = new JTextArea();
		txtRelig.setBounds(39, 175, 236, 32);
		pnSearch_Detail.add(txtRelig);
		

		JTextArea txtCode = new JTextArea();
		txtCode.setBounds(39, 235, 236, 32);
		pnSearch_Detail.add(txtCode);

		JTextArea txtLoct = new JTextArea();
		txtLoct.setBounds(39, 295, 236, 32);
		pnSearch_Detail.add(txtLoct);

		JTextArea txtWidth = new JTextArea();
		txtWidth.setBounds(39, 355, 236, 32);
		pnSearch_Detail.add(txtWidth);

		JButton switch_On = new JButton("\uC0C1\uC138-on");
		switch_On.setBounds(595, 39, 97, 40);
		pnSearch_Detail.add(switch_On);
		
		//버튼 리스너
		txtWth.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String txt_content = txtWth.getText().strip();
					NationDataModel data_model = new NationDataModel();
					ArrayList<String> contry = data_model.find_contry("contry_code", txt_content);
					if(tbCtris.getText().equals("")) {
				        tbCtris.append("● " + contry.get(0) + "\n");
					} else {
						if(tbCtris.getText().contains(contry.get(0))) {
							tbCtris.setText("● " + contry.get(0) + "\n");
						} else {
							tbCtris.setText(null);
						}
					}
				}
			}
		});
		
		txtRelig.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String txt_content = txtRelig.getText().strip();
					NationDataModel data_model = new NationDataModel();
					ArrayList<String> contry = data_model.find_contry("religion", txt_content);
					Controller con = new Controller();
					contry = con.getmergesort(contry);
					
					if(tbCtris.getText().equals("")) {
						for(int i = 0; i < contry.size(); i++) {
							tbCtris.append("● " + contry.get(i) + "\n");
						}
					} else {
						String temp = tbCtris.getText();
						tbCtris.setText(null);
						for(int i = 0; i < contry.size(); i++) {
							if(temp.contains(contry.get(i))) {
								tbCtris.append("● " + contry.get(i) + "\n");
							}
						}
					}
				}
			}
		});
		
		txtCode.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String txt_content = txtCode.getText().strip();
					NationDataModel data_model = new NationDataModel();
					ArrayList<String> climate = data_model.find_contry("climate", txt_content);
					Controller con = new Controller();
					climate = con.getmergesort(climate);
					
					if(tbCtris.getText().equals("")) {
						for(int i = 0; i < climate.size(); i++) {
							tbCtris.append("● " + climate.get(i) + "\n");
						}
					} else {
						String temp = tbCtris.getText();		//온난 후 다습 입력하면 같은나라 두개뜨는 버그있음
						tbCtris.setText(null);
						for(int i = 0; i < climate.size(); i++) {
							if(temp.contains(climate.get(i))) {
								tbCtris.append("● " + climate.get(i) + "\n");
							}
						}
					}
				}
			}
		});
		
		txtLoct.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String txt_content = txtLoct.getText().strip();
					NationDataModel data_model = new NationDataModel();
					ArrayList<String> location = data_model.find_contry("location", txt_content);	//기독교, 다습, 아프리카 넣을 시 버그남
					Controller con = new Controller();
					location = con.getmergesort(location);
					
					if(tbCtris.getText().equals("")) {
						for(int i = 0; i < location.size(); i++) {
							tbCtris.append("● " + location.get(i) + "\n");
						}
					} else {
						String temp = tbCtris.getText();
						tbCtris.setText(null);
						for(int i = 0; i < location.size(); i++) {
							if(temp.contains(location.get(i))) {
								tbCtris.append("● " + location.get(i) + "\n");
							}
						}
					}
				}
			}
		});
		/*//JTable tbCtris = new JTable();
		JTextArea tbCtris = new JTextArea();
		tbCtris.setBounds(297, 91, 374, 332);
		pnSearch_Detail.add(tbCtris);*/

//		JButton btSetUp = new JButton(imgBtStup);
//		btSetUp.setBounds(741, 10, 59, 57);
//		this.add(btSetUp);

		JButton btSrch = new JButton(imgBtSrch);
		
		btSrch.setBounds(741, 326, 59, 58);
		this.add(btSrch);

		JPanel pnMap_Opened = new JPanel();
		pnMap_Opened.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnMap_Opened.setBounds(10, 10, 704, 451);
		this.add(pnMap_Opened);

		JButton btMap = new JButton(imgBtMap);
		btMap.setBounds(741, 394, 59, 57);
		this.add(btMap);

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