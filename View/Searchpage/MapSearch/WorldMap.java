package View.Searchpage.MapSearch;

import Enums.ImgData;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class WorldMap extends JLabel {

	public WorldMap() {
		setIcon(ImgData.WORLD_MAP.getIcon());
		setBounds(0, 0, 700, 400);
		setLayout(null);
	}
}
