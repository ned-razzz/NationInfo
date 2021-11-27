package View.Searchpage.MapSearch;

import Enums.ImgData;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class WorldMap extends JPanel {
	private Image img;

	public WorldMap() {
		img = ImgData.WORLD_MAP.getIcon().getImage();
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
