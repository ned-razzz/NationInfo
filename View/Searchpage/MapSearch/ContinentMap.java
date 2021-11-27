package View.Searchpage.MapSearch;

import Enums.ImgData;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class ContinentMap extends JPanel {
	private JLabel conti_img;
	
	public ContinentMap() {
		setLayout(null);
		conti_img = new JLabel("");
		conti_img.setBounds(12, 10, 376, 431);
		add(conti_img);
		setVisible(true);
	}
	
	public void select(int con) {
		switch (con) {
			case 0:
				conti_img.setIcon(ImgData.AFRICA_MAP.getIcon());
			break;
			case 1:
				conti_img.setIcon(ImgData.ASIA_MAP.getIcon());
			break;
			case 2:
				conti_img.setIcon(ImgData.EUROPE_MAP.getIcon());
			break;
			case 3:
				conti_img.setIcon(ImgData.NORTH_AMERICA_MAP.getIcon());
			break;
			case 4:
				conti_img.setIcon(ImgData.SOUTH_AMERICA_MAP.getIcon());
			break;
			case 5:
				conti_img.setIcon(ImgData.OCEANIA_MAP.getIcon());
			break;
			default:
		}
	}
}
