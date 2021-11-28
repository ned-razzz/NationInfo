package View.Searchpage.MapSearch;

import Enums.ImgData;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class ContinentMap extends JLabel {
	
	public ContinentMap() {
		setLayout(null);
		setBounds(0, 0, 376, 431);
		setVisible(true);
	}
	
	public void select(int con) {
		switch (con) {
			case 0:
				setIcon(ImgData.AFRICA_MAP.getIcon());
			break;
			case 1:
				setIcon(ImgData.ASIA_MAP.getIcon());
			break;
			case 2:
				setIcon(ImgData.EUROPE_MAP.getIcon());
			break;
			case 3:
				setIcon(ImgData.NORTH_AMERICA_MAP.getIcon());
			break;
			case 4:
				setIcon(ImgData.SOUTH_AMERICA_MAP.getIcon());
			break;
			case 5:
				setIcon(ImgData.OCEANIA_MAP.getIcon());
			break;
			default:
		}
	}
}
