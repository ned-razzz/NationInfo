
package View.Searchpage;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//검색창 패널
public class SearchManager extends JPanel {
	
	private SimpleSearch simple_search; //간편검색창
	private JButton enter_simsch_button;

//	private JPanel detail_search;
//	private PnSearch_result search_result; //결과창 패널
//	private PnMap_opened pnMap_opened; //지도 패널


	public SearchManager() {
		setFrame();
		defineComponents();
		this.add(simple_search);

	}

	private void setFrame() {
		this.setBounds(0, 0, 824, 461);
		this.setLayout(null);
	}

	//컴포넌트 설정
	private void defineComponents() {
		simple_search = new SimpleSearch();
		simple_search.setVisible(false);

		enter_simsch_button = simple_search.getEnterButton();
		enter_simsch_button.setBounds(741, 326, 59, 58);
		enter_simsch_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toggleSearchPanel();
			}
		});

		add(simple_search);
		add(enter_simsch_button);
	}

	private void toggleSearchPanel() {
		if (simple_search.isVisible() == false) {
			simple_search.setVisible(true);
		}
		else {
			simple_search.setVisible(false);
		}
	}

	public SimpleSearch getSimpleSearch() {
		return simple_search;
	}



	// 상세 검색 실행 버튼(detail_search_Button)
//		detail_search_Button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				tbCtris.setText(null);
//				con = new Controller();
//
//				Schema[] key = {"climate", "religion", "contry_code", "location", "area"};
//				ArrayList<String> value = new ArrayList<>();
//				value.add(select_Climate.getText());
//				value.add(select_Religion.getText());
//				value.add(select_code.getText());
//				value.add(select_location.getText());
//				value.add(select_area.getText());
//
//
//				ArrayList<String> result = con.detail_search(key, value);
//				for(int i = 0; i < result.size(); i++) {
//					tbCtris.append("● " + result.get(i) + "\n");
//				}
//			}
//		});
}
