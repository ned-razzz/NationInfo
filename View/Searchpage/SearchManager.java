
package View.Searchpage;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 국가 검색 패널들 전체 관리
 */
public class SearchManager extends JPanel {
	private FilterSearchPanel filter_search; //간편검색창
	private MapSearchPanel map_search; //지도검색창

	private JButton enter_filtersch_button;
	private JButton enter_mapsch_button;

	public SearchManager() {
		setFrame();
		defineComponents();
	}

	private void setFrame() {
		this.setBounds(0, 0, 824, 461);
		this.setLayout(null);
	}

	//컴포넌트 설정
	private void defineComponents() {
		filter_search = new FilterSearchPanel();
		filter_search.setVisible(true);
		map_search = new MapSearchPanel();
		map_search.setVisible(false);


		enter_filtersch_button = filter_search.getEnterButton();
		enter_filtersch_button.setBounds(741, 326, 59, 58);
		enter_filtersch_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFilterPanel();
			}
		});

		enter_mapsch_button = map_search.getEnterButton();
		enter_mapsch_button.setBounds(741, 390, 59, 58);
		enter_mapsch_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toggleMapPanel();
			}
		});

		add(filter_search);
		add(map_search);
		add(enter_filtersch_button);
		add(enter_mapsch_button);
	}

	private void openFilterPanel() {
		filter_search.setVisible(true);
		map_search.setVisible(false);
	}

	private void toggleMapPanel() {
		map_search.setVisible(true);
		filter_search.setVisible(false);
	}

	public FilterSearchPanel getFilterPanel() {
		return filter_search;
	}

	public MapSearchPanel getMapPanel() {
		return map_search;
	}
}
